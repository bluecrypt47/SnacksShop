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
	public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDAO.addCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
		return cartDAO.editCart(id, quantity, cart);
	}

	@Override
	public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDAO.deleteCart(id, cart);
	}

	@Override
	public int totalQuantity(HashMap<Long, CartDTO> cart) {
		return cartDAO.totalQuantity(cart);
	}

	@Override
	public double totalPrice(HashMap<Long, CartDTO> cart) {
		return cartDAO.totalPrice(cart);
	}
}
