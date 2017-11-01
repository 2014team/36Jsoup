package com.jsoup.user.service.impl;
import org.springframework.stereotype.Service;

import com.jsoup.base.service.impl.BaseServiceImpl;
import com.jsoup.user.domain.UserDO;
import com.jsoup.user.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDO, Integer> implements UserService{

}
