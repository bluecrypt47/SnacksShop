package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.ProductsDAO;
import SnacksShop.Entity.Products;

@Service
public class CategorysServiceImple implements ICategorysService {

	@Autowired
	private ProductsDAO productsDAO;

	@Override
	public List<Products> GetAllProductsByID(int id) {
		return productsDAO.GetDataProductsByID(id);
	}

	@Override
	public List<Products> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDAO.GetDataProductsPaginates(id, start, totalPage);
	}
}
