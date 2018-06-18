package cn.porkchop.pinyougou.sellergoods.service;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbSpecification;
import cn.porkchop.pinyougou.pojo.pojogroup.Specification;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface SpecificationService {

    /**
     * 返回全部列表
     *
     * @return
     */
    List<TbSpecification> findAll();


    /**
     * 返回分页列表
     *
     * @return
     */
    PageResult findByPagination(int pageNum, int pageSize);


    /**
     * 增加
     */
    void add(Specification specification);


    /**
     * 修改
     */
    void update(Specification specification);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    Specification findById(Long id);


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
    PageResult findWithConditionsByPagination(TbSpecification specification, int pageNum, int pageSize);

    /**
     * 查询所有
     *
     * @date 2018/6/17 23:31
     * @author porkchop
     */
    List<Map<String, String>> findAllForSelect2();

}
