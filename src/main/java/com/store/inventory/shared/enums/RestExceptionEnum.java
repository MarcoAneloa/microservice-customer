package com.store.inventory.shared.enums;

import org.springframework.http.HttpStatus;

public enum RestExceptionEnum {

    ERROR_EMPLOYEE_NOT_FOUND(1000, HttpStatus.NOT_FOUND, "customer.not.exists"),
    ERROR_EMPLOYEE_ALREADY_EXISTS(1001, HttpStatus.BAD_REQUEST, "customer.already.exists"),
    ;

    private final Integer id;
    private final HttpStatus httpStatus;
    private final String message;

    RestExceptionEnum(final Integer pId, final HttpStatus pHttpStatus, final String pMessage) {
        this.id = pId;
        this.httpStatus = pHttpStatus;
        this.message = pMessage;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
