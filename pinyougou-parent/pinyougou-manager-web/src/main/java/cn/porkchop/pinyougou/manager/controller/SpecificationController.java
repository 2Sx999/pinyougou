package cn.porkchop.pinyougou.manager.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbSpecification;
import cn.porkchop.pinyougou.pojo.pojogroup.Specification;
import cn.porkchop.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        return specificationService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findByPagination(int page, int rows) {
        return specificationService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param specification
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Specification specification) {
        try {
            specificationService.add(specification);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param specification
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Specification specification) {
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Specification findById(Long id) {
        return specificationService.findById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findWithConditionsByPagination")
    public PageResult findWithConditionsByPagination(@RequestBody TbSpecification specification, int page, int rows) {
        return specificationService.findWithConditionsByPagination(specification, page, rows);
    }

    /**
     * 获取所有品牌
     *
     * @date 2018/6/17 22:43
     * @author porkchop
     */
    @RequestMapping("/findAllForSelect2")
    public List<Map<String, String>> findAllForSelect2() {
        return specificationService.findAllForSelect2();
    }

}
