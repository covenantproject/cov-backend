package org.covn.exception;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Custom Covn service specific default error response object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CovnServiceErrorResponse {

    private long timestamp;
    private String requestId;
    private String status;
    private String error;
    private String exception;
    private String errorCode;
    private String message;
    private String path;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CovnServiceErrorResponse{" +
                "timestamp=" + timestamp +
                ", requestId='" + requestId + '\'' +
                ", status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", exception='" + exception + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
