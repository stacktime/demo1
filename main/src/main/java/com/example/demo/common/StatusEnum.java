package com.example.demo.common;

public enum StatusEnum {
    ONLINE(0),
    DISONLINE(1),

    ;
    private final Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static StatusEnum EnumByValue(Integer value){
                for (StatusEnum statusEnum : StatusEnum.values()) {
                    if(statusEnum.getValue().equals(value)){
                return statusEnum;
            }
        }
        throw new RuntimeException("不存在的类型");
    }

}
