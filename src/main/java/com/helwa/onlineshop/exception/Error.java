package com.helwa.onlineshop.exception;

import org.jetbrains.annotations.NotNull;
import org.apache.logging.log4j.util.Strings;

/**
 * Error details for a REST API calls.
 */
public class Error {
    private static final long serialVersionUID = 1L;
    private static final String NOT_AVAILABLE = "Not available.";
    /**
     * Application error code, which is different from HTTP error code.
     */
    private String errorCode;

    /**
     * Short, human-readable summary of the problem.
     */
    private String message;

    /**
     * HTTP status code for this occurrence of the problem, set by the origin server.
     */
    private Integer status;

    /**
     * Url of request that produced the error.
     */
    private String url = NOT_AVAILABLE;

    /**
     * Method of request that produced the error.
     */
    private String requestMethod = NOT_AVAILABLE;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(@NotNull String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(@NotNull String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NotNull Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public Error setUrl(@NotNull String url) {
        if (Strings.isNotBlank(url)) {
            this.url = url;
        }
        return this;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public Error setRequestMethod(@NotNull String requestMethod) {
        if (Strings.isNotBlank(requestMethod)) {
            this.requestMethod = requestMethod;
        }
        return this;
    }
}
