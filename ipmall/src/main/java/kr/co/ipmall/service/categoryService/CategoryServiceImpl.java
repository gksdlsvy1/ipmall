package kr.co.ipmall.service.categoryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import kr.co.ipmall.dao.CategoryDAO;
import kr.co.ipmall.model.exception.CategoryNotFoundException;
import kr.co.ipmall.vo.Category;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="categoryDAO")
	private CategoryDAO categoryDao;

	public void setCategoryDao(CategoryDAO categoryDao) {
		// TODO Auto-generated method stub
		this.categoryDao = categoryDao;
	}
	
	@Transactional
	public List<Category> getCategoryList(){
		List<Category> categoryList = categoryDao.selectCategoryList();
		
		return categoryList;
	}
	
	// 대항목 가져오기
	// List로 가져와 상위 카테고리 번호가 0인 것들만 return
	@Transactional
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
	
	// 소항목 가져오기
	// List로 가져와 상위 카테고리가 0이 아닌 것들만 return
	@Transactional
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
