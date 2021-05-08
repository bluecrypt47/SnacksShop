package SnacksShop.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.DAO.ProductsDAO;
import SnacksShop.DTO.ProductsDTO;
import SnacksShop.Service.User.IBillService;

@Controller
public class HomeController extends BaseController {
	@Autowired
	ProductsDAO _ProductsDAO;
	
	@Autowired
	private IBillService _billService;

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {

		String name = "";

		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.addObject("searchProducts", _homeService.GetSearchProducts(name));

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
	@RequestMapping(value = { "/quan-tri" })
	public ModelAndView IndexAdmin() {

		_mvShare.setViewName("admin/admin");
		return _mvShare;
	}

	// ---Account---
	@RequestMapping(value = { "/quan-ly-tai-khoan" })
	public ModelAndView accountsManager() {

		_mvShare.addObject("accManagger", _accountService.GetDataUsers());
		_mvShare.setViewName("admin/accountManager/accounts");
		return _mvShare;
	}

	// ---Products---
	@RequestMapping(value = { "/quan-ly-san-pham" })
	public ModelAndView productsManager() {

		_mvShare.addObject("productsManager", _homeService.GetAllProducts());
		_mvShare.setViewName("admin/productsManager/products");
		return _mvShare;
	}

	// Bill
	@RequestMapping(value = { "/quan-ly-hoa-don" })
	public ModelAndView billsManager() {
		_mvShare.addObject("billManager", _billService.GetAllBills());

		_mvShare.setViewName("admin/billManager/billManager");
		return _mvShare;
	}

	@RequestMapping(value = { "/quan-ly-chi-tiet-hoa-don/{id}" })
	public ModelAndView billsManagerDetails(@PathVariable int id) {
		
		_mvShare.setViewName("admin/billManager/billManagerDetaills");
		_mvShare.addObject("billDetails", _billService.GetBillDetailsByIDBill(id));
		return _mvShare;
	}

	//

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<ProductsDTO> searchProduct(@RequestParam(value = "searchName") String searchName) {
		return _ProductsDAO.GetSearchProduct(searchName);
	}
}
