/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.knoobie.project.clannadutils.bo;

import lombok.Data;

/**
 *
 * @author cKnoobie
 */
public @Data abstract class ClannadOperationResult<T> {
    
    private String message;
    private boolean success;
    private Throwable exception;
    private T result;
}
