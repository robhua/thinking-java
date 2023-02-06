package com.tmp.base.common.exceptions;

public class ApplicationLogicException extends AbstractApplicationRuntimeException {
    public ApplicationLogicException(String code) {
        super(code);
    }

    public ApplicationLogicException(String code, Throwable cause) {
        super(code, cause);
    }

    public ApplicationLogicException(String code, String[] params) {
        super(code, params);
    }

    public ApplicationLogicException(String code, String[] params, Throwable cause) {
        super(code, params, cause);
    }


}
