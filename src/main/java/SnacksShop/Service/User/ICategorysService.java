package SnacksShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import SnacksShop.Entity.Products;

@Service
public interface ICategorysService {
	public List<Products> GetAllProductsByID(int id);
	public List<Products> GetDataProductsPaginate(int id, int start, int end);
}
