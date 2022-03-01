package com.naruto.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class AppValidateHelper {

    @ExceptionHandler(value = RuntimeException.class)
    public ResUtil runtimeExceptionHandler(Exception e){
        log.error("服务端异常，error：", e);
        return ResUtil.serverErrMsg("服务端异常!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResUtil paramExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        StringBuffer errMsg = new StringBuffer();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(att -> {
            errMsg.append(att.getDefaultMessage()).append(";");
        });
        return ResUtil.paramErrMsg(errMsg.toString().substring(0, errMsg.toString().length() - 1));
    }

}
