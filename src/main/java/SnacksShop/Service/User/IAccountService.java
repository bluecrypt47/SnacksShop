package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.UsersDAO;



@Service
public interface IAccountService {
	
	@Autowired
	public List<UsersDAO> addAccount();
}
