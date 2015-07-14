package kr.co.ipmall.service.goodsService;

import java.util.List;

import kr.co.ipmall.dao.GoodsDAO;
import kr.co.ipmall.vo.Goods;

public interface GoodsService{
	public void setGoodsService(GoodsDAO goodsDao);
	public List<Goods> getGoodsList(String searchIndex);
	public Goods getGoodsByGoodsNo(int goods_no);
	public List<Goods> getGoodsByCategoryNo(int category_no);
}
