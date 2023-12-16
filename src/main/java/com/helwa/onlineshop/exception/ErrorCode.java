package com.helwa.onlineshop.exception;

import org.jetbrains.annotations.NotNull;

public enum ErrorCode {
    GENERIC_ERROR("HELWA-0001", "The system is unable to complete the request. Contact system support."),
    HTTP_MEDIATYPE_NOT_SUPPORTED("HELWA-0002", "Requested media type is not supported. Please use " +
            "'application/json' or \'application/xml' as 'Content-Type' header value"),
    HTTP_MESSAGE_NOT_WRITABLE("HELWA-0003", "Missing 'Accept' header. Please add 'Accept' header."),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("HELWA-0004", "Requested 'Accept' header value is not supported." +
            "Please use 'application/json' or 'application/xml' as 'Accept' value"),
    JSON_PARSE_ERROR("HELWA-0005", "Make sure request payload should be a valid JSON object."),
    HTTP_MESSAGE_NOT_READABLE("HELWA-0006", "Make sure request payload should be a valid" +
            " JSON or XML object according to 'Content-Type'.");

    @NotNull
    private String errorMessageKey;
    @NotNull
    private String errorCode;

    ErrorCode(@NotNull final String errorCode, @NotNull final String errorMsgKey) {
        this.errorCode = errorCode;
        this.errorMessageKey = errorMsgKey;
    }

    @NotNull public String getErrorMessageKey() {
        return errorMessageKey;
    }

    @NotNull public String getErrorCode() {
        return errorCode;
    }
}
