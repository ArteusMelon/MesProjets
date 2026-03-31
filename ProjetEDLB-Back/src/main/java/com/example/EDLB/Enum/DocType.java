package com.example.EDLB.Enum;

public enum DocType {
    photo("photo"),
    document("document"),
    avatar("avatar"),
    pp("PP");
    private final String type;

    DocType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
    @Override
    public String toString(){
        return type;
    }
}
