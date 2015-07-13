package kr.co.ipmall.controller.categoryController;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import kr.co.ipmall.service.categoryService.CategoryService;

@Controller
public class CategoryController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
