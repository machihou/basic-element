package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.service.RowPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rowPermission")
public class RowPermissionController {
    @Autowired
    private RowPermissionService rowPermissionService;

    @GetMapping("listAll")
    public CallResult listAll() {
        return CallResult.success(rowPermissionService.listAll());
    }
}
