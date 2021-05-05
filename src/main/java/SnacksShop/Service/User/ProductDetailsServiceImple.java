package SnacksShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SnacksShop.DAO.ProductsDAO;
import SnacksShop.DTO.ProductsDTO;

@Service
public class ProductDetailsServiceImple implements IProductDetailsService{

	@Autowired
	ProductsDAO productsDAO = new ProductsDAO();
	
	@Override
	public ProductsDTO GetProductByID(String id) {
		
		List<ProductsDTO> listProductDetails = productsDAO.GetProductByID(id);
		
		return listProductDetails.get(0);
	}

	@Override
	public List<ProductsDTO> GetProductByIDType(int id) {
		
		return productsDAO.GetAllProductsByID(id);
	}

	//
	@Override
	public List<ProductsDTO> GetProductByName(String name) {
		return productsDAO.GetSearchProduct(name);
	}

	@Override
	public ProductsDTO GetProductName(String name) {
		List<ProductsDTO> listProductDetails = productsDAO.GetSearchProduct(name);
		return listProductDetails.get(2);
	}

}
