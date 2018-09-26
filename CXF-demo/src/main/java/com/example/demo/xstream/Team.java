package com.example.demo.xstream;

/**
 * 测试类 -- Team实体
 * @author SXD
 *
 */
public class Team {

    
    private String name;
    private int num;
    private String describe;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    @Override
    public String toString() {
        return "Team [name=" + name + ", num=" + num + ", describe=" + describe
                + "]";
    }
    
    
    
}