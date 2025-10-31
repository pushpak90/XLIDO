package com.crio.xlido.service;

import com.crio.xlido.Repository.IEventRepository;
import com.crio.xlido.Repository.IQuestionRepository;
import com.crio.xlido.Repository.IUserRepository;
import com.crio.xlido.entities.Question;

public class QuestionService implements IQuestionService{
    private final IEventRepository _IEventRepository;
    private final IUserRepository _IUserRepository;
    private final IQuestionRepository _IQuestionRepository;

  

    public QuestionService(IEventRepository iEventRepository, 
                            IUserRepository iUserRepository, 
                            IQuestionRepository iQuestionRepository){
        this._IEventRepository = iEventRepository;
        this._IUserRepository = iUserRepository;
        this._IQuestionRepository = iQuestionRepository;

        
    }

    @Override
    public Question addQuestion(String question, Long user_id, Long event_id) {
        _IUserRepository.findById(user_id)
            .orElseThrow(() -> new RuntimeException("User with an id " + user_id + " does not exist"));
        
        _IEventRepository.findById(event_id)
            .orElseThrow(() -> new RuntimeException("Event with an id " + event_id + " does not exist"));

        Question que = new Question(null, event_id, user_id, question);
        _IQuestionRepository.save(que);
        System.out.println("Question ID: " + que.getId());
        return que;
    }

    @Override
    public void deleteQuestion(Long question_id, Long user_id) {
        _IUserRepository.findById(user_id)
            .orElseThrow(() -> new RuntimeException("User with an id " + user_id + " does not exist"));
        
        Question que =  _IQuestionRepository.findById(question_id)
            .orElseThrow(() -> new RuntimeException("Question with an id " + question_id + " does not exist"));
        
        if (!que.getUser_id().equals(user_id)) {
            throw new RuntimeException("User with an id " + user_id + " is not an author of question with an id " + question_id);
        }

        _IQuestionRepository.delete(question_id);
        System.out.println("QUESTION_DELETED " + question_id);
    }

    @Override
    public void upvoteQuestion(Long question_id, Long user_id) {
        _IUserRepository.findById(user_id)
        .orElseThrow(() -> new RuntimeException("User with an id " + user_id + " does not exist"));
        Question que = _IQuestionRepository.findById(question_id)
            .orElseThrow(() -> new RuntimeException("Question with an id " + question_id + " does not exist"));

        if (que.getUpvotedBy().contains(user_id)) {
            throw new RuntimeException(
                "User with an id " + user_id + " has already upvoted a question with an id " + question_id
            );
        }

        que.getUpvotedBy().add(user_id);

        _IQuestionRepository.save(que);
        System.out.println("QUESTION_UPVOTED " + question_id);
    }

    

    

}
