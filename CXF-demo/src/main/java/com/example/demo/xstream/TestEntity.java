package com.example.demo.xstream;

import java.util.List;


/**
 * 测试类 TestEntity---要转化为xml的类
 * @author SXD
 *
 */
public class TestEntity {

    
    private Integer money;
    private String firstStr;
    private boolean flag;
    
    private List<Team> teamList;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getFirstStr() {
        return firstStr;
    }

    public void setFirstStr(String firstStr) {
        this.firstStr = firstStr;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "TestEntity [money=" + money + ", firstStr=" + firstStr
                + ", flag=" + flag + ", teamList=" + teamList + "]";
    }
    
    
    
    
}