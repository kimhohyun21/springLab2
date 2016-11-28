package myspring.user.dao;

import java.util.*;

import myspring.user.vo.UserVO;

public interface UserDAO {
	
	public List<UserVO> readAll();
	
	public void insert(UserVO vo);
}
