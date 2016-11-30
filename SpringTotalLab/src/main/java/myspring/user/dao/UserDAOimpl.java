package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("useDAO")
public class UserDAOimpl implements UserDAO{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVO> readAll() {
		List<UserVO> userList=userMapper.selectUserList();
		return userList;
	}

	@Override
	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("등록된 Record UserId=" +user.getUserId()+
				" Name= " +user.getName());
		
	}

	@Override
	public UserVO read(String id) {
		UserVO user=userMapper.selectUserById(id);
		return user;
	}

	@Override
	public void updateUser(UserVO user) {
		userMapper.updateUser(user);		
	}

	@Override
	public void deleteUser(String id) {
		
		System.out.println("삭제된 Record With ID = "+id);
	}

	
}










