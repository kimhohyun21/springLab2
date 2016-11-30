package myspring.user.dao;

import java.util.*;

import myspring.user.vo.UserVO;

public interface UserDAO {
	
	public List<UserVO> readAll();
	
	public void insert(UserVO user);
	
	public UserVO read(String id);
	
	public void updateUser(UserVO user);
	
	public void deleteUser(String id);
}
