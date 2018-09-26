package com.example.demo.xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;


public class Test {

    
    @org.junit.Test
    public void testName() throws Exception {
        TestEntity obj = getEntity();
        XStream stream = new XStream();
        String xml = stream.toXML(obj);
        System.out.println(xml);
        String str ="<com.example.demo.xstream.TestEntity>\r\n" + 
				"  <money>30000</money>\r\n" + 
				"  <firstStr/>\r\n" + 
				"  <flag>true</flag>\r\n" + 
				"  <teamList>\r\n" + 
				"    <com.example.demo.xstream.Team>\r\n" + 
				"      <name>英雄1</name>\r\n" + 
				"      <num>2</num>\r\n" + 
				"      <describe>射手英雄，远程攻击型英雄</describe>\r\n" + 
				"    </com.example.demo.xstream.Team>\r\n" + 
				"    <com.example.demo.xstream.Team>\r\n" + 
				"      <name>英雄2</name>\r\n" + 
				"      <num>3</num>\r\n" + 
				"      <describe>坦克英雄，肉盾抗击打型英雄</describe>\r\n" + 
				"    </com.example.demo.xstream.Team>\r\n" + 
				"  </teamList>\r\n" + 
				"</com.example.demo.xstream.TestEntity>";
       
        
        TestEntity testEntity = (TestEntity) stream.fromXML(str);
        System.out.println("");
        System.out.println(testEntity.toString());
        
        
    }
    
    
    public TestEntity getEntity(){
        TestEntity entity = new TestEntity();
        entity.setMoney(30000);
        entity.setFlag(true);
        entity.setFirstStr("");
        
        List<Team> list = new ArrayList<Team>();
        Team team1 = new Team();
        team1.setName("英雄1");
        team1.setNum(2);
        team1.setDescribe("射手英雄，远程攻击型英雄");
        
        list.add(team1);
        
        Team team2 = new Team();
        team2.setName("英雄2");
        team2.setNum(3);
        team2.setDescribe("坦克英雄，肉盾抗击打型英雄");
        
        list.add(team2);
        
        entity.setTeamList(list);
        
        return entity;
        
        
        
    }
    
}