package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.CatogorysDAO;
import SnacksShop.DAO.MenusDAO;
import SnacksShop.DAO.SlidesDAO;
import SnacksShop.Entity.Catogorys;
import SnacksShop.Entity.Menus;
import SnacksShop.Entity.Slides;

@Service
public class HomeServiecImple implements IHomeService {

	@Autowired
	private SlidesDAO slidesDAO;
	@Autowired
	private CatogorysDAO catogorysDAO;
	@Autowired
	private MenusDAO menusDAO;

	@Override
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}

	public List<Catogorys> GetDataCatogorys() {
		return catogorysDAO.GetDataCatogorys();
	}

	public List<Menus> GetDataMenus() {
		return menusDAO.GetDataMenus();
	}

}
