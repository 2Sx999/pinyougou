package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbProvinces;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ProvincesService {

	/**
	 * 返回全部列表
	 * @return
	 */
    List<TbProvinces> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
    PageResult findByPagination(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
    void add(TbProvinces provinces);
	
	
	/**
	 * 修改
	 */
    void update(TbProvinces provinces);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
    TbProvinces findById(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
    void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
    PageResult findWithConditionsByPagination(TbProvinces provinces, int pageNum, int pageSize);
	
}
