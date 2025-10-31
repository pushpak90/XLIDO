package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.Question;

public class QuestionRepository implements IQuestionRepository{

    private final Map<Long, Question> questionDB = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public Question save(Question question) {

        if(question.getId() == null){
            question.setId(idCounter++);
        }

        return questionDB.put(question.getId(), question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.ofNullable(questionDB.get(id));
    }

    @Override
    public void delete(Long id) {
        questionDB.remove(id);
    }

    @Override
    public List<Question> findAll() {
        return new ArrayList<>(questionDB.values());
    }
    
}
