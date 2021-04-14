package SnacksShop.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SnacksShop.Entity.MapperSlides;
import SnacksShop.Entity.Slides;

@Repository
public class SlidesDAO {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Slides> GetDataSlide(){
		List<Slides> listSlides = new ArrayList<Slides>();
		String sql ="SELECT * FROM slide";
		listSlides = _jdbcTemplate.query(sql, new MapperSlides());
		
		return listSlides;
	}
}
