package SnacksShop.Service.User;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.PaginatesDTO;

@Service
public interface IPaginatesService {
	public PaginatesDTO GetInfoPaginates(int currentPage, int limitProductsOfPage, int totalData);

}
