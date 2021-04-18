package SnacksShop.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeProductsController {
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Products(@PathVariable String id) {
		ModelAndView mv = new ModelAndView("user/products/typeProducts");
		
		mv.addObject("nameProducts", id);
		
		return mv;
	}
}
