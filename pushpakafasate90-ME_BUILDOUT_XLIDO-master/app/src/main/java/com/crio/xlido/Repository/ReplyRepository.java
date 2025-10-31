package com.crio.xlido.Repository;
import java.util.*;
import com.crio.xlido.entities.Reply;

public class ReplyRepository implements IReplyRepository{

    private final Map<Long, Reply> replyDB = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public void save(Reply reply) {
        if(reply.getId() == null){
            reply.setId(idCounter++);
        }
        replyDB.put(reply.getId(), reply);
    }

    @Override
    public List<Reply> findAll() {
        return new ArrayList<>(replyDB.values());
    }
    
}
