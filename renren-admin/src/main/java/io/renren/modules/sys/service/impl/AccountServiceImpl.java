package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.AccountDao;
import io.renren.modules.sys.entity.AccountEntity;
import io.renren.modules.sys.service.AccountService;


@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements AccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountEntity> page = this.selectPage(
                new Query<AccountEntity>(params).getPage(),
                new EntityWrapper<AccountEntity>()
        );

        return new PageUtils(page);
    }

}
