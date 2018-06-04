package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.UserInfoEntity;

import java.util.Map;

/**
 * 会员信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-04 22:13:46
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

