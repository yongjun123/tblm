package com.ysdd.tblm.taobaoAppliction.exception;


import com.ysdd.tblm.common.web.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
@Slf4j
public class TBKApiExceptionHandler {

    @ExceptionHandler(value = TBKApiException.class)
    @ResponseBody
    public AjaxResult TBKApiExceptionHandler(HttpServletRequest req, Exception e) {
        return AjaxResult.error(e.getMessage());
    }
}
