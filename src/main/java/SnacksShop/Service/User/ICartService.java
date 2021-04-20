package SnacksShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<String, CartDTO> addCart(String id, HashMap<String, CartDTO> cart);
	public HashMap<String, CartDTO> editCart(String id, int quantity, HashMap<String, CartDTO> cart);
	public HashMap<String, CartDTO> deleteCart(String id, HashMap<String, CartDTO> cart);
	public int totalQuantity(HashMap<String, CartDTO> cart);
	public double totalPrice(HashMap<String, CartDTO> cart);

}
