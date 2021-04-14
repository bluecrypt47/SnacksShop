package SnacksShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import SnacksShop.Service.User.HomeServiecImple;

@Controller
public class HomeController {
	@Autowired
	HomeServiecImple homeService;
	
	@RequestMapping(value = {"/", "/trang-chu"})
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("user/index");
		mv.addObject("slides", homeService.GetDataSlide());
		return mv;
	}
	
	
}
