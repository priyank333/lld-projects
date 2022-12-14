/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.model;

import java.io.Serializable;

/**
 *
 * @author priyank
 */
public class Response implements Serializable{

    private Integer statusCode;
    private Object response;

    public Response(Integer statusCode, Object response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" + "statusCode=" + statusCode
                + ", response=" + response + '}';
    }

}
