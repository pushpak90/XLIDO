package com.crio.xlido.entities;

public class Reply {
    private Long id;
    private Long question_id;
    private Long user_id;
    private String reply_content;

    public Reply(){}

    public Reply(Long id, Long question_id, Long user_id, String reply_content){
        this.id = id;
        this.question_id = question_id;
        this.user_id = user_id;
        this.reply_content = reply_content;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getQuestionId(){
        return question_id;
    }

    public void setQuestionId(Long question_id){
        this.question_id = question_id;
    }

    public Long getUserId(){
        return user_id;
    }

    public void setUserId(Long user_id){
        this.user_id = user_id;
    }

    public String getReplyContest(){
        return reply_content;
    }

    public void setQuestionContest(String reply_content){
        this.reply_content = reply_content;
    }

}
