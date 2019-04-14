package com.steins.web.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.steins.entity.Event;
import com.steins.entity.Match;
import com.steins.entity.Page;
import com.steins.service.ManageMatchServiceInterface;
import com.steins.web.user.AreaController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liup
 */

@Controller
@RequestMapping("/match")
public class MatchController {
    Logger logger= LoggerFactory.getLogger(AreaController.class);

    @Autowired
    ManageMatchServiceInterface manageMatchServiceInterface;

    @ResponseBody
    @RequestMapping("/select")
    public Map<String,Object> selectMatch (@RequestParam("matchId") int matchId){
        Map<String,Object> result = new HashMap<>();
        Match match = manageMatchServiceInterface.selectMatch(matchId);
        if (match == null) {
            result.put("match",null);
            result.put("falseMsg", "matchId不存在！");
            result.put("status",false);
        }else {
            // logger.info("match",match.toString());
            // System.out.println(match.toString());
            result.put("match", match);
            result.put("status", true);
        }

        return  result;
    }

    @ResponseBody
    @RequestMapping("/selectByMatchName")
    public Map<String,Object> selectMatchByMatchName(@RequestParam("matchName") String matchName,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Map<String,Object> result = new HashMap<>();
        Page matchPage = manageMatchServiceInterface.selectMatchByMatchName(matchName,pageNum,pageSize);
        if (matchPage == null) {
            result.put("status",false);
            result.put("falseMsg", "matchName不存在！");
        }else {
            result.put("status", true);
        }
        result.put("match", matchPage);
        return  result;
    }

    //http://localhost:8080/match/insert?matchTime=20190329&matchPlace=null&applyTime=20190501&matchDesc=null&maleLimit=0&femaleLimit=0&totalLimit=0&isFood=0&isSleep=0&matchType=null&matchName=null&matchNeedKnow=hah&matchContent=serecf&competitionType=yusai&eventIds=7&eventIds=8&eventIds=20    @ResponseBody
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String,Object> insertMatch(@RequestParam("matchTime") String matchTime,@RequestParam("matchPlace") String matchPlace,@RequestParam("applyTime") String applyTime,@RequestParam("matchDesc") String matchDesc,@RequestParam("maleLimit") int maleLimit,@RequestParam("femaleLimit") int femaleLimit,@RequestParam("totalLimit") int totalLimit,@RequestParam("isFood") int isFood,@RequestParam("isSleep") int isSleep,@RequestParam("matchType") String matchType,@RequestParam("matchName") String matchName,@RequestParam("matchContent") String matchContent,@RequestParam("matchNeedKnow") String matchNeedKnow,@RequestParam("eventIds") String eventIds){
        Map<String,Object> result = new HashMap<>();

//        //判断matchName是否已有
//        if(manageMatchServiceInterface.selectMatchByMatchName(matchName) == null){
//            result.put("falseMsg","比赛名称已经存在！换一个名称");
//            return result;
//        }

//
//        int[] arry1 = new int[eventIds.size()];
//        for (int i = 0; i < eventIds.size(); i++) {
//            arry1[i] = (int) eventIds.get(i);
//            System.out.println(arry1[i] + "by list");
//        }

        if (eventIds == null) {
            result.put("status",false);
            result.put("errorMsg","eventIds为空！");
            return result;
        }

        System.out.println(eventIds);
        String str2 = eventIds.substring(1);
        String idsStr = str2.substring(0,str2.length()-1);

        String[] idsStrArray = idsStr.split(",");

        int[] ids = new int[idsStrArray.length];
        for(int i=0; i < idsStrArray.length; i++)
        {
            ids[i] = Integer.parseInt(idsStrArray[i]);
            System.out.println(ids[i]);
        }

        Match m = new Match();
        m.setMatchName(matchName);
        m.setMatchTime(matchTime);
        m.setMatchPlace(matchPlace);
        m.setApplyTime(applyTime);
        m.setMatchDesc(matchDesc);
        m.setIsFood(isFood);
        m.setMaleLimit(maleLimit);
        m.setFemaleLimit(femaleLimit);
        m.setTotalLimit(totalLimit);
        m.setIsSleep(isSleep);
        m.setMatchType(matchType);
        m.setMatchContent(matchContent);
        m.setMatchNeedKnow(matchNeedKnow);

        manageMatchServiceInterface.insertBothMatchAndEvent(m,ids);
        result.put("status",true); //成功
        return result;
    }




    /**
     *
     * @param pageNum 当前是第几页
     * @param pageSize 一页显示多少条数据
     * @return
     */


    @ResponseBody
    @RequestMapping("/query")
    public Map<String,Object> queryMatch(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Map<String,Object> result = new HashMap<>();
        if (pageNum<=0) {
            result.put("falseMsg", "pageNum必须大于等于1！");
            return result;
        }
        Page matchPage = manageMatchServiceInterface.queryMatch(pageNum, pageSize);
        result.put("matchPage",matchPage);
        if (matchPage != null) {
            result.put("status",true);
        }else{
            result.put("status",false);
        }

        return result;
    }


    @ResponseBody
    @RequestMapping("/delete")
    public Map<String,Object> deleteMatch(@RequestParam("matchId") int matchId){
        Map<String,Object> result = new HashMap<>();

        //该matchId不存在
        if (manageMatchServiceInterface.selectMatch(matchId) == null){
            result.put("false","The matchId doesn't exist.");
            result.put("status",false);
            return result;
        }
        manageMatchServiceInterface.deleteMatch(matchId);
        result.put("status",true);
        return result;
    }


    @RequestMapping("/queryEventByMatch")
    @ResponseBody
    public Map<String,Object> queryEventByMatch(@RequestParam("matchId") int matchId){
        Map<String,Object> map =  new HashMap<>();
        Match match = manageMatchServiceInterface.selectMatch(matchId);
        if (match == null) {
            map.put("errorMsg","没找到符合要求的比赛");
            map.put("status",false);
            return map;
        }
        List<Event> events = manageMatchServiceInterface.queryEventByMatchId(matchId);
        map.put("events",events);
        map.put("status",true);
        return map;
    }




}
