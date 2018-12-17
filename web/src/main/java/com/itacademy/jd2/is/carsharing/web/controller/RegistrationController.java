package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.UserAccountDTO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	private IUserAccountService userAccountService;
	@Autowired
	private UserAccountFromDTOConverter userAccountFromDtoConverter;
	@Autowired
	private UserAccountToDTOConverter userAccountToDtoConverter;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		final StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegistrationForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final UserAccountDTO dto = new UserAccountDTO();
		hashMap.put("formModel", dto);
		return new ModelAndView("registration", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrate(@RequestParam("file") MultipartFile file,
			@ModelAttribute("formModel") UserAccountDTO formModel, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final InputStream is = file.getInputStream();
			final IUserAccount user = userAccountFromDtoConverter.apply(formModel);
			
			userAccountService.save(user, user.getCustomer(), file.getOriginalFilename(), is);
			return "redirect:/login";
		}

	}

}
