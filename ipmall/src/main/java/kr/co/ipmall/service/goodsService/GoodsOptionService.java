package kr.co.ipmall.service.goodsService;

import java.util.List;

import kr.co.ipmall.dao.GoodsOptionDAO;
import kr.co.ipmall.vo.GoodsOption;

public interface GoodsOptionService {
	public void setGoodsOptionService(GoodsOptionDAO goodsOptionDao);
	public List<GoodsOption> getGoodsOptionListByGoodsNo(int goods_no);
}
