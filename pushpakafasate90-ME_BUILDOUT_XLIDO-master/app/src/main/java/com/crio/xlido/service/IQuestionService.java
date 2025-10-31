package com.crio.xlido.service;

import com.crio.xlido.entities.Question;

public interface IQuestionService {
    Question addQuestion(String question, Long user_id, Long event_id);
    void deleteQuestion(Long question_id, Long user_id);
    void upvoteQuestion(Long question_id, Long user_id);
    
}
