package com.helwa.onlineshop.exception;

import com.fasterxml.jackson.core.JsonParseException;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * Global Exception Handler
 */
@ControllerAdvice
public class RestAPIException {

    private static final Logger logger = LoggerFactory.getLogger(RestAPIException.class);
    private MessageSource messageSource;

    @Autowired
    public RestAPIException(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }
    /**
     * @param request Request caused the exception.
     * @param exception Exception of the error.
     * @param locale Current locale of the API
     * @return ResponseEntity of {@link Error}.
     */
    @ExceptionHandler(Exception.class)
    @NotNull
    public ResponseEntity<Error> handleException(@NotNull HttpServletRequest request, @NotNull Exception exception, Locale locale)
    {
        Error error =
                ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getErrorMessageKey(), ErrorCode.GENERIC_ERROR.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setUrl(request.getRequestURI()).setRequestMethod(request.getMethod());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO: TO write it my own.
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
                                                                           HttpMediaTypeNotAcceptableException ex,
                                                                           Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrorMessageKey(),
                        ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrorCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
                .setRequestMethod(request.getMethod());
        logger.info("HttpMediaTypeNotAcceptableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO: TO write it my own.
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex,
                                                                       Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrorMessageKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrorCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setRequestMethod(request.getMethod());
        logger.info("HttpMessageNotReadableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO: TO write it my own.
    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request,
                                                          JsonParseException ex,
                                                          Locale locale) {
        ex.printStackTrace(); // TODO: Should be kept only for development
        Error error = ErrorUtils
                .createError(null,
                        ErrorCode.JSON_PARSE_ERROR.getErrorCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setRequestMethod(request.getMethod());
        logger.info("JsonParseException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
