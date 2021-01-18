package com.example.springboothksdk.utils;

public class ResponseMessage<T> {
    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 500;

    private static final String MSG_SUCCESS="ok";

    private static final String MSG_FAIL="failed";

    public ResponseMessage(){
    }
    public ResponseMessage(int status ){
        this.status=status;
    }
    public ResponseMessage(int status,T data ){
        this.status=status;
        this.data=data;
    }
    public ResponseMessage(int status, String message){
        this.status = status;
        this.message = message;
    }
    public ResponseMessage(int status, String message,T data) {
        this.status = status;
        this.message = message;
        this.data=data;
    }
    public static ResponseMessage success(){
        return new ResponseMessage(CODE_SUCCESS,MSG_SUCCESS);
    }

    public static ResponseMessage success(Object data){
        return new ResponseMessage(CODE_SUCCESS,MSG_SUCCESS, data);
    }

    public static ResponseMessage fail(String msg){
        return new ResponseMessage(CODE_FAIL, MSG_FAIL, msg);
    }

    private int status;

    private String message;

    public T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }




}
