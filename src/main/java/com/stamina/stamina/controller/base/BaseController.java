package com.stamina.stamina.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 14:43 2019/4/20
 * @ Description：刘畅
 * @ Modified By：
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/bc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
    @GetMapping
    public String getList(){
        LOG.info("----------------------start-----------------");
        return "success";
    }
}
