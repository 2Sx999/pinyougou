package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbPayLog;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface PayLogService {

	/**
	 * 返回全部列表
	 * @return
	 */
    List<TbPayLog> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
    PageResult findByPagination(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
    void add(TbPayLog payLog);
	
	
	/**
	 * 修改
	 */
    void update(TbPayLog payLog);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
    TbPayLog findById(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
    void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
    PageResult findWithConditionsByPagination(TbPayLog payLog, int pageNum, int pageSize);
	
}
