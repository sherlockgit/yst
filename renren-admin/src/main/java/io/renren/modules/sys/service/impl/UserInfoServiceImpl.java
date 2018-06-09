package io.renren.modules.sys.service.impl;

import io.renren.common.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.modules.sys.dao.UserInfoDao;
import io.renren.modules.sys.entity.UserInfoEntity;
import io.renren.modules.sys.service.UserInfoService;
import org.springframework.transaction.annotation.Transactional;


@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userName = (String)params.get("userName");
        String phone = (String)params.get("phone");
        String wxUname = (String)params.get("wxUname");
        String userType = (String)params.get("userType");

        Page<UserInfoEntity> page = this.selectPage(
                new Query<UserInfoEntity>(params).getPage(),
                new EntityWrapper<UserInfoEntity>()
                        .like(StringUtils.isNotBlank(userName),"USER_NAME", userName)
                        .like(StringUtils.isNotBlank(phone),"PHONE", phone)
                        .like(StringUtils.isNotBlank(wxUname),"WX_UNAME", wxUname)
                        .like(StringUtils.isNotBlank(userType),"USER_TYPE", userType)
                        .orderBy("REGIST_TIME",false)
        );

        return new PageUtils(page);
    }

    /**
     * 新增用户
     * @param userInfoEntity
     * @return
     */
    @Override
    public R insertUserInfo(UserInfoEntity userInfoEntity) {

        if ( userInfoDao.getByPhone(userInfoEntity.getPhone()) != null) {
            return R.error("该手机号码已经存在");
        }

        if ( userInfoDao.getByWXName(userInfoEntity.getWxUname()) != null) {
            return R.error("该微信号已经存在");
        }

        userInfoEntity.setUserId(UUIDUtils.getUUID());
        userInfoEntity.setRegistTime(new Date());
        userInfoEntity.setUserNo(NoUtils.genOrderNo());
        insert(userInfoEntity);
        return R.ok();
    }

    /**
     * 更新会员
     * @param userInfoEntity
     * @return
     */
    @Override
    public R updateUserInfo(UserInfoEntity userInfoEntity) {

        UserInfoEntity userInfo = selectById(userInfoEntity.getUserId());

        if (!(userInfoEntity.getPhone().equals(userInfo.getPhone()))) {
            if ( userInfoDao.getByPhone(userInfoEntity.getPhone()) != null) {
                return R.error("该手机号码已经存在");
            }
        }

        if (!(userInfoEntity.getWxUname().equals(userInfo.getWxUname()))) {
            if ( userInfoDao.getByWXName(userInfoEntity.getWxUname()) != null) {
                return R.error("该微信号已经存在");
            }
        }

        updateById(userInfoEntity);
        return R.ok();
    }
}
