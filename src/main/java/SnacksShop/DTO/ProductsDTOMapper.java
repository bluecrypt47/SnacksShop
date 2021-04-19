package SnacksShop.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDTOMapper implements RowMapper<ProductsDTO> {

	public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDTO products = new ProductsDTO();
		
		products.setMaSP(rs.getString("maSP"));
		products.setMaLoai(rs.getInt("maLoai"));
		products.setTenSP(rs.getString("tenSP"));
		products.setImage(rs.getString("image"));
		products.setNgayTao(rs.getDate("ngayTao"));
		products.setNgayCapNhat(rs.getDate("ngayCapNhat"));
		products.setGiaBan(rs.getDouble("giaBan"));
		products.setGiamGia(rs.getInt("giamGia"));
		products.setGioiThieu(rs.getString("gioiThieu"));
		products.setNoiBat(rs.getBoolean("noiBat"));
		products.setSanPhamMoi(rs.getBoolean("sanPhamMoi"));
		
		return products;
	}
}
