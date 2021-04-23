package SnacksShop.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.DTO.CartDTO;
import SnacksShop.Service.User.CartServiceImple;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImple cartServiceImple = new CartServiceImple();

	@RequestMapping(value = "gio-hang")
	public ModelAndView listCart() {

		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("catogorys", _homeService.GetDataCatogorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		/* _mvShare.addObject("newProducts", _homeService.GetDataNewProducts()); */

		_mvShare.setViewName("user/cart/listCart");
		return _mvShare;
	}

	@RequestMapping(value = "AddCart/{id}")
	public String addcart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartServiceImple.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "EditCart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable String id, @PathVariable int quantity) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartServiceImple.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "DeleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDTO> cart = (HashMap<String, CartDTO>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<String, CartDTO>();
		}
		cart = cartServiceImple.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantityCart", cartServiceImple.totalQuantity(cart));
		session.setAttribute("TotalPriceCart", cartServiceImple.totalPrice(cart));

		return "redirect:" + request.getHeader("Referer");
	}
}
