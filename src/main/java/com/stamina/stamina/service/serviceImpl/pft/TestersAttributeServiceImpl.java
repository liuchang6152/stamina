package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.dao.pft.TestersAttributeRepository;
import com.stamina.stamina.entity.pft.TestersAttributeEntity;
import com.stamina.stamina.pojo.pft.TestersAttributePojo;
import com.stamina.stamina.service.pft.TestersAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：
 */
@Service
public class TestersAttributeServiceImpl implements TestersAttributeService {

    @Autowired
    private TestersAttributeRepository testersAttributeRepository;

    @Override
    public PaginationBean getTestersList(Map searchMap, int pageNum, int pageSize) throws Exception {

        PaginationBean paginationBean = new PaginationBean();
        Specification specification = createSpecification(searchMap);
        //按总分倒序
        Sort sort = new Sort(Sort.Direction.DESC, "testersTotalscore");
        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize, sort);
        Page page = testersAttributeRepository.findAll(specification, pageRequest);

            List<TestersAttributePojo> content = page.getContent();
            Long totalElements = page.getTotalElements();

            List<TestersAttributeEntity> list = new ArrayList<>();
            for (TestersAttributePojo pojo : content) {
                TestersAttributeEntity entity = new TestersAttributeEntity();
                entity.setTestersattributeId(pojo.getTestersattributeId());
                entity.setTestersName(pojo.getTestersName());
                entity.setTestersGender(CommonEnum.TestersSexEnum.getName(Integer.parseInt(pojo.getTestersGender())));
                entity.setTestersHeight(pojo.getTestersHeight());
                entity.setTestersWeight(pojo.getTestersWeight());
                entity.setUserIdCard(pojo.getUserIdcard());
                entity.setTestersTotalScore(pojo.getTestersTotalscore());
                entity.setRawprojectPeoplecode(pojo.getRawprojectPeoplecode());
                entity.setRawprojectBatchcode(pojo.getRawprojectBatchcode());
                list.add(entity);
            }

         paginationBean.setPageList(list);
         paginationBean.setTotal(page.getTotalElements());
        return paginationBean;
    }

    //testersName testersGender  testersTotalscore
    private Specification createSpecification(Map searchMap) {

        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (searchMap.get("rawprojectBatchcode") != null && !"".equals(searchMap.get("rawprojectBatchcode"))) {
                    predicateList.add(cb.equal(root.get("rawprojectBatchcode").as(String.class), searchMap.get("rawprojectBatchcode")));
                }
                if (searchMap.get("testersName") != null && !"".equals(searchMap.get("testersName"))) {
                    predicateList.add(cb.like(root.get("testersName").as(String.class), "%"+searchMap.get("testersName")+"%"));
                }
                if (searchMap.get("testersGender") != null && !"".equals(searchMap.get("testersGender"))) {
                    predicateList.add(cb.equal(root.get("testersGender").as(String.class), searchMap.get("testersGender")));
                }
                if (searchMap.get("beginScore") != null && !"".equals(searchMap.get("beginScore"))) {
                    predicateList.add(cb.ge(root.get("testersTotalscore").as(String.class), (Number) searchMap.get("beginScore")));
                }
                if (searchMap.get("endScore") != null && !"".equals(searchMap.get("endScore"))) {
                    predicateList.add(cb.le(root.get("testersTotalscore").as(String.class), (Number) searchMap.get("endScore")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    @Override
    public PaginationBean<TestersAttributeEntity> getTestersList2(String rawprojectBatchcode, String testersName, String testersGender, Long beginScore, Long endScore, Pagination page) throws Exception {

        PaginationBean<org.hibernate.mapping.List> testers = testersAttributeRepository.getTestersList2(rawprojectBatchcode, testersName, testersGender, beginScore, endScore, page);
        ArrayList list = (ArrayList) testers.getPageList();
        PaginationBean<TestersAttributeEntity> returnEntity = new PaginationBean<>(page, testers.getTotal());
        List<TestersAttributeEntity> testersAttributeEntityList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            TestersAttributePojo pojo = (TestersAttributePojo) list.get(i);
            TestersAttributeEntity entity = new TestersAttributeEntity();
            entity.setTestersattributeId(pojo.getTestersattributeId());
            entity.setTestersName(pojo.getTestersName());
            if (pojo.getTestersGender() != null) {
                entity.setTestersGender(CommonEnum.TestersSexEnum.getName(Integer.parseInt(pojo.getTestersGender())));
            }
            entity.setTestersHeight(pojo.getTestersHeight());
            entity.setTestersWeight(pojo.getTestersWeight());
            entity.setUserIdCard(pojo.getUserIdcard());
            entity.setTestersTotalScore(pojo.getTestersTotalscore());
            entity.setRawprojectPeoplecode(pojo.getRawprojectPeoplecode());
            entity.setRawprojectBatchcode(pojo.getRawprojectBatchcode());
            testersAttributeEntityList.add(entity);
        }
        returnEntity.setPageList(testersAttributeEntityList);
        return returnEntity;
    }
}
