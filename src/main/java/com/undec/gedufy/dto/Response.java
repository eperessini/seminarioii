/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.undec.gedufy.dto;

/**
 * @author etorrielli
 */
public class Response {
    private Integer status;
    private String message;
    private Object data;

    public Response(Integer codigoRespuesta, String mensajeRespuesta) {
        this.status = codigoRespuesta;
        this.message = mensajeRespuesta;
    }

    public Response(Integer codigoRespuesta, String mensajeRespuesta, Object data) {
        this.status = codigoRespuesta;
        this.message = mensajeRespuesta;
        this.data = data;
    }

    public Response() {
        this.status = 0;
        this.message = "";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
