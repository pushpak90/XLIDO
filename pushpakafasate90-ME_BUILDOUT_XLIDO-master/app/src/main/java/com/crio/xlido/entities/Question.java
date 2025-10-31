package com.crio.xlido.entities;

import java.util.*;

public class Question {
    private Long id;
    private Long event_id;
    private Long user_id;
    private String contest;

    private Set<Long> upvotedBy = new HashSet<>();

    public Question(){}

    public Question(Long id, Long event_id, Long user_id, String contest){
        this.id = id;
        this.event_id = event_id;
        this.user_id = user_id;
        this.contest = contest;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getEvent_id(){
        return event_id;
    }

    public void setEvent_id(Long event_id){
        this.event_id = event_id;
    }

    public Long getUser_id(){
        return user_id;
    }

    public void setUser_id(Long user_id){
        this.user_id = user_id;
    }

    public String getContest(){
        return contest;
    }

    public void setContest(String contest){
        this.contest = contest;
    }

    public Set<Long> getUpvotedBy() {
        return upvotedBy;
    }

    public void setUpvotedBy(Set<Long> upvotedBy) {
        this.upvotedBy = upvotedBy;
    }

}
