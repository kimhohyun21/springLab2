package myspring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.user.dao.UserDAO;
import myspring.user.vo.UserVO;

@Service("userService")
public class UserServiceimpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<UserVO> getuserList() {
		return userDAO.readAll();
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insert(vo);
		
	}

}
