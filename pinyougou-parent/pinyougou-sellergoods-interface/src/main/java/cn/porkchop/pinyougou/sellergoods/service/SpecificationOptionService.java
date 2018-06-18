package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbSpecificationOption;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SpecificationOptionService {

	/**
	 * 返回全部列表
	 * @return
	 */
    List<TbSpecificationOption> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
    PageResult findByPagination(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
    void add(TbSpecificationOption specificationOption);
	
	
	/**
	 * 修改
	 */
    void update(TbSpecificationOption specificationOption);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
    TbSpecificationOption findById(Long id);
	
	
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
    PageResult findWithConditionsByPagination(TbSpecificationOption specificationOption, int pageNum, int pageSize);
	
}
