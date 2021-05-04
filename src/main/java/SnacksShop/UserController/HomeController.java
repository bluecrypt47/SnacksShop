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
	
	// ADMIN
	@RequestMapping(value = {  "/quan-tri" })
	public ModelAndView IndexAdmin() {
		
		_mvShare.setViewName("admin/admin");
		return _mvShare;
	}
	
	@RequestMapping(value = {  "/quan-ly-tai-khoan" })
	public ModelAndView accountsManager() {
		
		_mvShare.addObject("accManagger", _accountService.GetDataUsers());
		_mvShare.setViewName("admin/accountManager/accounts");
		return _mvShare;
	}
	
	@RequestMapping(value = {  "/quan-ly-san-pham" })
	public ModelAndView productsManager() {
		
		_mvShare.addObject("productsManager", _homeService.GetAllProducts());
		_mvShare.setViewName("admin/productsManager/products");
		return _mvShare;
	}

	// Bill
	@RequestMapping(value = {  "/quan-ly-hoa-don" })
	public ModelAndView billsManager() {
		_mvShare.addObject("billManager", _billService.GetAllBills());
		
		_mvShare.setViewName("admin/billManager/billManager");
		return _mvShare;
	}
	
	@RequestMapping(value = {  "/quan-ly-chi-tiet-hoa-don" })
	public ModelAndView billsManagerDetails() {
		
		_mvShare.setViewName("admin/billManager/billManagerDetaills");
		return _mvShare;
	}
}
