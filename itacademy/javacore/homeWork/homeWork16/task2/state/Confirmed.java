package com.itacademy.javacore.homeWork.homeWork16.task2.state;

public class Confirmed implements State {

    @Override
    public void currentState() {
        System.out.println("Заказ на получение гранта ПОДТВЕРЖДЕН");
    }


}
