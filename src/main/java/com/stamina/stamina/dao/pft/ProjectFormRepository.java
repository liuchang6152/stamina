package com.stamina.stamina.dao.pft;

import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 模块编号：ProjectFormRepository
 *
 * @author: weijian.hou
 * 创建时间：2019-5-28
 * 修改编号：1
 * 描    述：项目清单
 */
public interface ProjectFormRepository extends JpaRepository<ProjectFormPojo, Long>{


    List<ProjectFormPojo> findByprojectName(String projectName);
}
