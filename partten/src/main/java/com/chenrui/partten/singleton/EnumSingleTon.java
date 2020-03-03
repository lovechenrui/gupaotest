package com.chenrui.partten.singleton;

public enum EnumSingleTon {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleTon getInstance(){
        return INSTANCE;
    }
}
