package kr.co.ipmall.service.goodsService;

import java.util.List;

import javax.annotation.Resource;

import kr.co.ipmall.dao.GoodsOptionDAO;
import kr.co.ipmall.vo.GoodsOption;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("goodsOptionService")
public class GoodsOptionServiceImpl implements GoodsOptionService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="goodsOptionDAO")
	private GoodsOptionDAO goodsOptionDao;
	
	public void setGoodsOptionService(GoodsOptionDAO goodsOptionDao) {
		this.goodsOptionDao = goodsOptionDao;
	}
	
	@Transactional
	public List<GoodsOption> getGoodsOptionListByGoodsNo(int goods_no){
		List<GoodsOption> goodsOptionList = goodsOptionDao.selectList("goods.selectGoodsOptionListByGoodsNo", goods_no);
		return goodsOptionList;
	}
}
