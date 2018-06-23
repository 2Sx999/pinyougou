package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbSeller;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface SellerService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbSeller> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findByPagination(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(TbSeller seller);


    /**
     * 修改
     */
    void update(TbSeller seller);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    TbSeller findById(String id);


    /**
     * 批量删除
     *
     * @param ids
     */
    void delete(String[] ids);

    /**
     * 分页
     *
     * @param pageNum
     *         当前页 码
     * @param pageSize
     *         每页记录数
     * @return
     */
    PageResult findWithConditionsByPagination(TbSeller seller, int pageNum, int pageSize);

    /**
     * 更改审核状态
     *
     * @date 2018/6/23 13:20
     * @author porkchop
     */
    void updateStatus(String sellerId, String status);
}
