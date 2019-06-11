package com.stamina.stamina.service.serviceImpl.pft;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectFractionRepository;
import com.stamina.stamina.service.pft.PhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 模块编号：pcitc_ecs_bll_bc_AddressBookServiceImpl
 * 作       者：t-weijian.hou
 * 创建时间：2019年5月31日
 * 修改编号：1
 * 描       述：体能服务逻辑层实现类
 */
@Service
public class PhysicalServiceImpl implements PhysicalService {

    @Autowired
    private ProjectFractionRepository projectFractionRepository;

    @Override
    public CommonResult physicalService(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject jsonObject1 = (JSONObject) jsonObject.get("params");
        JSONArray jsonArray = (JSONArray) jsonObject1.get("data");
        //批次编码生成
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(date);
        StringBuffer str = new StringBuffer("");
        //String fatch = projectFractionRepository.findCount();
        //str.append("   ")


        return null;
    }
}
