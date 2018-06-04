package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.AccountEntity;

import java.util.Map;

/**
 * 会员账户表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-04 21:54:43
 */
public interface AccountService extends IService<AccountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

