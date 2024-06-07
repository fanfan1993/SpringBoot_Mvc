package com.example.demo;

// 返回前端的结果类型
public class Response<T> {

    private T data;
    private String errorMsg;
    private boolean success;

    //设置返回类型 正确的结果
    public static <K> Response<K> newSuccess(K data) {
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    //设置返回类型 错误的结果
    public static Response<Void> newFail(String errorMsg) {
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
