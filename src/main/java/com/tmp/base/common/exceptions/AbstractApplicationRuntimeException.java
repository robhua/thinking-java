package com.tmp.base.common.exceptions;

import com.tmp.base.common.util.StringUtil;

import java.util.Arrays;

public class AbstractApplicationRuntimeException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    private String code;
    private String[] params;

    //***** injection field *****
    //***** constructor *****

    public AbstractApplicationRuntimeException() {
        super();
    }

    public AbstractApplicationRuntimeException(String code) {
        super(code);
        this.code = code;
    }

    public AbstractApplicationRuntimeException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
    }

    public AbstractApplicationRuntimeException(String code, String[] params) {
        super(code + "[" + StringUtil.join(Arrays.asList(params), ",") + "]");
        this.code = code;
        this.params = params;
    }

    public AbstractApplicationRuntimeException(String code, String[] params, Throwable cause) {
        super(code + "[" + StringUtil.join(Arrays.asList(params), ",") + "]", cause);
        this.code = code;
    }

    //***** public method *****
    //***** protected method *****
    //***** private method *****
    //***** getter and setter *****

    public String getCode() {
        return this.code;
    }
    public String[] getParams() {
        return params;
    }
}
