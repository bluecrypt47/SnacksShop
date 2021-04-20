package SnacksShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SnacksShop.DTO.ProductsDTO;
import SnacksShop.DTO.ProductsDTOMapper;

@Repository
public class ProductsDAO extends BaseDAO {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("* ");
		sql.append("FROM ");
		sql.append("sanpham ");
		return sql;
	}

	private String SqlProducts(boolean sanPhamMoi, boolean noiBat) {
		StringBuffer sql = SqlString();
		if (noiBat) {
			sql.append("WHERE noiBat = true ");
		}
		if (sanPhamMoi) {
			sql.append("WHERE sanPhamMoi = true ");
		}
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 12 ");
		return sql.toString();
	}

	public List<ProductsDTO> GetDataProducts() {
		String sql = SqlProducts(YES, NO);
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maLoai = " + id + " ");

		return sql;
	}

	public List<ProductsDTO> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	private String SqlProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	public List<ProductsDTO> GetDataProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sqlDataByID = SqlProductsByID(id);

		List<ProductsDTO> listDataByID = _jdbcTemplate.query(sqlDataByID.toString(), new ProductsDTOMapper());
		List<ProductsDTO> listProducts = new ArrayList<ProductsDTO>();

		if (listDataByID.size() > 0) {
			String sql = SqlProductsPaginates(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}

		return listProducts;
	}

	private String SqlProductDetailsByID(String id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maSP = N'" + id + "' ");

		return sql.toString();
	}

	public List<ProductsDTO> GetProductByID(String id) {
		String sql = SqlProductDetailsByID(id);
		List<ProductsDTO> productDetails = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return productDetails;
	}
}
