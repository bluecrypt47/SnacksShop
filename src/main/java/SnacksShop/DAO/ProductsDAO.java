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

	// D�ng Stringbuffer de co the truy van kep
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("* ");
		sql.append("FROM ");
		sql.append("sanpham ");
		return sql;
	}

	// truy van lay ra cac san pham noi bat hoac san pham moi
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

	// Lay ra danh sach san pham noi bat hoac san pham moi
	public List<ProductsDTO> GetDataProducts() {
		String sql = SqlProducts(YES, NO);
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	// tim san pham theo id loai cua no
	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maLoai = " + id + " ");

		return sql;
	}

	// lay ra tat ca san pham co cung id loai
	public List<ProductsDTO> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}

	// truy van gioi han san pham co trong 1 trang de co the de dang phan trang
	private String SqlProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);

		sql.append("LIMIT " + start + ", " + totalPage + " ");

		return sql.toString();
	}

	// lay ra so san pham tu cau truy van LIMIT
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

	// lay ra tat ca san pham co cung id san pham
	private String SqlProductDetailsByID(long id) {
		StringBuffer sql = SqlString();

		sql.append("WHERE maSP = N'" + id + "' ");

		return sql.toString();
	}

	// lay ra danh sach tat ca san pham co cung id san pham
	public List<ProductsDTO> GetProductByID(long id) {
		String sql = SqlProductDetailsByID(id);
		List<ProductsDTO> productDetails = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return productDetails;
	}

	// tim va xem chi tiet san pham bang id
	public ProductsDTO FindProductByID(long id) {
		String sql = SqlProductDetailsByID(id);
		ProductsDTO product = _jdbcTemplate.queryForObject(sql, new ProductsDTOMapper());
		return product;
	}

	// lay ra tat ca san pham
	public List<ProductsDTO> GetAllProduct() {
		String sql = "SELECT * FROM sanpham";
		List<ProductsDTO> listAllProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listAllProducts;
	}

	// tim kiem
	public List<ProductsDTO> GetSearchProduct(String name) {
		String sql = "SELECT * FROM `sanpham` WHERE tenSP LIKE '%" + name + "%'";
		List<ProductsDTO> listAllProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listAllProducts;
	}

	public void addProduct(ProductsDTO productsDTO) {
		String sql = "INSERT INTO `sanpham`(`maSP`,`maLoai`,`tenSP`,`image`, `giaBan`,`giamGia`,`gioiThieu`) VALUES ('?', '?', '?', '?', '?', '?', '?')";
		_jdbcTemplate.update(sql, productsDTO.getMaSP(), productsDTO.getMaLoai(), productsDTO.getTenSP(),
				productsDTO.getImage(), productsDTO.getGiaBan(), productsDTO.getGiamGia(), productsDTO.getGioiThieu());
	}
}
