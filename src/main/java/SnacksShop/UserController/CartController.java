package SnacksShop.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import SnacksShop.DTO.CartDTO;
import SnacksShop.Service.User.CartServiceImple;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImple cartServiceImple = new CartServiceImple();

	@RequestMapping(value="AddCart/{id}")
	public String addcart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDTO> cart= (HashMap<String, CartDTO>)session.getAttribute("Cart");
		
		if(cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartServiceImple.addCart(id, cart);
		session.setAttribute("Cart", cart);
		
//		return "redirect:/chi-tiet-san-pham/"+id;
		return "redirect:"+ request.getHeader("Referer");
	}
}
