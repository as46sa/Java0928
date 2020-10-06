package com.shop.test;

import com.shop.bean.Goods;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodsDaoTest {private GoodsDao goodsDao = new GoodsDaoImpl();

    @Test
    public void addGoods() {
        System.out.println(goodsDao.addGoods(new Goods(null, "小米手机", "小米", new
                BigDecimal(9999), 1100000, 0, null
        )));

    }

    @Test
    public void deleteGoodsById() {
        System.out.println(goodsDao.deleteGoodsById(1));
    }

    @Test
    public void updateGoods() {
        System.out.println(goodsDao.updateGoods(new Goods(2, "魅族手机", "魅族", new
                BigDecimal(9999), 1100000, 0, null
        )));
    }

    @Test
    public void queryGoodsById() {
        System.out.println(goodsDao.queryGoodsById(2));
    }

    @Test
    public void queryGoods() {
        for (Goods queryGoods : goodsDao.queryGoods()) {
            System.out.println(queryGoods);
        }
    }
}
