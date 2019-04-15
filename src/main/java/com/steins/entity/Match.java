package com.steins.entity;

public class Match {

    private int matchId;
    private String matchName;   //比赛名称
    private String matchTime;   //比赛开始到结束
    private String matchPlace; //比赛地点
    private String applyTime;  //报名开始到结束
    private String matchDesc;  //比赛描述，预留字段
    private int maleLimit;     //男性人数限制
    private int femaleLimit;   //女性人数限制
    private int totalLimit;    //总人数限制
    private int isFood;         //是否需要提供餐饮
    private int isSleep;        //是否需要提供住宿
    private String matchType;   //比赛阶段
    private String matchNeedKnow; //比赛须知
    private String matchContent;  //比赛内容


    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", matchName='" + matchName + '\'' +
                ", matchTime='" + matchTime + '\'' +
                ", matchPlace='" + matchPlace + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", matchDesc='" + matchDesc + '\'' +
                ", maleLimit=" + maleLimit +
                ", femaleLimit=" + femaleLimit +
                ", totalLimit=" + totalLimit +
                ", isFood=" + isFood +
                ", isSleep=" + isSleep +
                ", matchType='" + matchType + '\'' +
                ", matchNeedKnow='" + matchNeedKnow + '\'' +
                ", matchContent='" + matchContent + '\'' +
                '}';
    }

    public String getMatchNeedKnow() {
        return matchNeedKnow;
    }

    public void setMatchNeedKnow(String matchNeedKnow) {
        this.matchNeedKnow = matchNeedKnow;
    }

    public String getMatchContent() {
        return matchContent;
    }

    public void setMatchContent(String matchContent) {
        this.matchContent = matchContent;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchPlace() {
        return matchPlace;
    }

    public void setMatchPlace(String matchPlace) {
        this.matchPlace = matchPlace;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getMatchDesc() {
        return matchDesc;
    }

    public void setMatchDesc(String matchDesc) {
        this.matchDesc = matchDesc;
    }

    public int getMaleLimit() {
        return maleLimit;
    }

    public void setMaleLimit(int maleLimit) {
        this.maleLimit = maleLimit;
    }

    public int getFemaleLimit() {
        return femaleLimit;
    }

    public void setFemaleLimit(int femaleLimit) {
        this.femaleLimit = femaleLimit;
    }

    public int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(int totalLimit) {
        this.totalLimit = totalLimit;
    }

    public int getIsFood() {
        return isFood;
    }

    public void setIsFood(int isFood) {
        this.isFood = isFood;
    }

    public int getIsSleep() {
        return isSleep;
    }

    public void setIsSleep(int isSleep) {
        this.isSleep = isSleep;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

}
