package com.stamina.stamina.dao.daoImpl;

import com.stamina.stamina.common.util.BaseRepository;
import com.stamina.stamina.dao.pft.ProjectFractionRepositoryCustom;
import com.stamina.stamina.pojo.pft.ProjectFractionPojo;
import org.hibernate.transform.Transformers;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class ProjectFractionRepositoryImpl extends BaseRepository<ProjectFractionPojo, Long> implements ProjectFractionRepositoryCustom {
    @Override
    public String findCount() {
        String count = 1+"";
        String sql="  \n" +
                "select count(*) as count from t_pft_projectrawdata as p\n" +
                "where p.RAWPROJECT_TIME >= date(now())\n" +
                "and  p.RAWPROJECT_TIME < DATE_ADD(date(now()),INTERVAL 1 DAY) group by p.RAWPROJECT_BATCHCODE ";
        Query query1 = getEntityManager().createNativeQuery(sql.toString());
        query1.unwrap(org.hibernate.SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> resultList = query1.getResultList();
        Integer count1 = 1;
        for(Map map:resultList) {
            count1++;
            count = count1.toString();
        }
        return count;
    }
}
