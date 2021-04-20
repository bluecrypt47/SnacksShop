package SnacksShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.ProductsDTO;

@Service
public interface IProductDetailsService {
	public ProductsDTO GetProductByID(String id);
	public List<ProductsDTO> GetProductByIDType(int id);
}