package SnacksShop.Service.User;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.PaginatesDTO;

@Service
public class PaginatesServiceImple {
	public PaginatesDTO GetInfoPaginates(int totalData, int limitProductsOfPage, int currentPage) {
		PaginatesDTO paginates = new PaginatesDTO();

		paginates.setLimitProductsOfPage(limitProductsOfPage);
		
		paginates.setTotalPage(setInfoTotalPages(totalData, limitProductsOfPage));
		
		paginates.setCurrentPage(checkCurrentPage(currentPage, paginates.getTotalPage()));

		int start = findStartNumdber(paginates.getCurrentPage(), limitProductsOfPage);
		paginates.setNumberStartPageOfProduct(start);
		
		int end = findEndNumdber(paginates.getNumberStartPageOfProduct(), limitProductsOfPage, totalData);
		paginates.setNumberEndPageOfProduct(end);

		return paginates;
		
		
	}

	private int findEndNumdber(int numberStartPageOfProduct, int limitProductsOfPage, int totalData) {
		return numberStartPageOfProduct + limitProductsOfPage > totalData ? totalData
				: (numberStartPageOfProduct + limitProductsOfPage) - 1;
	}

	private int findStartNumdber(int currentPage, int limitProductsOfPage) {
		return ((currentPage - 1) * limitProductsOfPage) + 1;
	}

	private int setInfoTotalPages(int totalData, int limitProductsOfPage) {
		int totalPage = 0;
		totalPage = totalData / limitProductsOfPage;
		totalPage = totalPage * limitProductsOfPage < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}

	private int checkCurrentPage(int currentPage, int totalPages) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPages) {
			return totalPages;
		}
		return currentPage;
	}
}
