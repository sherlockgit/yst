package io.renren.modules.sys.service.impl;


import io.renren.common.utils.R;
import io.renren.modules.sys.vo.AccountItemVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AccountItemDao accountItemDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {



        Page<AccountItemEntity> page = this.selectPage(
                new Query<AccountItemEntity>(params).getPage(),
                new EntityWrapper<AccountItemEntity>()


        );

        return new PageUtils(page);
    }

    /**
     * 根据用户ID获取账户明细
     * @param
     * @return
     */
    @Override
    public PageUtils getAccountItemByUserIdPage (Map<String, Object> params) {

        String tranStatus = (String) params.get("tranStatus");
        String userId = (String) params.get("userId");

        Page<AccountItemEntity> page = this.selectPage(
                new Query<AccountItemEntity>(params).getPage(),
                new EntityWrapper<AccountItemEntity>()
                .like("TRAN_STATUS",tranStatus)
                .like("USER_ID",userId)


        );

        return new PageUtils(page);
    }

    /**
     * 获取明细列表
     * @param params
     * @return
     */
    @Override
    public R getAccountItemAll(Map<String, Object> params) {

        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        Integer pagesSelect = (page-1)*limit;
        params.put("limit",limit);
        params.put("page",pagesSelect);
        AccountItemVO accountItemVO = accountItemDao.getAccountItemAll(params).get(0);
        PageUtils pageUtils = new PageUtils(accountItemDao.getAccountItemAll(params),accountItemDao.selectCountItemAll(params),limit,page);
        return R.ok().put("page",pageUtils);
    }

}
