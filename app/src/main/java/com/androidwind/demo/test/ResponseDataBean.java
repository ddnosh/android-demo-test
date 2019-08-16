package com.androidwind.demo.test;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public abstract class ResponseDataBean<T>{
    protected int status;
    protected String desc;
    protected T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
