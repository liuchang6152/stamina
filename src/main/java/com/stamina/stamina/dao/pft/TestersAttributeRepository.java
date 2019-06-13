package com.stamina.stamina.dao.pft;

import com.stamina.stamina.pojo.pft.TestersAttributePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 模板编号：TestersAttributeRepository
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：测试人员表
 */
public interface TestersAttributeRepository extends JpaRepository<TestersAttributePojo, Integer>,JpaSpecificationExecutor<TestersAttributePojo>,TestersAttributeRepositoryCustom {

    @Query(value = "SELECT COUNT(*) FROM t_pft_projectrawdata WHERE RAWPROJECT_BATCHCODE = ?", nativeQuery = true)
    int findCount(String rawprojectBatchcode) throws Exception;


}
