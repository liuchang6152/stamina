package com.stamina.stamina.dao.daoImpl;

import com.stamina.stamina.common.util.BaseRepository;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.dao.pft.ProjectRawDataRepositoryCustom;
import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import org.hibernate.mapping.List;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/12
 * 修改编号：
 * 描述：
 */
public class ProjectRawDataRepositoryImpl extends BaseRepository<ProjectRawDataPojo, Long> implements ProjectRawDataRepositoryCustom {


    @Override
    public PaginationBean<List> physicalBatchQuery2(String rawprojectBatchcode, String beginTime, String endTime, Pagination page) throws Exception {

        try {

            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            StringBuilder hql = new StringBuilder("SELECT p.rawprojectBatchcode,COUNT(DISTINCT p.rawprojectProplecode),p.rawprojectTime FROM ProjectRawDataPojo p WHERE 1=1");

            HashMap<String, Object> paramList = new HashMap<>();
            if (!StringUtils.isEmpty(rawprojectBatchcode)) {
                hql.append(" AND p.rawprojectBatchcode = :rawprojectBatchcode");
                paramList.put("rawprojectBatchcode", rawprojectBatchcode);
            }
            if (!StringUtils.isEmpty(beginTime)) {
                Date start = simdate.parse(beginTime);
                hql.append(" AND p.rawprojectTime > :start");
                paramList.put("start", start);
            }
            if (!StringUtils.isEmpty(endTime)) {
                Date end = simdate.parse(endTime);
                hql.append(" AND p.rawprojectTime < :end");
                paramList.put("end", end);
            }

            hql.append(" GROUP BY p.rawprojectBatchcode");

            PaginationBean<List> allCustom = this.findAllCustom(page, hql.toString(), paramList);
            return allCustom;
        } catch (Exception e) {
            throw e;
        }
    }
}
