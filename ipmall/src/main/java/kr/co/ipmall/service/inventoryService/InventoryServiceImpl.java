package kr.co.ipmall.service.inventoryService;

import javax.annotation.Resource;

import kr.co.ipmall.dao.InventoryDAO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="inventoryDAO")
	private InventoryDAO inventoryDAO;
	
	public void createInventory(Long customer_no) {
		inventoryDAO.insert("inventory.insertEmptyInventory", customer_no);
	}

}
