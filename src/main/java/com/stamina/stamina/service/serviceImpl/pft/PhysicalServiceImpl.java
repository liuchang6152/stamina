package com.stamina.stamina.service.serviceImpl.pft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectFormRepository;
import com.stamina.stamina.dao.pft.ProjectFractionRepository;
import com.stamina.stamina.dao.pft.ProjectRawDataRepository;
import com.stamina.stamina.dao.pft.ScoreConfigureRepository;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.pojo.pft.ProjectFractionPojo;
import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import com.stamina.stamina.pojo.pft.ScoreConfigurePojo;
import com.stamina.stamina.service.pft.PhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

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

    @Override
    public CommonResult physicalServiceinfo(String json) {
        CommonResult commonResult = new CommonResult();

        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("params");
            JSONArray jsonArray = (JSONArray) jsonObject1.get("data");
            //批次编码生成
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = sdf.format(date);
            StringBuffer code = new StringBuffer(dateStr);
            String fatch = projectFractionRepository.findCount();
            code.append(dateStr+fatch);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Object o : jsonArray) {
                String[] str = (String[]) o;
                //项目原始清单
                ProjectRawDataPojo projectRawDataPojo = new ProjectRawDataPojo();
                projectRawDataPojo.setRawprojectBatchcode(code.toString());
                //projectFractionPojo.setProjectCompany();
                projectRawDataPojo.setRawprojectProplecode(str[0]);
                projectRawDataPojo.setRawprojectName(str[1]);
                projectRawDataPojo.setRawprojectValue(Long.valueOf(str[2])*100);
                projectRawDataPojo.setRawprojectTime(format.parse(str[4]));
                projectRawDataPojo.setRawprojectRepeatdata(str[5]);
                projectRawDataRepository.save(projectRawDataPojo);
            }

            //处理项目原始清单中的数据
            List<ProjectFormPojo> all = projectFormRepository.findAll();
            for (ProjectFormPojo projectFormPojo : all) {
                ProjectRawDataPojo projectRawDataPojo = new ProjectRawDataPojo();
                projectRawDataPojo.setRawprojectName(projectFormPojo.getAbroadNameCode());
                Example<ProjectRawDataPojo> example = Example.of(projectRawDataPojo);
                //批次
//                projectRawDataPojo.setRawprojectBatchcode(dateStr);
                //给原始数据分组
                ProjectFractionPojo projectFractionPojo = new ProjectFractionPojo();
                List<ProjectRawDataPojo> all1 = projectRawDataRepository.findAll(example);
                for (ProjectRawDataPojo rawDataPojo : all1) {
                    projectFractionPojo.setProjectCompany(rawDataPojo.getRawprojectCompany());
                    projectFractionPojo.setProjectBatchcode(dateStr);
                    projectFractionPojo.setProjectName(rawDataPojo.getRawprojectName());
                    projectFractionPojo.setProjectValue(rawDataPojo.getRawprojectValue());
                    projectFractionPojo.setProjectTime(rawDataPojo.getRawprojectTime());
                    projectFractionPojo.setRawprojectPeoplecode(rawDataPojo.getRawprojectProplecode());
                    Integer scoreconfigureMany = projectFormPojo.getScoreconfigureMany();
                    //确定数值
                    Long value = rawDataPojo.getRawprojectValue();
                    switch (scoreconfigureMany){
                        //最大值
                        case 0:
                            Long value1 = Long.valueOf(Integer.MIN_VALUE);
                            for (ProjectRawDataPojo dataPojo : all1) {
                                if(dataPojo.getRawprojectValue()>value1){
                                    value1 = dataPojo.getRawprojectValue()/100;
                                }
                            }
                            value = value1;
                            break;
                            //最小值
                        case 1:
                            Long value2 = Long.valueOf(Integer.MAX_VALUE);
                            for (ProjectRawDataPojo dataPojo : all1) {
                                if(dataPojo.getRawprojectValue()<value2){
                                    value2 = dataPojo.getRawprojectValue()/100;
                                }
                                value = value2;
                            }
                            break;
                            //平均值
                        case 2:
                            Long value3 = 0l;
                            for (ProjectRawDataPojo dataPojo : all1) {
                                    value2 = dataPojo.getRawprojectValue()/100 +value3;
                            }
                            value = value3/all1.size();
                            break;
                    }
                    projectFractionPojo.setProjectValue(value);
                    //判定分数
                    Long score = 0l;
                    List<ScoreConfigurePojo> byprojectFormId = scoreConfigureRepository.findByprojectFormId(projectFormPojo.getProjectformId());
                    for (ScoreConfigurePojo scoreConfigurePojo : byprojectFormId) {
                        if(scoreConfigurePojo.getScoreconfigureLow()<=value&&value<scoreConfigurePojo.getScoreconfigureHigh()){
                            score = scoreConfigurePojo.getScoreconfigureFraction();
                        }
                    }
                    projectFractionPojo.setProjectFraction(score);
                    projectFractionRepository.save(projectFractionPojo);
                }
            }
            commonResult.setIsSuccess(true);
            commonResult.setMessage("成功！");
        }catch (Exception ex){
            commonResult.setMessage("失败！");
        }
        return commonResult;
    }


    /**
     * 分数计算服务
     * @return
     */
    public CommonResult recalculate(){

        return null;
    }

}
