package com.crio.xlido.service;

import com.crio.xlido.entities.User;

public interface IUserService {
    User addUser(String email, String password);
}
