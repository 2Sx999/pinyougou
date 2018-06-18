package cn.porkchop.pinyougou.sellergoods.service.impl;

import cn.porkchop.pinyougou.mapper.TbSpecificationOptionMapper;
import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.TbSpecificationOption;
import cn.porkchop.pinyougou.pojo.TbSpecificationOptionExample;
import cn.porkchop.pinyougou.sellergoods.service.SpecificationOptionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@org.springframework.stereotype.Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbSpecificationOption> findAll() {
        return specificationOptionMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findByPagination(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecificationOption> page = (Page<TbSpecificationOption>) specificationOptionMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbSpecificationOption specificationOption) {
        specificationOptionMapper.insert(specificationOption);
    }


    /**
     * 修改
     */
    @Override
    public void update(TbSpecificationOption specificationOption) {
        specificationOptionMapper.updateByPrimaryKey(specificationOption);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbSpecificationOption findById(Long id) {
        return specificationOptionMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            specificationOptionMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public PageResult findWithConditionsByPagination(TbSpecificationOption specificationOption, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();

        if (specificationOption != null) {
            if (specificationOption.getOptionName() != null && specificationOption.getOptionName().length() > 0) {
                criteria.andOptionNameLike("%" + specificationOption.getOptionName() + "%");
            }

        }

        Page<TbSpecificationOption> page = (Page<TbSpecificationOption>) specificationOptionMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
