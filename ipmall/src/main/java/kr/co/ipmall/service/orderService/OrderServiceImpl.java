package kr.co.ipmall.service.orderService;

import javax.annotation.Resource;

import kr.co.ipmall.dao.OrderDAO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="orderDAO")
	private OrderDAO orderDAO;
	

}
