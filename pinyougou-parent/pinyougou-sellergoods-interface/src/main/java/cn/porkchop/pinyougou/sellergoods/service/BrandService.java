package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌服务层接口
 * @date 2018/6/7 13:58
 * @author porkchop
 */
public interface BrandService {
    /**
     * 查询所有
     * @date 2018/6/7 14:09
     * @author porkchop
     */
    public List<TbBrand> findAll();
}
