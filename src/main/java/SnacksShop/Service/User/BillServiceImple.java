
package SnacksShop.Service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.BillDAO;
import SnacksShop.DAO.BillDetailsManagerDAO;
import SnacksShop.DTO.BillDetailsManagerDTO;
import SnacksShop.DTO.CartDTO;
import SnacksShop.Entity.Bill;
import SnacksShop.Entity.BillDetails;

@Service
public class BillServiceImple implements IBillService {

	@Autowired
	public BillDAO billDAO;

	@Autowired
	BillDetailsManagerDAO billDetailsManagerDAO = new BillDetailsManagerDAO();

	@Override
	public int addBill(Bill bill) {
		return billDAO.addBill(bill);
	}

	@Override
	public void addBillDetails(HashMap<String, CartDTO> carts) {

		int idBill = billDAO.getLastBill();

		for (Map.Entry<String, CartDTO> itemCart : carts.entrySet()) {
			BillDetails billDetails = new BillDetails();
			billDetails.setIdBill(idBill);
			billDetails.setIdProduct(itemCart.getValue().getProduct().getMaSP());
			billDetails.setQuantity(itemCart.getValue().getQuantity());
			billDetails.setTotal(itemCart.getValue().getTotalPrice());
			billDAO.addBillDetails(billDetails);
		}
	}

	@Override
	public List<Bill> GetAllBills() {
		return billDAO.GetDataBill();
	}

	@Override
	public Bill GetAllProdutsByIDBill(int idBill) {
		List<Bill> listBill = billDAO.GetDataBillByID(idBill);
		return listBill.get(0);
	}

	@Override
	public List<Bill> GetProductByIDBill(int id) {
		return billDAO.GetDataBillByID(id);
	}


	//
	/*
	 * @Override public BillDetailsManagerDTO GetBillDetailsByIDBill(int idBill) {
	 * List<BillDetailsManagerDTO> listProductDetailsByIDBill =
	 * billDetailsManagerDAO.GetBillDetailsByIDBill(idBill); return
	 * listProductDetailsByIDBill.get(0); }
	 */
	
	@Override
	public List<BillDetailsManagerDTO> GetBillDetailsByIDBill(int idBill) {
		//List<BillDetailsManagerDTO> listProductDetailsByIDBill = billDetailsManagerDAO.GetBillDetailsByIDBill(idBill);
		return billDetailsManagerDAO.GetBillDetailsByIDBill(idBill);
	}
	
	@Override
	public List<Bill> deleteBillByID(int idBill) {
		
		return billDAO.deleteBillByIDl(idBill);
	}

	

}
