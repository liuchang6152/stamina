package com.stamina.stamina.dao.pft;

import com.stamina.stamina.pojo.pft.ProjectFractionPojo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 模板编号：ProjectFractionRepository
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：测试项目分数
 */
public interface ProjectFractionRepository extends JpaRepository<ProjectFractionPojo, Long>,ProjectFractionRepositoryCustom {


}
