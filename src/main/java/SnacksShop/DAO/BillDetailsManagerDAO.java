package SnacksShop.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import SnacksShop.DTO.BillDetailsManagerDTO;
import SnacksShop.DTO.BillDetailsManagerDTOMapper;
import SnacksShop.Entity.MapperBill;
import SnacksShop.Entity.MapperBillDetails;

@Repository
public class BillDetailsManagerDAO extends BaseDAO {

	// Lay ra danh sach san pham có idBill

	public List<BillDetailsManagerDTO> GetBillDetailsByIDBill(int idBill) {
		String sql = "SELECT * FROM `billdetails` WHERE idBill = " + idBill + " ";
		List<BillDetailsManagerDTO> listProducts = _jdbcTemplate.query(sql, new BillDetailsManagerDTOMapper());
		return listProducts;
	}
}
