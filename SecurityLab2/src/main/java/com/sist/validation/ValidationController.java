package com.sist.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {
	@RequestMapping("form/validationForm.do")
	public String showForm(){
		return "form/validationForm";
	}
	
	@RequestMapping("form/validationForm_ok.do")
	public String validForm(@Valid ValidationForm1 validationForm, 
							BindingResult result, 
							Model model){
		
		if(result.hasErrors()){
			return"form/validationForm";
		}
		
		model.addAttribute("vo", validationForm);
		
		return "form/validationSucess";
	}
	
}
