package cn.porkchop.pinyougou.pojo.pojogroup;

import cn.porkchop.pinyougou.pojo.TbGoods;
import cn.porkchop.pinyougou.pojo.TbGoodsDesc;
import cn.porkchop.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class Goods extends TbGoods implements Serializable {
    //商品扩展
    private TbGoodsDesc goodsDesc;
    //商品扩展
    private List<TbItem> itemList;

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }
}
