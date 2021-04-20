package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.ProductsDAO;
import SnacksShop.DTO.ProductsDTO;

@Service
public class CategorysServiceImple implements ICategorysService {

	@Autowired
	private ProductsDAO productsDAO;

	@Override
	public List<ProductsDTO> GetAllProductsByID(int id) {
		return productsDAO.GetAllProductsByID(id);
	}

	@Override
	public List<ProductsDTO> GetDataProductsPaginate(int id, int start, int totalPage) {
		return productsDAO.GetDataProductsPaginates(id, start, totalPage);
	}
}
