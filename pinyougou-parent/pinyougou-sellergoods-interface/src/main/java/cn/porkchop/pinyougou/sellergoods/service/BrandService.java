package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * 品牌服务层接口
 *
 * @author porkchop
 * @date 2018/6/7 13:58
 */
public interface BrandService {
    /**
     * 查询所有
     *
     * @date 2018/6/7 14:09
     * @author porkchop
     */
    List<TbBrand> findAll();

    /**
     * 分页查询所有
     *
     * @date 2018/6/11 23:09
     * @author porkchop
     */
    PageResult<TbBrand> findByPagination(int pageNum, int pageSize);

    /**
     * 添加
     *
     * @date 2018/6/12 11:03
     * @author porkchop
     */
    void add(TbBrand brand);

    /**
     * 修改
     *
     * @date 2018/6/12 20:25
     * @author porkchop
     */
    void update(TbBrand brand);

    /**
     * 根据id查找
     *
     * @date 2018/6/12 20:26
     * @author porkchop
     */
    TbBrand findById(Long id);

    /**
     * 根据条件分页查找
     *
     * @date 2018/6/12 21:21
     * @author porkchop
     */
    PageResult<TbBrand> findWithConditionsByPagination(TbBrand tbBrand, int pageNum, int pageSize);

    /**
     * 批量删除
     *
     * @date 2018/6/12 21:50
     * @author porkchop
     */
    void delete(long[] ids);

    /**
     * 获取所有品牌
     *
     * @date 2018/6/17 22:43
     * @author porkchop
     */
    List<Map<String, String>> findAllForSelect2();
}
