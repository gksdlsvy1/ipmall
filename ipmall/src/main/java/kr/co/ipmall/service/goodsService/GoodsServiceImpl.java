package kr.co.ipmall.service.goodsService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ipmall.dao.GoodsDAO;
import kr.co.ipmall.vo.Goods;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="goodsDAO")
	private GoodsDAO goodsDao;
	
	public void setGoodsService(GoodsDAO goodsDao){
		this.goodsDao = goodsDao;
	}
	
	@Transactional
	public List<Goods> getGoodsList(String searchIndex){
		return (List<Goods>)goodsDao.selectGoodsList(searchIndex);
	}
	
	@Transactional
	public Goods getGoodsByGoodsNo(int goods_no){
		return (Goods) goodsDao.selectOne("goods.selectByGoodsNo", goods_no);
	}
	
	public List<Goods> getGoodsByCategoryNo(int category_no) {
		return (List<Goods>)goodsDao.selectList("goods.selectByCategoryNo", category_no);
	}
}
