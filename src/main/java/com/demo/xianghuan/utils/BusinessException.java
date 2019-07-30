package com.demo.xianghuan.utils;

public final class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 8052465825694766117L;
    protected String errorCode;
    protected String[] messageArgs;
    protected RuntimeException orgException;
    public static final String ERROR_UTIL_CODE = "99";

    public BusinessException() {
        this.errorCode = null;
        this.messageArgs = null;
        this.orgException = null;
    }

    public BusinessException(String sErrorCode) {
        super(sErrorCode);
        this.errorCode = sErrorCode;
        this.messageArgs = null;
        this.orgException = null;
    }

    public BusinessException(String sErrorCode, RuntimeException exception) {
        super(sErrorCode);
        this.errorCode = sErrorCode;
        this.messageArgs = null;
        this.orgException = exception;
    }

    public BusinessException(String sErrorCode, String sMessageArgs) {
        super(sErrorCode);
        this.errorCode = sErrorCode;
        this.messageArgs = new String[1];
        this.messageArgs[0] = sMessageArgs;
        this.orgException = null;
    }

    public BusinessException(String sErrorCode, String sMessageArgs1, String sMessageArgs2) {
        super(sErrorCode);
        this.errorCode = sErrorCode;
        this.messageArgs = new String[2];
        this.messageArgs[0] = sMessageArgs1;
        this.messageArgs[1] = sMessageArgs2;
        this.orgException = null;
    }

    public BusinessException(String sErrorCode, String[] sMessageArgs) {
        super(sErrorCode);
        this.errorCode = sErrorCode;
        this.messageArgs = new String[2];
        this.messageArgs = sMessageArgs;
        this.orgException = null;
    }

    public String getMessage() {
        return this.messageArgs != null && this.messageArgs.length > 0 ? this.messageArgs[0] : super.getMessage();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getMessageArgs() {
        if (this.messageArgs == null || this.messageArgs.length == 0) {
            String[] a = new String[]{super.getMessage()};
            this.messageArgs = a;
        }

        return this.messageArgs;
    }

    public Exception getOrgException() {
        return this.orgException;
    }
}
