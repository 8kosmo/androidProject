package com.example.starbuzz;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;
    //drinks는 새 음료의 배열
    public static final Drink[] drinks = {
            new Drink("Latte", "라떼", R.drawable.latte)
            , new Drink("Cappuccino", "카푸치노", R.drawable.cappuccino)
            , new Drink("Filter", "필터", R.drawable.filter)
    };
    //각각의 Drink는 이름, 설명, 이미지 리소스를 가지고 있음.
    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String toString(){
        return this.name;
    }
}
