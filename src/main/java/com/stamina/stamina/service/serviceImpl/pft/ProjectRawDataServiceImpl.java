package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectRawDataRepository;
import com.stamina.stamina.dao.pft.TestersAttributeRepository;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;
import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import com.stamina.stamina.service.pft.ProjectRawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：
 */
@Service
public class ProjectRawDataServiceImpl implements ProjectRawDataService {

    @Autowired
    private ProjectRawDataRepository projectRawDataRepository;

    @Autowired
    private TestersAttributeRepository testersAttributeRepository;

    @Override
    public CommonResult getProjectRawData(String rawprojectBatchcode, String rawprojectProplecode) {

        CommonResult commonResult = new CommonResult();

        List<ProjectRawDataEntity> list = null;
        try {
            List<ProjectRawDataPojo> pojoList = projectRawDataRepository.findByRawprojectBatchcodeAndRawprojectProplecode(rawprojectBatchcode, rawprojectProplecode);
            list = new ArrayList();
            for (ProjectRawDataPojo pojo : pojoList) {
                ProjectRawDataEntity entity = new ProjectRawDataEntity();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
                entity.setProjectrawdataId(pojo.getProjectrawdataId());
                entity.setRawprojectName(pojo.getRawprojectName());
                entity.setRawprojectValue(pojo.getRawprojectValue());
                entity.setRawprojectCompany(CommonEnum.Unit.getName(Integer.parseInt(pojo.getRawprojectCompany())));
                entity.setRawprojectTime(sdf.format(pojo.getRawprojectTime()));
                list.add(entity);
            }
            commonResult.setResult(list);
            commonResult.setIsSuccess(true);
            commonResult.setMessage("查询成功");
        } catch (NumberFormatException e) {
            commonResult.setIsSuccess(false);
            commonResult.setMessage("查询失败");
        }

        return commonResult;
    }

    /*@Override
    public List getProjectRawData(String rawProjectBatchCode, String beginTime, String endTime) throws Exception {

        List pageList = new ArrayList();
        List<ProjectRawDataPojo> ProjecTrawDataList = projectRawDataRepository.findGroupByRawProjectBatchCode();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        for (int i=0; i<ProjecTrawDataList.size(); i++) {

            ProjectRawDataPojo pojo = ProjecTrawDataList.get(i);
            int testNum = testersAttributeRepository.findCount(pojo.getRawprojectBatchcode());
            ProjectRawDataEntity2 entity2 = new ProjectRawDataEntity2();
            entity2.setProjectrawdataId(i+1L);
            entity2.setRawprojectBatchcode(pojo.getRawprojectBatchcode());
            entity2.setTestNumber(testNum);
            entity2.setRawprojectTime(sdf.parse(pojo.getRawprojectTime().toString()));
            pageList.add(entity2);

        }
        return pageList;
    }
*/
}
