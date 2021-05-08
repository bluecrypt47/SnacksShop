package SnacksShop.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BillController extends BaseController {
	
	@RequestMapping(value = "/checkout")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/bill/checkout");
		return mv;
	}

	

}
