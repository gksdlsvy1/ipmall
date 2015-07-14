package kr.co.ipmall.controller.inventoryController;

import javax.annotation.Resource;

import kr.co.ipmall.service.goodsService.GoodsService;
import kr.co.ipmall.service.inventoryService.InventoryService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InventoryController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "inventoryService")
	private InventoryService inventoryService;
	
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@RequestMapping(value ="inventory.do")
	public ModelAndView inventory() {
		ModelAndView mv = new ModelAndView("/view/inventory");
		return mv;
	}

}
