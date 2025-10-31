package com.crio.xlido.service;

public interface IReplyService {
    void addReply(String reply_content, Long question_id, Long user_id);
    void ListQuestion(Long event_id, String sort_by);
}
