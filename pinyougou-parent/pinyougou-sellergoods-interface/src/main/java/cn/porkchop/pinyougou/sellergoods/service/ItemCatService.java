package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbItemCat;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface ItemCatService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbItemCat> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findByPagination(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(TbItemCat itemCat);


    /**
     * 修改
     */
    void update(TbItemCat itemCat);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    TbItemCat findById(Long id);


    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 分页
     *
     * @param pageNum
     *         当前页 码
     * @param pageSize
     *         每页记录数
     * @return
     */
    PageResult findWithConditionsByPagination(TbItemCat itemCat, int pageNum, int pageSize);

    /**
     * 根据上级id返回列表
     *
     * @date 2018/6/25 14:36
     * @author porkchop
     */
    List<TbItemCat> findByParentId(Long parentId);
}
