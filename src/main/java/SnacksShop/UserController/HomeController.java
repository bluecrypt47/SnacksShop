package SnacksShop.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {
		
		String name ="";
		
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.addObject("searchProducts", _homeService.GetSearchProducts(name));
		/* _mvShare.addObject("newProducts", _homeService.GetDataNewProducts()); */
		
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

	@RequestMapping(value = "/tat-ca-san-pham")
	public ModelAndView Product() {
		_mvShare.addObject("allProducts", _homeService.GetAllProducts());
		
		_mvShare.setViewName("user/products/allProducts");
		return _mvShare;
	}

}
