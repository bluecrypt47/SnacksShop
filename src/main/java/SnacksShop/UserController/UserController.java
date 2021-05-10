package SnacksShop.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.Entity.Users;
import SnacksShop.Service.User.AccountServiecImple;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiecImple accountServiecImple = new AccountServiecImple();

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {

		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("usersRegister", new Users());

		return _mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("users") Users users) {

		int count = accountServiecImple.addAccount(users);
		if (count > 0) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công!!!");
		} else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại!!!");
		}

		_mvShare.setViewName("user/account/register");

		return _mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("users") Users users) {

		users = accountServiecImple.checkAccount(users);

		if (users != null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("loginInfo", users);
		} else {
			_mvShare.addObject("statusLogin", "Đăng nhập tài khoản thất bại!!!");
		}
		return _mvShare;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {

		session.removeAttribute("loginInfo");
		return "redirect:" + request.getHeader("Referer");
	}
	


	// ------------------------------2

	/*
	 * @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST) public
	 * ModelAndView login(@Valid HttpSession session, @ModelAttribute("users") Users
	 * users, Errors err) {
	 * 
	 * //users = accountServiecImple.checkAccount(users);
	 * 
	 * //registerValidate.validate(users, br);
	 * 
	 * if (err.hasErrors()) { return _mvShare; }
	 * 
	 * 
	 * if (users != null) { _mvShare.setViewName("redirect:trang-chu");
	 * session.setAttribute("loginInfo", users); } else {
	 * _mvShare.addObject("statusLogin", "Đăng nhập tài khoản thất bại!!!"); }
	 * 
	 * return _mvShare; }
	 */

	// ------------------------------
	


	// ------------------------------3

	

	// ------------------------------
}
