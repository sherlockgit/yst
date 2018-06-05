package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.UserInfoEntity;
import io.renren.modules.sys.service.UserInfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 会员信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-05 21:47:20
 */
@RestController
@RequestMapping("sys/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("sys:userinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:userinfo:info")
    public R info(@PathVariable("userId") String userId){
        UserInfoEntity userInfo = userInfoService.selectById(userId);

        return R.ok().put("userInfo", userInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:userinfo:save")
    public R save(@RequestBody UserInfoEntity userInfo){
        userInfoService.insert(userInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:userinfo:update")
    public R update(@RequestBody UserInfoEntity userInfo){
        ValidatorUtils.validateEntity(userInfo);
        userInfoService.updateAllColumnById(userInfo);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:userinfo:delete")
    public R delete(@RequestBody String[] userIds){
        userInfoService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
