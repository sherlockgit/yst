package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.UserInfoDao;
import io.renren.modules.sys.entity.UserInfoEntity;
import io.renren.modules.sys.service.UserInfoService;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInfoEntity> page = this.selectPage(
                new Query<UserInfoEntity>(params).getPage(),
                new EntityWrapper<UserInfoEntity>()
        );

        return new PageUtils(page);
    }

}
