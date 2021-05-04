
package SnacksShop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import SnacksShop.DAO.BillDAO;
import SnacksShop.DTO.CartDTO;
import SnacksShop.Entity.Bill;

@Service
public interface IBillService {
	public int addBill(Bill bill);
	public void addBillDetails(HashMap<String, CartDTO> carts);
	public List<Bill> GetAllBills();
	/*
	 * public HashMap<Integer, BillDAO> deleteBill(int idBill, HashMap<Integer,
	 * BillDAO> bill);
	 */
}
