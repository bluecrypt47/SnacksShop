
package SnacksShop.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import SnacksShop.DTO.CartDTO;
import SnacksShop.Entity.Bill;
import SnacksShop.Entity.BillDetails;
import SnacksShop.Entity.MapperBill;
import SnacksShop.Entity.MapperBillDetails;
import SnacksShop.Entity.MapperMenus;
import SnacksShop.Entity.Menus;

@Repository
public class BillDAO extends BaseDAO {

	public int addBill(Bill bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bill ");
		sql.append("( ");
		sql.append("`name`, `email`, `phoneNumber`, `address`, `note`, `quantity`, `total` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("'" + bill.getName() + "', '" + bill.getEmail() + "', '" + bill.getPhoneNumber() + "', '"
				+ bill.getAddress() + "', '" + bill.getNote() + "', '" + bill.getQuantity() + "', '" + bill.getTotal()
				+ "' ");
		sql.append(") ");

		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	};

	public int getLastBill() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bill");
		int id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, int.class);
		return id;
	};

	public int addBillDetails(BillDetails billDetails) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO billdetails ");
		sql.append("( ");
		sql.append(" idProduct, ");
		sql.append(" idBill, ");
		sql.append(" quantity, ");
		sql.append(" total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" '" + billDetails.getIdProduct() + "', ");
		sql.append(" '" + billDetails.getIdBill() + "', ");
		sql.append(" '" + billDetails.getQuantity() + "', ");
		sql.append(" '" + billDetails.getTotal() + "' ");
		sql.append(") ");
		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}

	public List<Bill> GetDataBill() {
		List<Bill> listBills = new ArrayList<Bill>();

		String sql = "SELECT * FROM `bill`";
		listBills = _jdbcTemplate.query(sql, new MapperBill());

		return listBills;

	}

	public List<Bill> GetDataBillByID(int idBill) {
		List<Bill> listBillsByID = new ArrayList<Bill>();

		String sql = "SELECT * FROM `bill` WHERE id=" + idBill + "";
		listBillsByID = _jdbcTemplate.query(sql, new MapperBill());

		return listBillsByID;

	}
	
	/*
	 * public List<Bill> GetAllProdutsByIDBill(int idBill) { List<Bill>
	 * listBillsByIDBill = new ArrayList<Bill>();
	 * 
	 * String sql = "SELECT * FROM `billdetails`, bill WHERE bill.id = "+idBill+"";
	 * listBillsByIDBill = _jdbcTemplate.query(sql, new MapperBill());
	 * 
	 * return listBillsByIDBill;
	 * 
	 * }
	 */
	

	/*
	 * public HashMap<Integer, BillDAO> deleteBill(int id, HashMap<Integer, BillDAO>
	 * bill) { BillDAO itemBill = new BillDAO();
	 * 
	 * if (bill == null) { return bill; }
	 * 
	 * if (bill.containsKey(id)) { bill.remove(id); } return bill; }
	 */

}
