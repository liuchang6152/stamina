package com.stamina.stamina.dao.daoImpl;

import com.stamina.stamina.common.util.BaseRepository;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.dao.pft.TestersAttributeRepositoryCustom;
import com.stamina.stamina.pojo.pft.TestersAttributePojo;
import org.hibernate.mapping.List;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/13
 * 修改编号：
 * 描述：
 */
public class TestersAttributeRepositoryImpl extends BaseRepository<TestersAttributePojo, Integer> implements TestersAttributeRepositoryCustom {

    @Override
    public PaginationBean<List> getTestersList2(String rawprojectBatchcode, String testersName, String testersGender, Long beginScore, Long endScore, Pagination page) throws Exception {

        try {
            StringBuilder hql = new StringBuilder("select t from TestersAttributePojo t where 1=1");
            HashMap<String, Object> paramlist = new HashMap<>();
            if (!StringUtils.isEmpty(rawprojectBatchcode)) {
                hql.append(" and t.rawprojectBatchcode = :rawprojectBatchcode");
                paramlist.put("rawprojectBatchcode", rawprojectBatchcode);
            }
            if (!StringUtils.isEmpty(testersName)) {
                hql.append(" and t.testersName like :testersName");
                paramlist.put("testersName", "%" + this.sqlLikeReplace(testersName) +"%");
            }
            if (!StringUtils.isEmpty(testersGender)) {
                hql.append(" and t.testersGender = :testersGender");
                paramlist.put("testersGender", testersGender);
            }
            if (!StringUtils.isEmpty(beginScore)) {
                hql.append(" and t.testersTotalscore > :beginScore");
                paramlist.put("beginScore", beginScore);
            }
            if (!StringUtils.isEmpty(endScore)) {
                hql.append(" and t.testersTotalscore < :endScore");
                paramlist.put("endScore", endScore);
            }

            PaginationBean<List> allCustom = this.findAllCustom(page, hql.toString(), paramlist);
            return allCustom;
        } catch (Exception e) {
            throw e;
        }
    }
}
