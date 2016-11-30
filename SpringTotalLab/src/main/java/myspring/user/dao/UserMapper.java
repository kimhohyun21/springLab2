package myspring.user.dao;

import java.util.*;

import myspring.user.vo.UserVO;

@MyMapper
public interface UserMapper {
	
	List<UserVO> selectUserList();
	
	void insertUser(UserVO userVO);
	
	UserVO selectUserById(String id);
	
	void updateUser(UserVO user);
	
	void deleteUser(String id);
}










