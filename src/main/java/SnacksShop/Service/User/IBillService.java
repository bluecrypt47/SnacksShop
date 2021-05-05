
package SnacksShop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import SnacksShop.DAO.BillDAO;
import SnacksShop.DTO.CartDTO;
import SnacksShop.DTO.ProductsDTO;
import SnacksShop.Entity.Bill;
import SnacksShop.Entity.BillDetails;

@Service
public interface IBillService {
	public int addBill(Bill bill);
	public void addBillDetails(HashMap<String, CartDTO> carts);
	public List<Bill> GetAllBills();
	/*
	 * public Bill GetAllProdutsByIDBill(int idBill); public List<Bill>
	 * GetProductByIDType(int id);
	 */
	/*
	 * public HashMap<Integer, BillDAO> deleteBill(int idBill, HashMap<Integer,
	 * BillDAO> bill);
	 */
}
