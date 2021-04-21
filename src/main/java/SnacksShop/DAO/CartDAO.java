package SnacksShop.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SnacksShop.DTO.CartDTO;
import SnacksShop.DTO.ProductsDTO;

@Repository
public class CartDAO extends BaseDAO {

	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();

	public HashMap<String, CartDTO> addCart(String id, HashMap<String, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductsDTO product = productsDAO.FindProductByID(id);

		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getGiaBan());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getGiaBan());
		}

		cart.put(id, itemCart);

		return cart;
	}

	public HashMap<String, CartDTO> editCart(String id, int quantity, HashMap<String, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			itemCart = cart.get(id);

			itemCart.setQuantity(quantity);
			double totalPrice = (quantity * itemCart.getProduct().getGiaBan());
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);

		return cart;
	}

	public HashMap<String, CartDTO> deleteCart(String id, HashMap<String, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();

		if (cart == null) {
			return cart;
		}

		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int totalQuantity(HashMap<String, CartDTO> cart) {

		int totalQua = 0;

		for (Map.Entry<String, CartDTO> itemCart : cart.entrySet()) {
			totalQua += itemCart.getValue().getQuantity();
		}

		return totalQua;
	}

	public double totalPrice(HashMap<String, CartDTO> cart) {

		double totalPri = 0;

		for (Map.Entry<String, CartDTO> itemCart : cart.entrySet()) {
			totalPri += itemCart.getValue().getTotalPrice();
		}

		return totalPri;
	}
}
