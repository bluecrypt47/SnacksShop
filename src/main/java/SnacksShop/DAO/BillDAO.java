
package SnacksShop.DAO;

import org.springframework.stereotype.Repository;

import SnacksShop.Entity.Bill;
import SnacksShop.Entity.BillDetails;

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
		sql.append(" '" + billDetails.getIdProduct() + "', " );
		sql.append(" '" + billDetails.getIdBill() + "', ");
		sql.append(" '"+ billDetails.getQuantity() + "', " );
		sql.append(" '" + billDetails.getTotal() + "' ");
		sql.append(") ");
//INSERT INTO `billdetails`(`id`, `idProduct`, `idBill`, `quantity`, `total`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]')
		int insert = _jdbcTemplate.update(sql.toString());

		return insert;
	}

}
