package myspring.user.service;

import java.util.*;

import myspring.user.vo.UserVO;

public interface UserService {
	public List<UserVO> getUserList();
	
	public void insertUser(UserVO user);
	
	public UserVO getUser(String id);
	
	public void updateUser(UserVO user);
	
	public void deleteUser(String id);
}
