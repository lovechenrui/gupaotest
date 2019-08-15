package com.chenrui.concurrent.countDownLatch;


public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"), THREE(3,"燕"),FOUR(4,"赵"), FIVE(5,"魏"),SIX(6,"韩");

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    CountryEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CountryEnum search_country(int index){
        for (CountryEnum countryEnum:CountryEnum.values()) {
            if(countryEnum.id== index){
                return countryEnum;
            }
        }
        return null;
    }
}
