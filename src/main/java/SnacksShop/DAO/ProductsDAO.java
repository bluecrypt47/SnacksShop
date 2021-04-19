package SnacksShop.DAO;

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
}


/*
 * @Repository public class ProductsDAO extends BaseDAO {
 * 
 * public List<Products> GetDataProducts() { List<Products> listProducts = new
 * ArrayList<Products>();
 * 
 * String sql =
 * "SELECT * FROM sanpham WHERE noiBat= true ORDER by RAND() LIMIT 12 ";
 * listProducts = _jdbcTemplate.query(sql, new MapperProducts());
 * 
 * return listProducts;
 * 
 * }
 * 
 * public List<Products> GetDataNewProducts() { List<Products> listNewProducts =
 * new ArrayList<Products>();
 * 
 * String sql =
 * "SELECT * FROM sanpham WHERE sanPhamMoi= true ORDER by RAND() LIMIT 12 ";
 * listNewProducts = _jdbcTemplate.query(sql, new MapperNewProducts());
 * 
 * return listNewProducts;
 * 
 * }
 * 
 * public List<Products> GetDataProductsByID(int id) { List<Products>
 * listProducts = new ArrayList<Products>();
 * 
 * String sql = "SELECT * FROM sanpham WHERE maLoai = " + id+ " "; listProducts
 * = _jdbcTemplate.query(sql, new MapperProducts());
 * 
 * return listProducts; }
 * 
 * public List<Products> GetDataProductsPaginates(int id, int start, int
 * totalPage) { List<Products> listProducts = new ArrayList<Products>();
 * 
 * String sql = "SELECT * FROM sanpham LIMIT " + start + ", " + totalPage;
 * listProducts = _jdbcTemplate.query(sql, new MapperProducts());
 * 
 * return listProducts; }
 * 
 * }
 */
