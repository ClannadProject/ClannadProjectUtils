package de.knoobie.project.clannadutils.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class ClannadOperationResult<T> {

    private String message;
    private boolean success;
    private Throwable exception;
    private T result;

    private List<ClannadOperationResult<?>> subOperations = new ArrayList<>();

    public ClannadOperationResult() {
        this(false, null, null, null);
    }

    public ClannadOperationResult(boolean success) {
        this(success, null, null, null);
    }

    public ClannadOperationResult(boolean success, String message) {
        this(success, message, null, null);
    }

    public ClannadOperationResult(boolean success, String message, Throwable exception) {
        this(success, message, exception, null);
    }

    public ClannadOperationResult(boolean success, String message, Throwable exception, T result) {
        this.success = success;
        this.message = message;
        this.exception = exception;
        this.result = result;
    }

    public List<ClannadOperationResult<?>> getSubOperations() {
        if(subOperations == null){
            subOperations = new ArrayList<>();
        }
        return subOperations;
    }

    public void setSubOperations(List<ClannadOperationResult<?>> subOperations) {
        this.subOperations = subOperations;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
