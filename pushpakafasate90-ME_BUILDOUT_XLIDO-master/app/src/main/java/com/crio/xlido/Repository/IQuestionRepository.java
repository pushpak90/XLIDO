package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.Question;

public interface IQuestionRepository {
    Question save(Question question);
    Optional<Question> findById(Long id);
    void delete(Long id);
    List<Question> findAll();
}
