package com.helwa.onlineshop.exception;

import org.jetbrains.annotations.NotNull;

public class ErrorUtils {

    private ErrorUtils(){}

    public static Error createError(@NotNull final String errorMsgKey, @NotNull final String errorCode,
                                    @NotNull final Integer httpStatusCode)
    {
        Error error = new Error();
        error.setMessage(errorMsgKey);
        error.setErrorCode(errorCode);
        error.setStatus(httpStatusCode);

        return error;
    }
}
