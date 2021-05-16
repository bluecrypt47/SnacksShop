package SnacksShop.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// Đăng ký
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

	// Đăng nhập
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

	// Đăng xuất
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request) {

		session.removeAttribute("loginInfo");
		return "redirect:" + request.getHeader("Referer");
	}

	// -----------------------------------------

	// Thông tin tài khoản
	@RequestMapping(value = "/thong-tin-tai-khoan", method = RequestMethod.GET)
	public ModelAndView infoAccount(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/account/infoAccount");
		
		Users user = new Users();

		Users infoAcc = (Users) session.getAttribute("infoAcc");
		if (infoAcc != null) {
			user.setUser(infoAcc.getUser());
			user.setPassword(infoAcc.getPassword());
			user.setName(infoAcc.getName());
			user.setAddress(infoAcc.getAddress());
			user.setPhoneNumber(infoAcc.getPhoneNumber());

		}

		_mvShare.addObject("Users", user);
		return _mvShare;
	}
	// -----------------------------------------

}
