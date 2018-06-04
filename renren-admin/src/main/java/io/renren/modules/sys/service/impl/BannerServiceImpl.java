package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.BannerDao;
import io.renren.modules.sys.entity.BannerEntity;
import io.renren.modules.sys.service.BannerService;


@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerEntity> implements BannerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BannerEntity> page = this.selectPage(
                new Query<BannerEntity>(params).getPage(),
                new EntityWrapper<BannerEntity>()
        );

        return new PageUtils(page);
    }

}
