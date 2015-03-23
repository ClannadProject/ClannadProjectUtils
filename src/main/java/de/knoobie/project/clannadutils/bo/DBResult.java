package de.knoobie.project.clannadutils.bo;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class DBResult {

    private String message;
    private boolean success;
//    private Throwable exception;
    private Object returnObj;

    public DBResult() {
    }
    
    
}
