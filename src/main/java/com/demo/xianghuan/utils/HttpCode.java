package com.demo.xianghuan.utils;

public enum HttpCode {
    OK(200),
    MULTI_STATUS(207),
    LOGIN_FAIL(303),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    GONE(410),
    SESSION_OUT(411),
    LOCKED(423),
    INTERNAL_SERVER_ERROR(500);

    private final Integer value;

    private HttpCode(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    public String msg() {
        return "HTTPCODE_" + this.value;
    }

    public String toString() {
        return this.value.toString();
    }
}