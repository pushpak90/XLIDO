package com.crio.xlido.Repository;

import java.util.*;
import com.crio.xlido.entities.User;

public interface IUserRepository {
    User save(User user);
    Optional<User> findById(Long id);
}
