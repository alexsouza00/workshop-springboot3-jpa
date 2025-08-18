package com.nelioalves.workshop_springboot3_jpa.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus orderValueOf(int code){
        for(OrderStatus order : OrderStatus.values()){
            if(order.getCode() == code){
                return order;
            }
        }
        throw new IllegalArgumentException("Invalid Order code");
    }
}
