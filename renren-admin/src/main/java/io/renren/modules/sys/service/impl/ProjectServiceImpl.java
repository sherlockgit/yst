package io.renren.modules.sys.service.impl;

import io.renren.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ProjectDao;
import io.renren.modules.sys.entity.ProjectEntity;
import io.renren.modules.sys.service.ProjectService;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProjectEntity> page = this.selectPage(
                new Query<ProjectEntity>(params).getPage(),
                new EntityWrapper<ProjectEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R getProjectByType(Map<String, Object> params) {

        Integer page = (int)params.get("page");
        Integer pagesSelect = (page-1)*10;
        params.put("page",pagesSelect);

        PageUtils pageUtils = new PageUtils(projectDao.getProjectByType(params),0,0,page);
        return R.ok().put("data", pageUtils);
    }

}
