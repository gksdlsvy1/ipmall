package kr.co.ipmall.controller.orderController;

import javax.annotation.Resource;





import kr.co.ipmall.service.goodsService.GoodsService;
import kr.co.ipmall.service.orderService.OrderService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class orderController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	public void setGoodsService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value ="order.do")
	public ModelAndView inventory() {
		ModelAndView mv = new ModelAndView("/view/order");
		return mv;
	}

}
