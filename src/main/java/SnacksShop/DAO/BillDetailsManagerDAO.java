package SnacksShop.DAO;

import java.util.List;

import SnacksShop.DTO.BillDetailsManagerDTO;
import SnacksShop.DTO.BillDetailsManagerDTOMapper;

public class BillDetailsManagerDAO extends BaseDAO {

	// Lay ra danh sach san pham có idBill
	public List<BillDetailsManagerDTO> GetDataProductsByBillID(int idBill) {
		String sql = "SELECT * FROM `billdetails` WHERE idBill = '" + idBill + "' ";
		List<BillDetailsManagerDTO> listProducts = _jdbcTemplate.query(sql, new BillDetailsManagerDTOMapper());
		return listProducts;
	}
	
}
