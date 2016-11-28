package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model){
		List<UserVO> userList=userService.getuserList();
		model.addAttribute("userList", userList);
		
		return "userList";
	}
	
	@RequestMapping("/insertUserForm.do")
	public ModelAndView insertUserForm(){
		List<String> genderList=new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("����");
		cityList.add("����");
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		
		return new ModelAndView("userinsert","map",map);
	}
	
}
