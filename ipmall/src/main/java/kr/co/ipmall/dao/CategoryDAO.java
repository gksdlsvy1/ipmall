package kr.co.ipmall.dao;

import kr.co.ipmall.vo.Category;

import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAO extends AbstractDAO {

	public void insertCategory(Category category) {
		// TODO Auto-generated method stub

		// category 기본 정보 insert
		insert("category.insertCategory", category);
	}

	@SuppressWarnings("unchecked")
	public Category selectCategory(Category category) {
		return (Category) selectOne("category.selectCategory", category);
	}
}
