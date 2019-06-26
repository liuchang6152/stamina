package com.stamina.stamina.dao.pft;

import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 模板编号：ProjectRawDataRepository
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：测试项目原始属性
 */
public interface ProjectRawDataRepository extends JpaRepository<ProjectRawDataPojo, Long>, JpaSpecificationExecutor, ProjectRawDataRepositoryCustom {

    // @Query(value = "select * FROM t_pft_projectrawdata a WHERE a.RAWPROJECT_BATCHCODE =?1 AND a.RAWPROJECT_PROPLECODE =?2  ORDER BY CONVERT (a.RAWPROJECT_NAME USING gbk) COLLATE gbk_chinese_ci ASC",nativeQuery = true)
    // 根据 RAWPROJECT_NAME 字段的长短 降序
    @Query(value = "select * FROM t_pft_projectrawdata a WHERE a.RAWPROJECT_BATCHCODE =?1 AND a.RAWPROJECT_PROPLECODE =?2  ORDER BY LENGTH(a.RAWPROJECT_NAME) ", nativeQuery = true)
    List<ProjectRawDataPojo> findByRawprojectBatchcodeAndRawprojectProplecode(String rawprojectBatchcode, String rawprojectProplecode);

    @Query(value = "SELECT * FROM t_pft_physicalbatchquery", nativeQuery = true)
    List physicalBatchQuery();
}
