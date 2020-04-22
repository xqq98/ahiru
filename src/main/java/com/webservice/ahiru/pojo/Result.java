package com.webservice.ahiru.pojo;

public class Result {
    private Object data;
    private String message;
    private String code;
    private String success;

    public Result(Object data){
        this.data=data;
        this.success="OK";
        this.code="200";
    }

    public Result(String code,String success,String message,Object data){
        this.data=data;
        this.success=success;
        this.message=message;
        this.code=code;
    }

    public static Result ok(Object data){
        return new Result(data);
    }

    public static Result ok(){
        return new Result(null);
    }

    public static Result error(String message){
        return new Result("400","ERR",message,null);
    }
    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", success='" + success + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
