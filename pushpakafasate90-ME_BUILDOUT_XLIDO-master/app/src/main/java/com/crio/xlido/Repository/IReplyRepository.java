package com.crio.xlido.Repository;

import java.util.List;
import com.crio.xlido.entities.Reply;

public interface IReplyRepository {
    void save(Reply reply);
    List<Reply> findAll();
}
