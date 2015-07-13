package kr.co.ipmall.dao;

import java.util.List;

import kr.co.ipmall.vo.Goods;

import org.springframework.stereotype.Repository;

@Repository("goodsDAO")
public class GoodsDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Goods> selectGoodsList(String searchIndex) {
		return (List<Goods>) selectList("goods.selectIndexGoods",searchIndex);
		
	}

}
