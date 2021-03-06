package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.ProjectEntity;

import java.util.Map;

/**
 * 项目信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-04 21:54:43
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R getProjectByType(Map<String, Object> params);

    R insertProject(ProjectEntity projectEntity);

    R getProjectByDetail(String proId);

    R getProjectNameList();

    R getProjectByNameList();

    R getDestineByUser(Map<String,Object> map);
}

