package SnacksShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SnacksShop.DTO.PaginatesDTO;
import SnacksShop.Service.User.CategorysServiceImple;
import SnacksShop.Service.User.PaginatesServiceImple;

@Controller
public class TypeProductsController extends BaseController {

	@Autowired
	private CategorysServiceImple categorysService;
	
	@Autowired
	private PaginatesServiceImple paginatesService;
	
	private int TotalProductsOfPage = 12;

	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Products(@PathVariable String id) {
		
		
		_mvShare.setViewName("user/products/typeProducts");
		
		int totalData = categorysService.GetAllProductsByID(Integer.parseInt(id)).size();
		
		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categorysService.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Products(@PathVariable String id, @PathVariable String currentPage) {
		
		
		_mvShare.setViewName("user/products/typeProducts");
		
		int totalData = categorysService.GetAllProductsByID(Integer.parseInt(id)).size();
		
		PaginatesDTO paginateInfo = paginatesService.GetInfoPaginates(totalData, TotalProductsOfPage, Integer.parseInt(currentPage) );
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categorysService.GetDataProductsPaginate(Integer.parseInt(id), paginateInfo.getNumberStartPageOfProduct(), TotalProductsOfPage));
		return _mvShare;
	}
}
