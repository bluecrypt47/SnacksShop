package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.SlidesDAO;
import SnacksShop.Entity.Slides;

@Service
public class HomeServiecImple implements IHomeService {

	@Autowired
	private SlidesDAO slidesDAO;
	@Override
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}

}
