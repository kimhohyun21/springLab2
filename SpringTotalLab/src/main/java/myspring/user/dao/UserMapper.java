package myspring.user.dao;

import java.util.*;

import myspring.user.vo.UserVO;


@MyMapper
public interface UserMapper {
	
	List<UserVO> selectUserList();
	
}

