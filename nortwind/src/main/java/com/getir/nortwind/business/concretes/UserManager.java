package com.getir.nortwind.business.concretes;

import com.getir.nortwind.business.abstracts.UserService;
import com.getir.nortwind.core.dataAccess.UserDao;
import com.getir.nortwind.core.entities.User;
import com.getir.nortwind.core.utilities.results.DataResult;
import com.getir.nortwind.core.utilities.results.Result;
import com.getir.nortwind.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessDataResult("user added");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email)
                ,"user found");
    }
}
