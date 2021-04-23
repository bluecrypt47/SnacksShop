package SnacksShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SnacksShop.Entity.MapperUsers;
import SnacksShop.Entity.Users;

@Repository
public class UsersDAO extends BaseDAO{
	
//	private StringBuffer SqlString(String user, String password, String name, String address, String phoneNumber) {
//		StringBuffer sql = new StringBuffer();
//		sql.append("INSERT ");
//		sql.append("INTO users ");
//		sql.append("( ");
//		sql.append(" user, password, name, address, phoneNumber ");
//		sql.append(" )  ");
//		sql.append(" VALUESr ");
//		sql.append("( ");
//		sql.append("["+user+"],["+password+"],["+name+"],["+address+"],["+phoneNumber+"] ");
//		sql.append(" )  ");
//		return sql;
//	}
	

	
	public int addAccount(Users user){
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append(" user, password, name, address, phoneNumber ");
		sql.append(" )  ");
		sql.append(" VALUES ");
		sql.append("( ");
		sql.append("'"+user.getUser()+"','"+user.getPassword()+"','"+user.getName()+"','"+user.getAddress()+"','"+user.getPhoneNumber()+"' ");
		sql.append(" )  ");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;
	}
}
