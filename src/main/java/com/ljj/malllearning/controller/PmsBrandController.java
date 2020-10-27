package com.ljj.malllearning.controller;

import com.ljj.malllearning.component.FlagValidator;
import com.ljj.malllearning.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljj
 * @date 2020/9/27
 */
@RestController
@RequestMapping("/brand")
@Slf4j
@Api(tags = "PmsBrandController", description = "商品类")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    //使用aop 在controller层建一个切面 实现接口访问的统一日志
    @PreAuthorize("hasAuthority('pms:brand:read')")//read update delete create
    @ApiOperation("getBrandList")
    @GetMapping("listAll")
    public void getBrandList(@ApiParam("主键id") Long id, @FlagValidator(value = {"0", "1"}, message = "flag is error") String type) {
        pmsBrandService.listAllBrand();
        //Stream 来自数据源的元素队列 可以支持聚合操作 数据源：流的数据来源 聚合操作：如map limit等操作
    }

}
