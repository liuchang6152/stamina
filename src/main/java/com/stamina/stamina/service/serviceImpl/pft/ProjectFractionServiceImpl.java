package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectFractionRepository;
import com.stamina.stamina.entity.pft.ProjectFractionEntity;
import com.stamina.stamina.pojo.pft.ProjectFractionPojo;
import com.stamina.stamina.service.pft.ProjectFractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/4
 * 修改编号：
 * 描述：
 */
@Service
public class ProjectFractionServiceImpl implements ProjectFractionService {

    @Autowired
    private ProjectFractionRepository projectFractionRepository;

    @Override
    public CommonResult getProjectFractioList(String projectBatchcode, String rawprojectPeoplecode) throws Exception {

        CommonResult commonResult = new CommonResult();
        try {
            List<ProjectFractionEntity> projectFractionEntityList = new ArrayList<>();
            List<ProjectFractionPojo> list = projectFractionRepository.findByProjectBatchcodeAndRawprojectPeoplecode(projectBatchcode, rawprojectPeoplecode);
            for (ProjectFractionPojo pojo : list) {
                ProjectFractionEntity projectFractionEntity = new ProjectFractionEntity();
                projectFractionEntity.setProjectfractionId(pojo.getProjectfractionId());
                projectFractionEntity.setProjectName(pojo.getProjectName());
                projectFractionEntity.setProjectValue(pojo.getProjectValue());
                projectFractionEntity.setProjectCompany(CommonEnum.Unit.getName(Integer.parseInt(pojo.getProjectCompany())));
                projectFractionEntity.setProjectFraction(pojo.getProjectFraction());
                projectFractionEntityList.add(projectFractionEntity);
            }
            commonResult.setResult(projectFractionEntityList);
            commonResult.setIsSuccess(true);
            commonResult.setMessage("查询成功");
        } catch (Exception e) {
            commonResult.setIsSuccess(false);
            commonResult.setMessage("查询失败");
        }
        return commonResult;
    }
}
