package com.example.jdbc;

import java.util.List;

import com.example.bean.User;
import com.example.daoimp.UserDaoImp;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		List<User>list = null;
		UserDaoImp imp = new UserDaoImp();
		list = imp.findAll();
		for(User user:list){
			System.out.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getGrade());
		}
		//insert����.
		User user = new User();
		user.setId(1);
		user.setUsername("�������");
		user.setPassword("123456");
		user.setEmail("123");
		user.setGrade(5);
		imp.add(user);
		//update����.
		User user_1 = new User();
		user.setId(1);
		user.setUsername("�ľ���ˮ");
		user.setPassword("123456");
		user.setEmail("123");
		user.setGrade(5);
		imp.update(user_1);
	}

}
