package com.steins.service.impl;

import com.steins.cache.JedisUtil;
import com.steins.dao.AreaDao;
import com.steins.dao.ManageMatch;
import com.steins.entity.Event;
import com.steins.entity.Match;
import com.steins.entity.Page;
import com.steins.service.ManageMatchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liup
 * 3.29
 */


@Service
public class MangeMatchServiceImple implements ManageMatchServiceInterface {

    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    @Autowired
    ManageMatch manageMatch;

    @Override
    public Match selectMatch(int matchId) {
        return manageMatch.selectMatch(matchId);
    }


    public int getMatchNameCount(String matchName){
        return manageMatch.getMatchNameCount(matchName);
    }

    public Page selectMatchByMatchName(String matchName,int pageNum,int pageSize){
        int count = manageMatch.getMatchNameCount(matchName);
        Page page = new Page(pageNum,pageSize,count);
        pageNum = pageNum * pageSize - pageSize;
        List<Match> matches = manageMatch.queryMatchByName(matchName, pageNum, pageSize);
        page.setList(matches);
        return page;
    }

    @Override
    @Transactional
    public int insertMatch(Match match) {
        return manageMatch.insertMatch(match);
    }

    @Override
    @Transactional
    public void deleteMatch(int matchId){
        manageMatch.deleteMatch(matchId);
    }

    @Override
    public int getMatchCount() {
        return manageMatch.getMatchCount();
    }

    @Override
    public Page queryMatch(int pageNum, int pageSize) {
        int count = manageMatch.getMatchCount();
        Page page = new Page(pageNum,pageSize,count);
        pageNum = pageNum*pageSize - pageSize; // 当前页数
        List<Match> list = manageMatch.queryMatch(pageNum,pageSize);
        page.setList(list);
        return page;
    }


    @Override
    public int insertEventOfMatch(int eventId, int matchId) {
        return manageMatch.insertEventOfMatch(eventId,matchId);
    }

    @Override
    @Transactional
    public void insertBothMatchAndEvent(Match match, int[] eventIds) {
        int count = manageMatch.insertMatch(match);
        int matchId = match.getMatchId();
        System.out.println("一共插入match "+ count + "条记录");
        int eventId;
        for (int i = 0; i < eventIds.length; i++) {
             eventId = eventIds[i];
            int eventCount = manageMatch.insertEventOfMatch(eventId,matchId);
            System.out.println("插入第" + i + "条 eventofmatch");
        }

    }

    @Override
    public List<Event> queryEventByMatchId(int matchId) {
        List<Event> events = manageMatch.queryEventByMatchId(matchId);
        return events;
    }


}
