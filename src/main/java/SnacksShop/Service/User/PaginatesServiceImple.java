package SnacksShop.Service.User;

import org.springframework.stereotype.Service;

import SnacksShop.DTO.PaginatesDTO;

@Service
public class PaginatesServiceImple {
	public PaginatesDTO GetInfoPaginates(int totalData, int limitProductsOfPage, int currentPage ) {
		PaginatesDTO paginates = new PaginatesDTO();

		paginates.setLimitProductsOfPage(limitProductsOfPage);
		paginates.setTotalPage(setTotalPages(totalData, limitProductsOfPage));
		paginates.setCurrentPage(checkCurrentPage(currentPage, paginates.getTotalPage()));

		paginates.setNumberStartPageOfProduct(findStartNumdber(paginates.getCurrentPage(), limitProductsOfPage));
		paginates.setNumberEndPageOfProduct(
				findEndNumdber(paginates.getNumberStartPageOfProduct(), limitProductsOfPage, totalData));

		return paginates;
		
		
	}

	private int findEndNumdber(int numberStartPageOfProduct, int limitProductsOfPage, int totalData) {
		return numberStartPageOfProduct + limitProductsOfPage > totalData ? totalData
				: (numberStartPageOfProduct + limitProductsOfPage) - 1;
	}

	private int findStartNumdber(int currentPage, int limitProductsOfPage) {
		return ((currentPage - 1) * limitProductsOfPage) + 1;
	}

	private int setTotalPages(int totalData, int limitProductsOfPage) {
		int total = 0;
		total = totalData / limitProductsOfPage;
		total = total * limitProductsOfPage < totalData ? total + 1 : total;
		return total;
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
