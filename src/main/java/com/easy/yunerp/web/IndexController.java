package com.easy.yunerp.web;

import com.easy.yunerp.common.base.AjaxResult;
import com.easy.yunerp.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "首页controller", tags = {"首页相关接口"})
public class IndexController extends BaseController {
    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录名", paramType = "form", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "form", required = true, dataType = "String")
    })
    @GetMapping("/login")
    public AjaxResult login(@RequestParam String loginName, @RequestParam String password) {
        return AjaxResult.success("登录成功");
    }
}
