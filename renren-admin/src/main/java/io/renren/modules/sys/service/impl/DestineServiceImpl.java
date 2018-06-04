package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.DestineDao;
import io.renren.modules.sys.entity.DestineEntity;
import io.renren.modules.sys.service.DestineService;


@Service("destineService")
public class DestineServiceImpl extends ServiceImpl<DestineDao, DestineEntity> implements DestineService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DestineEntity> page = this.selectPage(
                new Query<DestineEntity>(params).getPage(),
                new EntityWrapper<DestineEntity>()
        );

        return new PageUtils(page);
    }

}
