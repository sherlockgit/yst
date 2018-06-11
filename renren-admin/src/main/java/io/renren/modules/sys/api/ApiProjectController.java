package io.renren.modules.sys.api;

import io.renren.common.utils.R;
import io.renren.modules.sys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 小宇宙
 * @Date: 2018/6/11
 */
@RequestMapping("/apiProject")
@RestController
public class ApiProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/getProjectByType")
    public R getProjectByType (@RequestParam(value = "proType",required = false,defaultValue = "")String proType,
                               @RequestParam(value = "page",required = false,defaultValue = "1")Integer page) {

        Map<String,Object> map = new HashMap<>();
        map.put("proType",proType);
        map.put("page",page);

        return projectService.getProjectByType(map);
    }

}
