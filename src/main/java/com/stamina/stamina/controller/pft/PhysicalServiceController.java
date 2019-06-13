package com.stamina.stamina.controller.pft;


import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.service.pft.PhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public CommonResult physicalServiceinfo(@RequestBody String json) throws Exception {

        return physicalService.physicalServiceinfo(json);
    }

    @GetMapping
    public CommonResult recalculate(String batch )throws Exception{
        return physicalService.recalculate(batch);
    }
}
