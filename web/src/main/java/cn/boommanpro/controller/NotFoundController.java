package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotFoundController implements ErrorController {


    private static final String ERROR_PATH = "error";

    @GetMapping(ERROR_PATH)
    public CallResult error() {
        return CallResult.error("page not found");
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
