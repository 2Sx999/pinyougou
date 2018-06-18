package cn.porkchop.pinyougou.sellergoods.service.impl;

import cn.porkchop.pinyougou.mapper.TbSpecificationMapper;
import cn.porkchop.pinyougou.mapper.TbSpecificationOptionMapper;
import cn.porkchop.pinyougou.mapper.group.SpecificationMapper;
import cn.porkchop.pinyougou.pojo.*;
import cn.porkchop.pinyougou.pojo.pojogroup.Specification;
import cn.porkchop.pinyougou.sellergoods.service.SpecificationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@org.springframework.stereotype.Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;
    @Autowired
    private SpecificationMapper specificationMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findByPagination(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Specification specification) {
        tbSpecificationMapper.insert(specification);
        for (TbSpecificationOption option : specification.getSpecificationOptionList()) {
            option.setSpecId(specification.getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }


    /**
     * 修改
     */
    @Override
    public void update(Specification specification) {
        tbSpecificationMapper.updateByPrimaryKey(specification);
        //删除与规格关联的所有规格选项,然后重新插入
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(specification.getId());
        tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);
        for (TbSpecificationOption option : specification.getSpecificationOptionList()) {
            option.setSpecId(specification.getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Specification findById(Long id) {
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        Specification specification = new Specification();
        specification.setId(tbSpecification.getId());
        specification.setSpecName(tbSpecification.getSpecName());
        //获取与规格关联的规格选项
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(tbSpecification.getId());
        specification.setSpecificationOptionList(tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample));
        return specification;
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbSpecificationMapper.deleteByPrimaryKey(id);
            //删除与规格关联的规格选项
            TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);
        }
    }


    @Override
    public PageResult findWithConditionsByPagination(TbSpecification specification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();

        if (specification != null) {
            if (specification.getSpecName() != null && specification.getSpecName().length() > 0) {
                criteria.andSpecNameLike("%" + specification.getSpecName() + "%");
            }

        }

        Page<TbSpecification> page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public List<Map<String, String>> findAllForSelect2() {
        return specificationMapper.findAllForSelect2();
    }

}
