
package SnacksShop.Service.User;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.CartDTO;
import SnacksShop.Entity.Bill;

@Service
public interface IBillService {
	
	// thêm bill
	public int addBill(Bill bill);

	// thêm billDetails
	public void addBillDetails(HashMap<String, CartDTO> carts);

	// thêm bill và danh sách bill
	public List<Bill> GetAllBills();

	// lấy tất cả sản phẩm của bill theo id bill
	public Bill GetAllProdutsByIDBill(int idBill);

	// lấy ds tất cả sản phẩm của bill theo id bill
	public List<Bill> GetProductByIDBill(int id);

	//
	// public HashMap<Integer, BillDTO> deleteBill(int id, HashMap<Integer, BillDTO>
	// bill);

	// public HashMap<Integer, BillDAO> deleteBill(int idBill, HashMap<Integer,
	// BillDAO> bill);

}
