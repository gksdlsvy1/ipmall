package kr.co.ipmall.controller.viewController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ipmall.service.categoryService.CategoryService;
import kr.co.ipmall.vo.Category;

@Controller
public class ViewController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value="index.do")
    public ModelAndView index(HttpSession session) throws Exception{
    	ModelAndView mv = new ModelAndView("/view/index");
    	// category를 DB에서 불러온다음에 가장 상위 카테고리를 session에 담아서 view로 보내야됨
    	List<Category> categoryList = categoryService.getCategoryList();
    	List<Category> bigCategoryList = categoryService.getBigCategoryList(categoryList);
    	List<Category> smallCategoryList = categoryService.getSmallCategoryList(categoryList);
    	session.setAttribute("bigCategory", bigCategoryList);
    	session.setAttribute("smallCategory", smallCategoryList);
    	
    	return mv;
    }
	
	@RequestMapping(value="main.do")
    public ModelAndView main() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/main");
    	
    	return mv;
    }
	
	@RequestMapping(value="list.do")
    public ModelAndView list() throws Exception{
    	ModelAndView mv = new ModelAndView("/view/list");
    	
    	return mv;
    }
	
}
