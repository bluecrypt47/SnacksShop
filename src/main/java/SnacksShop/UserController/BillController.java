package SnacksShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.Service.User.BillServiceImple;

@Controller
public class BillController extends BaseController {

	/*
	 * @Autowired private BillServiceImple billServiceImple = new
	 * BillServiceImple();
	 */

	/*
	 * @Autowired private CartServiceImple cartServiceImple = new
	 * CartServiceImple();
	 */

	@RequestMapping(value = "/checkout")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/bill/checkout");
		return mv;
	}

	//

	/*
	 * @RequestMapping(value = "DeleteBill/{id}") public String
	 * deleteBill(HttpServletRequest request, HttpSession session, @PathVariable int
	 * id) { HashMap<Integer, BillDTO> bill = (HashMap<Integer, BillDTO>)
	 * session.getAttribute("Bill");
	 * 
	 * if (bill == null) { bill = new HashMap<Integer, BillDTO>(); } bill =
	 * billServiceImple.deleteBill(id, bill); session.setAttribute("Bill", bill);
	 * 
	 * return "redirect:" + request.getHeader("Referer"); }
	 */

	@RequestMapping(value = "/chi-tiet")
	public ModelAndView ProductByBill(int id) {

		//_mvShare.addObject("productsByBill", _billService.GetAllProdutsByIDBill(id));

		_mvShare.setViewName("admin/billManager/billManagerDetaills");
		return _mvShare;
	}

	/*
	 * @RequestMapping(value = "/chi-tiet") public ModelAndView ProductByBill(int
	 * id) {
	 * 
	 * _mvShare.addObject("productsByBill", _billService.GetAllProdutsByIDBill(id));
	 * 
	 * int idBill = _billService.GetAllProdutsByIDBill(id).ge
	 * 
	 * int idTypeProducts = _productDetailsService.GetProductByID(id).getMaLoai();
	 * _mvShare.addObject("productDetailByIDType",
	 * _productDetailsService.GetProductByIDType(idTypeProducts));
	 * 
	 * _mvShare.setViewName("admin/billManager/billManagerDetaills"); return
	 * _mvShare; }
	 */

	/*
	 * @RequestMapping(value = "DeleteBill/{id}") public String
	 * deleteBill(HttpServletRequest request, HttpSession session, @PathVariable
	 * Integer id) { HashMap<Integer, BillDAO> bill = (HashMap<Integer, BillDAO>)
	 * session.getAttribute("Bill");
	 * 
	 * if (bill == null) { bill = new HashMap<Integer, BillDAO>(); } bill =
	 * billServiceImple.deleteBill(id, bill); session.setAttribute("Bill", bill);
	 * session.setAttribute("TotalQuantityCart",
	 * cartServiceImple.totalQuantity(bill)); session.setAttribute("TotalPriceCart",
	 * cartServiceImple.totalPrice(bill));
	 * 
	 * return "redirect:" + request.getHeader("Referer"); }
	 */
}
