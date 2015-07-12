package kr.co.ipmall.service.categoryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import kr.co.ipmall.dao.CategoryDAO;
import kr.co.ipmall.model.exception.CategoryNotFoundException;
import kr.co.ipmall.vo.Category;

import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Resource(name="categoryDAO")
	private CategoryDAO categoryDao;

	public void setCategoryDao(CategoryDAO categoryDao) {
		// TODO Auto-generated method stub
		this.categoryDao = categoryDao;
	}
	
	public List<Category> getCategoryList(){
		List<Category> categoryList = categoryDao.selectCategoryList();
		
		return categoryList;
	}
	
	public List<Category> getBigCategoryList(List<Category> category) throws Exception{
		Iterator iterator = category.iterator();
		List<Category> bigCategory = new ArrayList();
		
		while(iterator.hasNext()) {
			Category tempCategory = (Category)iterator.next();
			
			if(tempCategory.getUpper_category_no() == 0)
				bigCategory.add(tempCategory);
		}
		
		if(bigCategory.isEmpty())
		{
			throw new CategoryNotFoundException();
		}
		
		return bigCategory;
	}
	
	public List<Category> getSmallCategoryList(List<Category> category) throws Exception{
		Iterator iterator = category.iterator();
		List<Category> smallCategory = new ArrayList();
		
		while(iterator.hasNext()) {
			Category tempCategory = (Category)iterator.next();
			
			if(tempCategory.getUpper_category_no() != 0)
				smallCategory.add(tempCategory);
		}
		
		if(smallCategory.isEmpty())
		{
			throw new CategoryNotFoundException();
		}
		
		return smallCategory;
	}
	
}
