package org.covn.exception;

/**
 * Custom service exception
 */
public class CovnServiceException extends RuntimeException {

    public CovnServiceException(String message) {
        super(message);
    }

    public CovnServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CovnServiceException(Throwable cause) {
        super(cause);
    }

    protected CovnServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
