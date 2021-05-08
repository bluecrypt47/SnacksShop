package SnacksShop.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BillDetailsManagerDTOMapper implements RowMapper<BillDetailsManagerDTO> {

	/*
	 * public BillDetailsManagerDTO mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { BillDetailsManagerDTO billDetailsManager = new
	 * BillDetailsManagerDTO();
	 * 
	 * billDetailsManager.setId(rs.getInt("id"));
	 * billDetailsManager.setIdProduct(rs.getString("idProduct"));
	 * billDetailsManager.setIdBill(rs.getInt("idBill"));
	 * billDetailsManager.setQuantity(rs.getInt("quantity"));
	 * billDetailsManager.setTotal(rs.getDouble("total"));
	 * 
	 * return billDetailsManager; }
	 */
	
	//-----------------------------------
	public BillDetailsManagerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetailsManagerDTO billDetailsManager = new BillDetailsManagerDTO();

		billDetailsManager.setId(rs.getInt("id"));
		billDetailsManager.setQuantity(rs.getInt("quantity"));
		billDetailsManager.setTotal(rs.getDouble("total"));

		return billDetailsManager;
	}

}
