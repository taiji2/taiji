package com.steins.entity;

public class Event {
    private Integer eventId;    //每件具体项目id
    private String eventName;    //拳/武器
    private String firstLevel;   //太极拳，南拳
    private String secondLevel;  //太极拳类，太极器械类
    private String thirdLevel;   //陈式太极拳/陈氏太极拳器械
    private Integer eventFlag;  //1个人，2对练，3集体
    private String transport;    //运输要更新的值

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel;
    }

    public String getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
    }

    public String getThirdLevel() {
        return thirdLevel;
    }

    public void setThirdLevel(String thirdLevel) {
        this.thirdLevel = thirdLevel;
    }

    public Integer getEventFlag() {
        return eventFlag;
    }

    public void setEventFlag(Integer eventFlag) {
        this.eventFlag = eventFlag;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
}

