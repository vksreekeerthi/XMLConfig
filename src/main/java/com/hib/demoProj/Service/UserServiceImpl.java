package com.hib.demoProj.Service;

import com.hib.demoProj.Entities.Stock;
import com.hib.demoProj.Entities.User;
import com.hib.demoProj.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;
    /*public Set<Stock> getS(User user)
    {
        return userRepository.getS(user);
    }*/
}
