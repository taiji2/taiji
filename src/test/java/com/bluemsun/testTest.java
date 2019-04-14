package com.bluemsun;

import com.steins.dao.ManageMatch;
import com.steins.entity.Event;
import com.steins.entity.Match;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author by liup
 */

public class testTest {

    @Test
    public void say(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");

        int matchId =10;
        Match match= manageMatch.selectMatch(matchId);
        System.out.println(match.toString());
    }

    @Test
    public  void testInsert(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");
        //int matchId =12;
        Match match= new Match();

        match.setMatchName("hello1e12 world");
        match.setMatchTime("20qweqw190329");
        match.setApplyTime("20112e1290501");
        match.setIsFood(1);
        match.setApplyTime("2020eqweasd012012");
        int count = manageMatch.insertMatch(match);
        System.out.println(match.getMatchId());
      //  manageMatch.insertMatch("test1","test","test","test",2,4,5,1,1,"sd","sad","asd");
        //System.out.println(match.toString());
    }


//    @Test
//    public  void testInsertTotal(){
//        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
//        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");
//        //int matchId =12;
//        Match match= new Match();
//
//        match.setMatchName("hello1e12 world");
//        match.setMatchTime("20qweqw190329");
//        match.setApplyTime("20112e1290501");
//        match.setIsFood(1);
//        match.setApplyTime("2020eqweasd012012");
//        int count = manageMatch.insertBothMatchAndEvent(match);
//        System.out.println(match.getMatchId());
//        //  manageMatch.insertMatch("test1","test","test","test",2,4,5,1,1,"sd","sad","asd");
//        //System.out.println(match.toString());
//    }

    @Test
    public void testDelete(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");

        int matchId =2;

        Match match= new Match();
        manageMatch.deleteMatch(matchId);
        //System.out.println(match.toString());
    }

    @Test
    public  void testInsert1(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatchService");
        int matchId =12;
        Match match= new Match();
        match.setMatchTime("hello world1");
        match.setMatchTime("2019032911");
        match.setApplyTime("20190501111");

        manageMatch.insertMatch(match);
        //System.out.println(match.toString());
    }


    @Test
    public void testQuery(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");
        String matchName = "太";
        int pageNum = 1;
        int pageSize = 5;

        int count = manageMatch.getMatchNameCount(matchName);
        pageNum = pageSize* pageNum - pageSize;
        List<Match> list = manageMatch.queryMatchByName(matchName,pageNum,pageSize);
        System.out.println(count);
        System.out.println(list);
    }


    @Test
    public void testInsertEvent(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");
        int eventId = 3;
        int matchId =5;
        int count = manageMatch.insertEventOfMatch(eventId,matchId);
       // System.out.println(count.getId());

    }


    @Test
    public void selectEventByMatch(){
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");

        List<Event> events =  manageMatch.queryEventByMatchId(1);
        System.out.println(events);
    }

//    @Test
//    public void testSelectMatch(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
//        ManageMatch manageMatch = (ManageMatch) applicationContext.getBean("manageMatch");
//        String matchName = "da";
//        List<Match> matches = manageMatch.selectMatchByMatchName(matchName);
//        System.out.println(matches.toString());
//    }
}