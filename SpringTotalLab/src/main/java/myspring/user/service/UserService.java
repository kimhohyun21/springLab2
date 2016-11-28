package myspring.user.service;

import java.util.*;
import myspring.user.vo.*;

public interface UserService {
	
	public List<UserVO> getuserList();
	public void insertUser(UserVO vo);
}
