package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectRawDataRepository;
import com.stamina.stamina.dao.pft.TestersAttributeRepository;
import com.stamina.stamina.entity.pft.PhysicalBatchQueryEntity;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;
import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import com.stamina.stamina.service.pft.ProjectRawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public CommonResult physicalBatchQuery() {

        CommonResult commonResult = new CommonResult();

        try {

            List<PhysicalBatchQueryEntity> returnList = new ArrayList<>();

            List<Object[]> list = projectRawDataRepository.physicalBatchQuery();
            for (int i=0; i<list.size(); i++) {
                PhysicalBatchQueryEntity entity = new PhysicalBatchQueryEntity();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
                Object[] objects = list.get(i);
                entity.setProjectrawdataId(i+1L);
                entity.setRawprojectBatchcode((String) objects[0]);
                entity.setTestNumber((BigInteger) objects[1]);
                entity.setRawprojectTime(sdf.format((Date) objects[2]));
                returnList.add(entity);
            }

            commonResult.setResult(returnList);
            commonResult.setIsSuccess(true);
            commonResult.setMessage("查询成功");
        } catch (Exception e) {
            commonResult.setIsSuccess(false);
            commonResult.setMessage("查询失败");
        }

        return commonResult;
    }

}
