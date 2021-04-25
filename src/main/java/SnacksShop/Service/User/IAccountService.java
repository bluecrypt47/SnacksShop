package SnacksShop.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.Entity.Users;

@Service
public interface IAccountService {

	@Autowired
	public int addAccount(Users user);

	@Autowired
	public boolean checkAccount(Users user);
}
