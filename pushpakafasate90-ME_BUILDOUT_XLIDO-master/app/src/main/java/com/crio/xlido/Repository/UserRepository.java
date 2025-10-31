package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<Long, User> storage = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public User save(User user) {
        if(user.getId() == null){
            user.setId(idCounter++);
        }
        storage.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }
    
}
