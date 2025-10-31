package com.crio.xlido.service;

import com.crio.xlido.Repository.IUserRepository;
import com.crio.xlido.entities.User;

public class UserService implements IUserService{

    private final IUserRepository _IUserRepository;

    public UserService(IUserRepository userRepository){
        this._IUserRepository = userRepository;
    }

    @Override
    public User addUser(String email, String password) {
        User user = new User(null, email, password);
        _IUserRepository.save(user);
        return user;
    }
    
}
