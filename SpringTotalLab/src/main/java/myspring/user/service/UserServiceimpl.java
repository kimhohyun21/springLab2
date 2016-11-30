package myspring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.user.dao.UserDAO;
import myspring.user.vo.UserVO;

@Service("userService")
public class UserServiceimpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return userDAO.readAll();
	}

	@Override
	public void insertUser(UserVO user) {
		userDAO.insert(user);
		
	}

	@Override
	public UserVO getUser(String id) {
		return userDAO.read(id);
	}

	@Override
	public void updateUser(UserVO user) {
		userDAO.updateUser(user);		
	}

	@Override
	public void deleteUser(String id) {
		userDAO.deleteUser(id);
	}

}









