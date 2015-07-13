package kr.co.ipmall.service.categoryService;

import java.util.List;

import kr.co.ipmall.dao.CategoryDAO;
import kr.co.ipmall.vo.Category;

public interface CategoryService {
	public void setCategoryDao(CategoryDAO categoryDao);
	public List<Category> getCategoryList();
	public List<Category> getBigCategoryList(List<Category> category) throws Exception;
	public List<Category> getSmallCategoryList(List<Category> category) throws Exception;
}
