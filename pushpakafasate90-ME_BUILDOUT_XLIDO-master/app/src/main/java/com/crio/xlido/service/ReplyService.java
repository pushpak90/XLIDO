package com.crio.xlido.service;

import java.util.*;
import com.crio.xlido.Repository.IQuestionRepository;
import com.crio.xlido.Repository.IReplyRepository;
import com.crio.xlido.Repository.IUserRepository;
import com.crio.xlido.entities.Question;
import com.crio.xlido.entities.Reply;

public class ReplyService implements IReplyService {

    private final IReplyRepository _IReplyRepository;
    private final IQuestionRepository _IQuestionRepository;
    private final IUserRepository _IUserRepository;
    // private final IEventRepository _IEventRepository;


    public ReplyService(IReplyRepository replyRepository, IQuestionRepository questionRepository,
            IUserRepository userRepository) {
        this._IReplyRepository = replyRepository;
        this._IQuestionRepository = questionRepository;
        this._IUserRepository = userRepository;
        // this._IEventRepository = eventRepository;
    }

    @Override
    public void addReply(String reply_content, Long question_id, Long user_id) {
        _IUserRepository.findById(user_id).orElseThrow(
                () -> new RuntimeException("User with an id " + user_id + " does not exist"));

        _IQuestionRepository.findById(question_id).orElseThrow(() -> new RuntimeException(
                "Question with an id " + question_id + " does not exist"));

        Reply reply = new Reply(null, question_id, user_id, reply_content);
        _IReplyRepository.save(reply);
        System.out.println("REPLY_ADDED");
    }

    @Override
    public void ListQuestion(Long event_id, String sort_by) {
        List<Question> ques = _IQuestionRepository.findAll();
        List<Reply> replys = _IReplyRepository.findAll();

        List<Question> filteredQuestions = new ArrayList<>();
        for (Question que : ques) {
            if (que.getEvent_id().equals(event_id)) {
                filteredQuestions.add(que);
            }
        }

        if (filteredQuestions.isEmpty()) {
            System.out.println("ERROR: Event with an id " + event_id + " does not exist");
            return;
        }

        if (sort_by != null) {
            String sortKey = sort_by.toLowerCase();
        
            if (sortKey.equals("popular")) {
                filteredQuestions.sort((q1, q2) -> Integer.compare(q2.getUpvotedBy().size(), q1.getUpvotedBy().size()));
            } else if (sortKey.equals("recent")) {
                filteredQuestions.sort((q1, q2) -> Long.compare(q2.getId(), q1.getId()));
            } else {
                System.out.println("WARNING: Unknown sort_by option '" + sort_by + "'. Showing unsorted list.");
            }
        }
        

        for (Question que : filteredQuestions) {
            System.out.println("Question ID: " + que.getId());
            System.out.println("Content: " + que.getContest());
            System.out.println("Votes: " + que.getUpvotedBy().size());
            System.out.println("Replies:");
            for (Reply reply : replys) {
                if (reply.getQuestionId().equals(que.getId())) {
                    System.out.println(
                            "  - User " + reply.getUserId() + ": " + reply.getReplyContest());
                }
            }
            System.out.println();
        }
    }



}
