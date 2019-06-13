package com.stamina.stamina.service.serviceImpl.pft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.*;
import com.stamina.stamina.pojo.pft.*;
import com.stamina.stamina.service.pft.PhysicalService;
import com.stamina.stamina.service.pft.TestersAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * 模块编号：pcitc_ecs_bll_bc_AddressBookServiceImpl
 * 作       者：t-weijian.hou
 * 创建时间：2019年5月31日
 * 修改编号：1
 * 描       述：体能服务逻辑层实现类
 */
@Service
public class PhysicalServiceImpl implements PhysicalService {

    @Autowired
    private ProjectFractionRepository projectFractionRepository;

    @Autowired
    private ProjectFormRepository projectFormRepository;

    @Autowired
    private ProjectRawDataRepository projectRawDataRepository;

    @Autowired
    private ScoreConfigureRepository scoreConfigureRepository;

    @Autowired
    private TestersAttributeRepository testersAttributeRepository;

    @Override
    @Transactional
    public CommonResult physicalServiceinfo(String json) throws Exception {
        CommonResult commonResult = new CommonResult();

        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("params");
            JSONArray jsonArray = (JSONArray) jsonObject1.get("data");
            //批次编码生成
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = sdf.format(date);
            String fatch = projectFractionRepository.findCount();
            String code = dateStr+fatch;
            //code = new StringBuffer("2019061220190612001");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Object o : jsonArray) {
                List<String> str = (List) o;
                //项目原始清单
                ProjectRawDataPojo projectRawDataPojo = new ProjectRawDataPojo();
                projectRawDataPojo.setRawprojectBatchcode(code);
                projectRawDataPojo.setRawprojectProplecode(str.get(0));
                projectRawDataPojo.setRawprojectCompany(str.get(3));
                projectRawDataPojo.setRawprojectName(str.get(1));
                Integer projectValue = (int)(Double.valueOf(str.get(2))*100);
                projectRawDataPojo.setRawprojectValue(Long.valueOf(projectValue.toString()));
                projectRawDataPojo.setRawprojectTime(format.parse(str.get(4)));
                projectRawDataPojo.setRawprojectRepeatdata(str.get(5));
//               projectRawDataRepository.save(projectRawDataPojo);
            }
            commonResult = recalculate(code);
        }catch (Exception ex){
            ex.getMessage();
            commonResult.setMessage("失败！");
            throw new Exception(ex.getMessage());

        }
        return commonResult;
    }


    /**
     * 分数计算服务
     * @return
     */
    @Override
    public CommonResult recalculate(String batch) throws Exception{
        CommonResult commonResult = new CommonResult();
        try {
            //处理项目原始清单中的数据
            List<ProjectFormPojo> all = projectFormRepository.findAll();
            for (ProjectFormPojo projectFormPojo : all) {
                ProjectRawDataPojo projectRawDataPojo = new ProjectRawDataPojo();
                projectRawDataPojo.setRawprojectName(projectFormPojo.getAbroadNameCode());
                projectRawDataPojo.setRawprojectBatchcode(batch);
                Example<ProjectRawDataPojo> example = Example.of(projectRawDataPojo);
                //批次
                //给原始数据分组
                ProjectFractionPojo projectFractionPojo = new ProjectFractionPojo();
                List<ProjectRawDataPojo> all1 = projectRawDataRepository.findAll(example);
                if(all1.size()>0){
                    ProjectRawDataPojo rawDataPojo = all1.get(0);
                    projectFractionPojo.setProjectCompany(rawDataPojo.getRawprojectCompany());
                    projectFractionPojo.setProjectBatchcode(batch);
                    projectFractionPojo.setProjectName(rawDataPojo.getRawprojectName());
                    projectFractionPojo.setProjectValue(rawDataPojo.getRawprojectValue());
                    projectFractionPojo.setProjectTime(rawDataPojo.getRawprojectTime());
                    projectFractionPojo.setRawprojectPeoplecode(rawDataPojo.getRawprojectProplecode());
                    Integer scoreconfigureMany = projectFormPojo.getScoreconfigureMany();
                    //确定数值
                    Long value = rawDataPojo.getRawprojectValue();
                    switch (scoreconfigureMany) {
                        //最大值
                        case 0:
                            Long value1 = Long.valueOf(Integer.MIN_VALUE);
                            for (ProjectRawDataPojo dataPojo : all1) {
                                if (dataPojo.getRawprojectValue() /100  > value1) {
                                    value1 = dataPojo.getRawprojectValue() / 100;
                                }
                            }
                            value = value1;
                            break;
                        //最小值
                        case 1:
                            Long value2 = Long.valueOf(Integer.MAX_VALUE);
                            for (ProjectRawDataPojo dataPojo : all1) {
                                if (dataPojo.getRawprojectValue() / 100 < value2) {
                                    value2 = dataPojo.getRawprojectValue() / 100;
                                }
                                value = value2;
                            }
                            break;
                        //平均值
                        case 2:
                            Long value3 = 0l;
                            for (ProjectRawDataPojo dataPojo : all1) {
                                value3 = dataPojo.getRawprojectValue() / 100 + value3;
                            }
                            value = value3 / all1.size();
                            break;
                    }
                    projectFractionPojo.setProjectValue(value);
                    //判定分数
                    Long score = 0l;
                    List<ScoreConfigurePojo> byprojectFormId = scoreConfigureRepository.findByprojectFormId(projectFormPojo.getProjectformId());
                    for (ScoreConfigurePojo scoreConfigurePojo : byprojectFormId) {
                        if (scoreConfigurePojo.getScoreconfigureLow() <= value && value < scoreConfigurePojo.getScoreconfigureHigh()) {
                            score = scoreConfigurePojo.getScoreconfigureFraction();
                        }
                    }
                    projectFractionPojo.setProjectFraction(score);
                    projectFractionRepository.save(projectFractionPojo);
                }
            }

            //查询原始记录  这一批次的
            ProjectRawDataPojo projectRawDataPojo = new ProjectRawDataPojo();
            projectRawDataPojo.setRawprojectBatchcode(batch);
            Example<ProjectRawDataPojo> example = Example.of(projectRawDataPojo);
            List<ProjectRawDataPojo> all1 = projectRawDataRepository.findAll(example);


            for (ProjectRawDataPojo projectRawDataPojo1 : all1) {
                //人员
                TestersAttributePojo testersAttributePojo = new TestersAttributePojo();
                testersAttributePojo.setRawprojectBatchcode(batch);
                testersAttributePojo.setRawprojectPeoplecode(projectRawDataPojo1.getRawprojectProplecode());
                Example<TestersAttributePojo> exampletest = Example.of(testersAttributePojo);
                List<TestersAttributePojo> all2 = testersAttributeRepository.findAll(exampletest);
                if (all2.size() < 1) {
                    //增加人员
                    TestersAttributePojo testersAttributePojo1 = new TestersAttributePojo();
                    testersAttributePojo1.setRawprojectBatchcode(batch);
                    testersAttributePojo1.setRawprojectPeoplecode(projectRawDataPojo1.getRawprojectProplecode());
                    testersAttributePojo1.setTestersName(projectRawDataPojo1.getRawprojectBatchcode());
                    testersAttributeRepository.save(testersAttributePojo1);
                }
            }
            //计算总分
            TestersAttributePojo testersAttributePojo1 = new TestersAttributePojo();
            testersAttributePojo1.setRawprojectBatchcode(batch);
            Example<TestersAttributePojo> exampletest = Example.of(testersAttributePojo1);
            List<TestersAttributePojo> all2 = testersAttributeRepository.findAll(exampletest);
            Long score = 0l;
            for (TestersAttributePojo testersAttributePojo : all2) {
                ProjectFractionPojo projectFractionPojo1 = new ProjectFractionPojo();
                projectFractionPojo1.setProjectBatchcode(batch);
                projectFractionPojo1.setRawprojectPeoplecode(testersAttributePojo.getRawprojectPeoplecode());
                Example<ProjectFractionPojo> pojoExample = Example.of(projectFractionPojo1);
                List<ProjectFractionPojo> all3 = projectFractionRepository.findAll(pojoExample);
                for (ProjectFractionPojo projectFractionPojo : all3) {
                    score = score + projectFractionPojo.getProjectValue();
                }
                testersAttributePojo.setTestersTotalscore(score);
                testersAttributeRepository.save(testersAttributePojo);
                score=0l;
            }
            commonResult.setIsSuccess(true);
            commonResult.setMessage("成功！");
        }catch (Exception ex){
            ex.getMessage();
            commonResult.setMessage("失败！");
            throw new Exception(ex.getMessage());
        }
        return commonResult;
    }

}
