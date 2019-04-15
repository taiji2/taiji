package com.steins.service;


import com.steins.entity.Event;
import com.steins.entity.Match;
import com.steins.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author liup
 */
public interface ManageMatchServiceInterface {
    Match selectMatch(int matchId);

    int insertMatch(Match match);

    void deleteMatch(int matchId);

    int getMatchNameCount(@Param("matchName") String matchName);

    Page selectMatchByMatchName(@Param("matchName") String matchName,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    int getMatchCount();

    Page queryMatch(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int insertEventOfMatch(int eventId,int matchId);

    void insertBothMatchAndEvent(Match match,int[] eventIds);

    List<Event> queryEventByMatchId(int matchId);
}
