package SnacksShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.Entity.Users;
import SnacksShop.Service.User.AccountServiecImple;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiecImple accountServiecImple = new AccountServiecImple();
	
	@RequestMapping(value="/dang-ky", method= RequestMethod.GET)
	public ModelAndView register() {
		
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("usersRegister", new Users());
		
		return _mvShare;
	}
	
	@RequestMapping(value="/dang-ky", method= RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("users") Users users) {
		
		int count = accountServiecImple.addAccount(users);
		if(count >0) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công!!!");
		}
		else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại!!!");
		}
		
		_mvShare.setViewName("user/account/register");
		
		return _mvShare;
	}
}
