package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("userDAO")
public class UserDAOimpl implements UserDAO {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVO> readAll() {
		List<UserVO> userList=userMapper.selectUserList();
		return userList;
	}

	@Override
	public void insert(UserVO vo) {
		userMapper.insertUser(vo);
		System.out.println("등록된 사용자 ID : "+vo.getUserId());
	}
	
	
}
