package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbGoods;
import cn.porkchop.pinyougou.pojo.pojogroup.Goods;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 返回全部列表
	 * @return
	 */
    List<TbGoods> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
    PageResult findByPagination(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
    void add(Goods goods);
	
	
	/**
	 * 修改
	 */
    void update(TbGoods goods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
    TbGoods findById(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
    void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
    PageResult findWithConditionsByPagination(TbGoods goods, int pageNum, int pageSize);
	
}
