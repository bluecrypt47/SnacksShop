package SnacksShop.UserController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.DAO.ProductsDAO;
import SnacksShop.DTO.ProductsDTO;
import SnacksShop.Entity.Bill;
import SnacksShop.Entity.Users;
import SnacksShop.Service.User.AccountServiecImple;
import SnacksShop.Service.User.BillServiceImple;
import SnacksShop.Service.User.IBillService;
import SnacksShop.Service.User.ProductDetailsServiceImple;

@Controller
public class HomeController extends BaseController {
	@Autowired
	ProductsDAO _ProductsDAO;

	@Autowired
	private IBillService _billService;

	@Autowired
	AccountServiecImple accountServiecImple = new AccountServiecImple();

	@Autowired
	BillServiceImple billServiceImple = new BillServiceImple();

	// -------------------
	@Autowired
	ProductDetailsServiceImple productDetailsServiceImple = new ProductDetailsServiceImple();
	// -----------------------

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {

		String name = "";

		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.addObject("viewProductsNew", _homeService.GetDataProductsViewNew());
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

	@RequestMapping(value = "/gioi-thieu")
	public ModelAndView aboutUs() {

		_mvShare.setViewName("user/aboutUS");
		return _mvShare;
	}

	@RequestMapping(value = "/lien-he")
	public ModelAndView contact() {

		_mvShare.setViewName("user/contact");
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

	// xóa user
	@RequestMapping(value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable int id, Model model, HttpServletRequest request) {

		accountServiecImple.delete(id);

		model.addAttribute("listUser", accountServiecImple.GetDataUsers());

		return "redirect:" + request.getHeader("Referer");
	}

	// ---Products---
	@RequestMapping(value = { "/quan-ly-san-pham" })
	public ModelAndView productsManager() {

		_mvShare.addObject("productsManager", _homeService.GetAllProducts());
		_mvShare.setViewName("admin/productsManager/products");
		return _mvShare;
	}

	@RequestMapping(value = { "/them-san-pham" })
	public ModelAndView index() {

		// model.addAttribute("addProduct", new ProductsDTO());

		_mvShare.setViewName("admin/productsManager/addProduct");
		return _mvShare;
	}

	// ------------------------------------1

	@RequestMapping(value = { "/them-san-pham" }, method = RequestMethod.GET)
	public ModelAndView addProduct() {

		_mvShare.addObject("addProducts", new ProductsDTO());
		_mvShare.setViewName("admin/productsManager/addProduct");
		return _mvShare;
	}

	@RequestMapping(value = { "/them-san-pham" }, method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute("addProducts") ProductsDTO addProducts) {
		_mvShare.setViewName("admin/productsManager/addProduct");
		return _mvShare;
	}
	// ------------------------------------
	@RequestMapping(value = "/search")
	public ModelAndView searchProduct(@RequestParam String name) {
		List< ProductsDTO> productsDTO = productDetailsServiceImple.GetProductByName(name);
		_mvShare.addObject("search", productsDTO);
		_mvShare.setViewName("user/products/searchProduct");
		return _mvShare;
	}

	// ------------------------------------3
	@RequestMapping(value = "/sua-san-pham", method = RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("admin/productsManager/editProduct");
		// ---------------------------

		ProductsDTO productsDTO = new ProductsDTO();
		ProductsDTO infoProduct = (ProductsDTO) session.getAttribute("infoProduct");
		if (infoProduct != null) {
			productsDTO.setMaLoai(infoProduct.getMaLoai());
			productsDTO.setTenSP(infoProduct.getTenSP());
			productsDTO.setImage(infoProduct.getImage());
			productsDTO.setGiaBan(infoProduct.getGiaBan());
			productsDTO.setGiamGia(infoProduct.getGiamGia());
		}

		_mvShare.addObject("products", productsDTO);

		// ---------------------------
		return _mvShare;
	}

	//
	@RequestMapping(value = "/sua-san-pham", method = RequestMethod.POST)
	public ModelAndView editProduct(HttpServletRequest request, HttpSession session, @ModelAttribute("product") ProductsDTO product) {
		_mvShare.setViewName("admin/productsManager/editProduct");
		// ---------------------------

		ProductsDTO productsDTO = new ProductsDTO();
		ProductsDTO infoProduct = (ProductsDTO) session.getAttribute("infoProduct");
		if (infoProduct != null) {
			productsDTO.setMaLoai(infoProduct.getMaLoai());
			productsDTO.setTenSP(infoProduct.getTenSP());
			productsDTO.setImage(infoProduct.getImage());
			productsDTO.setGiaBan(infoProduct.getGiaBan());
			productsDTO.setGiamGia(infoProduct.getGiamGia());
			productsDTO.setGioiThieu(infoProduct.getGioiThieu());
		}

		_mvShare.addObject("products", productsDTO);

		// ---------------------------
		return _mvShare;
	}
	//
	// ------------------------------------

	@RequestMapping(value = "/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		productDetailsServiceImple.delete(id);

		model.addAttribute("listProduct", _homeService.GetAllProducts());

		return "redirect:" + request.getHeader("Referer");
	}

	// Bill
	@RequestMapping(value = { "/quan-ly-hoa-don" })
	public ModelAndView billsManager() {
		_mvShare.addObject("billManager", _billService.GetAllBills());

		_mvShare.setViewName("admin/billManager/billManager");
		return _mvShare;
	}

	// chi tiết bill
	@RequestMapping(value = { "/quan-ly-chi-tiet-hoa-don/{id}" })
	public ModelAndView billsManagerDetails(@PathVariable int id) {

		_mvShare.setViewName("admin/billManager/billManagerDetaills");
		_mvShare.addObject("billDetails", _billService.GetBillDetailsByIDBill(id));
		return _mvShare;
	}

	// xóa Bill
	@RequestMapping(value = "/deleteBill/{id}")
	public String deleteBill(@PathVariable int id, Model model, HttpServletRequest request) {

		billServiceImple.delete(id);

		model.addAttribute("listBill", billServiceImple.GetAllBills());

		return "redirect:" + request.getHeader("Referer");
	}
}
