package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.dao.pft.ProjectRawDataRepository;
import com.stamina.stamina.dao.pft.TestersAttributeRepository;
import com.stamina.stamina.entity.pft.PhysicalBatchQueryEntity;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;
import com.stamina.stamina.pojo.pft.ProjectRawDataPojo;
import com.stamina.stamina.service.pft.ProjectRawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public List<ProjectRawDataEntity> getProjectRawData(String rawprojectBatchcode, String rawprojectProplecode) {

        List<ProjectRawDataEntity> list = new ArrayList();
        List<ProjectRawDataPojo> pojoList = projectRawDataRepository.findByRawprojectBatchcodeAndRawprojectProplecode(rawprojectBatchcode, rawprojectProplecode);
        for (ProjectRawDataPojo pojo : pojoList) {
            ProjectRawDataEntity entity = new ProjectRawDataEntity();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
            entity.setProjectrawdataId(pojo.getProjectrawdataId());
            entity.setRawprojectName(pojo.getRawprojectName());
            entity.setRawprojectValue(pojo.getRawprojectValue());
            entity.setRawprojectCompany(pojo.getRawprojectCompany());
            entity.setRawprojectTime(sdf.format(pojo.getRawprojectTime()));
            list.add(entity);
        }

        return list;
    }

    @Override
    public List<PhysicalBatchQueryEntity> physicalBatchQuery() {

        List<PhysicalBatchQueryEntity> returnList = new ArrayList<>();

        List<Object[]> list = projectRawDataRepository.physicalBatchQuery();

        for (int i=0; i<list.size(); i++) {
            PhysicalBatchQueryEntity entity = new PhysicalBatchQueryEntity();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
            Object[] objects = list.get(i);
            entity.setProjectrawdataId(i+1L);
            entity.setRawprojectBatchcode((String) objects[0]);
            //entity.setTestNumber((BigInteger) objects[1]);
            entity.setRawprojectTime(sdf.format((Date) objects[2]));
            returnList.add(entity);
        }


        return returnList;
    }

    @Override
    public PaginationBean<PhysicalBatchQueryEntity> physicalBatchQuery2(String rawprojectBatchcode, String beginTime, String endTime, Pagination page) throws Exception{
        PaginationBean<org.hibernate.mapping.List> physical = projectRawDataRepository.physicalBatchQuery2(rawprojectBatchcode, beginTime, endTime, page);
        ArrayList list = (ArrayList) physical.getPageList();
        PaginationBean<PhysicalBatchQueryEntity> returnEntity = new PaginationBean<>(page, physical.getTotal());
        List<PhysicalBatchQueryEntity> physicalList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            PhysicalBatchQueryEntity entity = new PhysicalBatchQueryEntity();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
            Object[] objects = (Object[]) list.get(i);
            entity.setProjectrawdataId(i+1L);
            entity.setRawprojectBatchcode((String) objects[0]);
            entity.setTestNumber((Long) objects[1]);
            entity.setRawprojectTime(sdf.format((Date) objects[2]));
            physicalList.add(entity);
        }
        returnEntity.setPageList(physicalList);
        return returnEntity;
    }


}
