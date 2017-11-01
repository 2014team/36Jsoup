package com.jsoup.user.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsoup.common.JsonResult;
import com.jsoup.user.domain.UserDO;
import com.jsoup.user.service.UserService;
import com.jsoup.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	 
	@Autowired
	UserService userService;
	
	/**
	* @Title: save
	* @Description: 保存
	* @author zhuzq
	* @date  2017-9-15 下午4:29:23
	* @param userVO
	* @return
	*/
	@RequestMapping("/save")
	@ResponseBody
	public JsonResult save(UserVO userVO){
		JsonResult result = new JsonResult();
		UserDO user = new UserDO();
		BeanUtils.copyProperties(userVO, user);
		userService.save(user);
		if(user.getId()>0){
			result.success();
			return result;
		}
		result.failure();
		return result;
	}
	
	/**
	* @Title: delete
	* @Description: 删除
	* @author zhuzq
	* @date  2017-9-15 下午4:29:33
	* @param id
	* @return
	*/
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(Integer id){
		JsonResult result = new JsonResult();
		int index = userService.delete(id);
		if(index>0){
			result.success();
			return result;
		}
		result.failure();
		return result;
	}
	
	/**
	* @Title: update
	* @Description: 修改
	* @author zhuzq
	* @date  2017-9-15 下午4:29:44
	* @param userVO
	* @return
	*/
	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(UserVO userVO){
		JsonResult result = new JsonResult();
		UserDO user = new UserDO();
		BeanUtils.copyProperties(userVO, user);
		int index = userService.update(user);
		if(index>0){
			result.success();
			return result;
		}
		result.failure();
		return result;
	}
	
	/**
	* @Title: select
	* @Description: 查询
	* @author zhuzq
	* @date  2017-9-15 下午4:29:52
	* @return
	*/
	@RequestMapping("/select")
	@ResponseBody
	public JsonResult select(){
		JsonResult result = new JsonResult();
		List<UserDO> userList = userService.select(null);
		result.success(userList);
		return result;
	}
	
}
