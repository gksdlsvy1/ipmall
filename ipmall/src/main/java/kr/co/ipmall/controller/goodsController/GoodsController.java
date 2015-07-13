package kr.co.ipmall.controller.goodsController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.co.ipmall.service.goodsService.GoodsOptionService;
import kr.co.ipmall.service.goodsService.GoodsService;
import kr.co.ipmall.vo.Goods;
import kr.co.ipmall.vo.GoodsOption;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "goodsService")
	private GoodsService goodsService;

	@Resource(name = "goodsOptionService")
	private GoodsOptionService goodsOptionService;

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	// 상품 리스트 페이지
	@Transactional
	@RequestMapping(value = "search.do", method = RequestMethod.POST)
	public ModelAndView list(String searchIndex) {
		ModelAndView mv = new ModelAndView("/view/list");
		int goodsRowNum;
		if (searchIndex == null) {
			// 검색어를 입력하라는 메시지 출력
			mv = new ModelAndView("/view/noExistGoods");
		}

		try {
			log.debug("검색어 : " + searchIndex);
			List<Goods> goodsList = goodsService.getGoodsList(searchIndex);
			if (goodsList.size() % 3 == 0) {
				goodsRowNum = goodsList.size() / 3;
			} else {
				goodsRowNum = (goodsList.size() / 3) + 1;
			}
			log.debug("상품 번호 : " + goodsList.get(0).getGoods_no());

			mv.addObject("goodsList", goodsList);
			mv.addObject("goodsRowNum", goodsRowNum);
		} catch (Exception e) {
			log.error(e);
		}

		return mv;
	}

	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam(value = "val") int goods_no) {
		ModelAndView mv = new ModelAndView("/view/details");
		log.debug("detail의 상품 번호 :" + goods_no);

		// int tempNum=0;

		try {
			log.debug("상품 : " + goods_no);

			Goods goods = (Goods) goodsService.getGoodsByGoodsNo(goods_no);
			List<GoodsOption> goodsOption = (List<GoodsOption>) goodsOptionService
					.getGoodsOptionListByGoodsNo(goods_no);
			int totalPrice = 0;

			for (int i = 0; i < goodsOption.size(); i++) {
				totalPrice += goodsOption.get(i).getPrice();
			}
			/*
			 * tempNum = goods.getPrice(); String.format("{0:n0}",tempNum);
			 */

			mv.addObject("goods", goods);
			mv.addObject("options", goodsOption);
			mv.addObject("totalPrice", totalPrice);

			if (goods_no == 0) {
				// 상품이 상세 페이지 없다는 오류
				mv = new ModelAndView("/view/noExistGoods");
			}
		} catch (Exception e) {
			log.error(e);
		}

		return mv;
	}

}
