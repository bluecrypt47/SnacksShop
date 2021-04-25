package SnacksShop.DAO;

import org.springframework.stereotype.Repository;

import SnacksShop.DTO.ProductsDTO;
import SnacksShop.Entity.MapperUsers;
import SnacksShop.Entity.Users;

@Repository
public class UsersDAO extends BaseDAO{

	

	
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
	
public Users getAccount(Users user){
		
		String sql = "SELECT * FROM users WHERE user = '"+user.getUser()+"'";
		
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		
		return result;
	}
}
