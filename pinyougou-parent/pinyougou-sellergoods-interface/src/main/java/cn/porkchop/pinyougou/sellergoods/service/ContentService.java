package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbContent;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ContentService {

	/**
	 * 返回全部列表
	 * @return
	 */
    List<TbContent> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
    PageResult findByPagination(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
    void add(TbContent content);
	
	
	/**
	 * 修改
	 */
    void update(TbContent content);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
    TbContent findById(Long id);
	
	
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
    PageResult findWithConditionsByPagination(TbContent content, int pageNum, int pageSize);
	
}
