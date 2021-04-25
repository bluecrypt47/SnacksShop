package SnacksShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.UsersDAO;
import SnacksShop.Entity.Users;

@Service
public class AccountServiecImple {
	@Autowired
	UsersDAO userDAO = new UsersDAO();

	public int addAccount(Users user) {

		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

		return userDAO.addAccount(user);
	}

	public Users checkAccount(Users user) {
		String passw = user.getPassword();

		user = userDAO.getAccount(user);

		if (user != null) {
			if (BCrypt.checkpw(passw, user.getPassword())) {
				return user;
			} else {
				return null;
			}

		}
		return null;
	}

}
