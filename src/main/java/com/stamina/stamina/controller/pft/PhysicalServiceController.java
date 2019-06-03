package com.stamina.stamina.controller.pft;


import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.service.pft.PhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 *
 * 模块编号：
 * 作       者：weijian.hou
 * 创建时间：2019年5月31日
 * 修改编号：1
 * 描       述：体能服务controller
 */

@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/physicalService", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PhysicalServiceController {

    @Autowired
    private PhysicalService physicalService;

    @PostMapping()
    public CommonResult physicalService(String json){

        return physicalService.physicalService(json);
    }
}
