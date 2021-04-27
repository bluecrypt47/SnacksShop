package SnacksShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SnacksShop.Entity.Catogorys;
import SnacksShop.Entity.MapperCatogorys;

@Repository
public class CatogorysDAO extends BaseDAO{
	

	// lay ra danh sach cac loai san pham trong DB
	public List<Catogorys> GetDataCatogorys() {
		List<Catogorys> listCatogorys = new ArrayList<Catogorys>();
		String sql = "SELECT * FROM loaisanpham";
		listCatogorys = _jdbcTemplate.query(sql, new MapperCatogorys());

		return listCatogorys;

	}
}
