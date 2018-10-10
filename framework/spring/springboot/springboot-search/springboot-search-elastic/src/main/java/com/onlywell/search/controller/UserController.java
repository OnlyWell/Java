package com.onlywell.search.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlywell.search.dao.UserRepository;
import com.onlywell.search.entity.User;

/**
 * @author harry
 */
@RestController
@RequestMapping("/es")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	public String add(Long id,String name, String about, Integer age,String phone) {
		User user = new User();
		user.setId(id);
		user.setAbout(about);
		user.setAge(age);
		user.setName(name);
		user.setPhone(phone);
		userRepository.save(user);
		return "success";
	}

	@GetMapping("/delete")
	public String delete(Long id) {
		userRepository.deleteById(id);
		return "delete success";
	}

	@GetMapping("/update")
	public User update(Long id, String name, String about, Integer age,String phone) {
		User user = userRepository.queryUserById(id);
		if (null == user) {
			return null;
		}
		if (null != name) {
			user.setName(name);
		}
		if (null != about) {
			user.setAbout(about);
		}
		if (null != age) {
			user.setAge(age);
		}
		if(null != phone) {
			user.setPhone(phone);
		}
		user = userRepository.save(user);

		return user;
	}
	
	@GetMapping("/query")
	public User query(Long id) {
		User user = userRepository.queryUserById(id);
		return user;
	}

}
