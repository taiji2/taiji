package com.steins.dao;

import com.steins.entity.Event;
import com.steins.entity.Match;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * made by liup
 * 管理员管理比赛
 */

@Repository
public interface ManageMatch {

    Match selectMatch(int matchId);

    void deleteMatch(int matchId);

    int insertMatch(Match match);


    //模糊查询结果分页

    List<Match> queryMatchByName(@Param("matchName")String matchName ,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int getMatchNameCount(@Param("matchName")String matchName);
    //



    int getMatchCount();

    List<Match> queryMatch(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int insertEventOfMatch(@Param("eventId") int eventId,@Param("matchId") int matchId);


    List<Event> queryEventByMatchId(int matchId);
}
