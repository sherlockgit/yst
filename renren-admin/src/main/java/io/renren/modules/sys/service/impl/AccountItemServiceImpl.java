package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.AccountItemDao;
import io.renren.modules.sys.entity.AccountItemEntity;
import io.renren.modules.sys.service.AccountItemService;


@Service("accountItemService")
public class AccountItemServiceImpl extends ServiceImpl<AccountItemDao, AccountItemEntity> implements AccountItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountItemEntity> page = this.selectPage(
                new Query<AccountItemEntity>(params).getPage(),
                new EntityWrapper<AccountItemEntity>()
        );

        return new PageUtils(page);
    }

}
