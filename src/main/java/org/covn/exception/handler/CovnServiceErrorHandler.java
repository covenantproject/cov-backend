package org.covn.exception.handler;

import org.covn.exception.CovnServiceErrorResponse;
import org.slf4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.security.oauth2.common.exceptions.OAuth2Exception.INVALID_REQUEST;
import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * Exception handler advice
 */
@ControllerAdvice
public class CovnServiceErrorHandler {

    //Logger
    private static final Logger LOGGER = getLogger(CovnServiceErrorHandler.class);
    private static final String BAD_REQUEST_MESSAGE = "Request is missing or contains invalid parameter";

    @ExceptionHandler({MethodArgumentNotValidException.class, MissingRequestHeaderException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ResponseBody
    public CovnServiceErrorResponse handleInvalidRequestException(HttpServletRequest httpServletRequest, MethodArgumentNotValidException ex) {

        List<String> errorRequestAttributes = processFailures(ex);
        CovnServiceErrorResponse covnServiceErrorResponse = new CovnServiceErrorResponse();
        covnServiceErrorResponse.setTimestamp(currentTimeMillis());
        covnServiceErrorResponse.setError(BAD_REQUEST.name());
        covnServiceErrorResponse.setException(CovnServiceErrorResponse.class.getName());
        covnServiceErrorResponse.setErrorCode(INVALID_REQUEST);
        covnServiceErrorResponse.setMessage(BAD_REQUEST_MESSAGE + " " + errorRequestAttributes);
        covnServiceErrorResponse.setPath(httpServletRequest.getServletPath());
        covnServiceErrorResponse.setStatus(valueOf(BAD_REQUEST));
        return covnServiceErrorResponse;
    }

    /**
     * Extract failure fields
     */
    private List<String> processFailures(MethodArgumentNotValidException ex) {

        List<String> errorRequestAttributes = new ArrayList<>();
        BindingResult result = ex.getBindingResult();
        if (!isEmpty(result.getFieldErrors())) {
            LOGGER.error("Field errors :{}", result.getFieldErrors());
            result.getFieldErrors().forEach(e ->
                    errorRequestAttributes.add(e.getField()));
        }
        //process if any custom errors present
        if (isEmpty(errorRequestAttributes) && !isEmpty(result.getAllErrors())) {
            errorRequestAttributes.add(result.getAllErrors().get(0).getDefaultMessage());
        }
        LOGGER.error("Final validation errors :{}", errorRequestAttributes);
        return errorRequestAttributes.stream().distinct().collect(toList());
    }
}