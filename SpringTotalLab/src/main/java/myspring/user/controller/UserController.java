package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model){
		List<UserVO> userList=userService.getUserList();
		model.addAttribute("userList", userList);
		return "userList";
	}
	
	@RequestMapping("/insertUserForm.do")
	public ModelAndView insertUserForm(){
		List<String> genderList=new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("광주");
		cityList.add("제주");
		
		
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		return new ModelAndView("userinsert", "map", map);
	}
	
	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user){
		if(user !=null)
			userService.insertUser(user);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam String id){
		UserVO user=userService.getUser(id);		
		return new ModelAndView("userInfo","user",user);
	}
	
	@RequestMapping("/updateUserForm.do")
	public ModelAndView UpdateUserForm(@RequestParam String id){
		UserVO user=userService.getUser(id);
		List<String> genderList=new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("광주");
		cityList.add("제주");	
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);		
		map.put("user", user);
		
		return new ModelAndView("userUpdate", "map", map);
		
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(@ModelAttribute UserVO user){
		userService.updateUser(user);
		return "redirect:/getUserList.do";
		
	}
	
	/*
	 * @PathVariable
	 * 	- URI 템플릿을 위한 @PathVariable을 통해 입력값을 얻어 낼 수 있음
	 * 	- URI 템플릿 변수에 접근
	 * 	- {변수명} 규칙을 통해 값을 메소드 파라미터를 통해 받음
	 */
	@RequestMapping(value="deleteUser.do/{id}")
	public String deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return "redirect:/getUserList.do";
	}
}













