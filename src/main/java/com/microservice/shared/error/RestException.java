package com.microservice.shared.error;

import com.microservice.shared.enums.RestExceptionEnum;

public class RestException extends Exception  {

    private final RestExceptionEnum info;

    public RestException(RestExceptionEnum pInfo) {
        super();
        this.info = pInfo;
    }

    public RestExceptionEnum getInfo() {
        return info;
    }
}
