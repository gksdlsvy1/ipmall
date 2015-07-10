package kr.co.ipmall.service;

import javax.annotation.Resource;

import kr.co.ipmall.dao.CategoryDAO;

import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Resource(name="categoryDAO")
	private CategoryDAO categoryDao;

	public void setCategoryDao(CategoryDAO categoryDao) {
		// TODO Auto-generated method stub
		this.categoryDao = categoryDao;
	}

}
