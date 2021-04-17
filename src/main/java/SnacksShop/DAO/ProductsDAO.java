package SnacksShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SnacksShop.Entity.MapperNewProducts;
import SnacksShop.Entity.MapperProducts;
import SnacksShop.Entity.Products;

@Repository
public class ProductsDAO extends BaseDAO {
	
	public List<Products> GetDataProducts() {
		List<Products> listProducts = new ArrayList<Products>();

		String sql = "SELECT * FROM sanpham WHERE noiBat= true ORDER by RAND() LIMIT 12 ";
		listProducts = _jdbcTemplate.query(sql, new MapperProducts());

		return listProducts;

	}
	
	public List<Products> GetDataNewProducts() {
		List<Products> listNewProducts = new ArrayList<Products>();

		String sql = "SELECT * FROM sanpham WHERE sanPhamMoi= true ORDER by RAND() LIMIT 12 ";
		listNewProducts = _jdbcTemplate.query(sql, new MapperNewProducts());

		return listNewProducts;

	}
}
