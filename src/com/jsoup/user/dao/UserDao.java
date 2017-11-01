package com.jsoup.user.dao;

import org.springframework.stereotype.Repository;

import com.jsoup.base.dao.BaseDao;
import com.jsoup.user.domain.UserDO;

@Repository
public interface UserDao extends BaseDao<UserDO, Integer> {

}