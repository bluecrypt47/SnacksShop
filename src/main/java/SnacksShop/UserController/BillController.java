package SnacksShop.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.DAO.BillDAO;
import SnacksShop.DTO.CartDTO;
import SnacksShop.Service.User.BillServiceImple;
import SnacksShop.Service.User.CartServiceImple;

@Controller
public class BillController extends BaseController {
	/*
	 * @Autowired private BillServiceImple billServiceImple = new
	 * BillServiceImple();
	 * 
	 * @Autowired private CartServiceImple cartServiceImple = new
	 * CartServiceImple();
	 */
	
	@RequestMapping(value = "/checkout")
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView("user/bill/checkout");
		return mv;
	}
	
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
