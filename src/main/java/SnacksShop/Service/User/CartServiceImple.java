package SnacksShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.CartDAO;
import SnacksShop.DTO.CartDTO;

@Service
public class CartServiceImple implements ICartService {
	@Autowired
	public CartDAO cartDAO = new CartDAO();

	@Override
	public HashMap<String, CartDTO> addCart(String id, HashMap<String, CartDTO> cart) {
		return cartDAO.addCart(id, cart);
	}

	@Override
	public HashMap<String, CartDTO> editCart(String id, int quantity, HashMap<String, CartDTO> cart) {
		return cartDAO.editCart(id, quantity, cart);
	}

	@Override
	public HashMap<String, CartDTO> deleteCart(String id, HashMap<String, CartDTO> cart) {
		return cartDAO.deleteCart(id, cart);
	}

	@Override
	public int totalQuantity(HashMap<String, CartDTO> cart) {
		return cartDAO.totalQuantity(cart);
	}

	@Override
	public double totalPrice(HashMap<String, CartDTO> cart) {
		return cartDAO.totalPrice(cart);
	}
}
