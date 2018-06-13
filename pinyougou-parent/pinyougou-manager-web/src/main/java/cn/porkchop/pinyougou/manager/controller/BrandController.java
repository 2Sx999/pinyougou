package cn.porkchop.pinyougou.manager.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbBrand;
import cn.porkchop.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 查询所有
     *
     * @date 2018/6/7 14:18
     * @author porkchop
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页查询所有
     *
     * @date 2018/6/11 23:12
     * @author porkchop
     */
    @RequestMapping("/findByPagination")
    public PageResult<TbBrand> findByPagination(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int rows) {
        return brandService.findByPagination(page, rows);
    }

    /**
     * 添加
     *
     * @date 2018/6/12 21:25
     * @author porkchop
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            return new Result(false, "添加失败");
        }
    }

    /**
     * 修改
     *
     * @date 2018/6/12 21:25
     * @author porkchop
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            return new Result(false, "修改失败");
        }
    }

    /**
     * 根据主键查询
     *
     * @date 2018/6/12 21:25
     * @author porkchop
     */
    @RequestMapping("/findById")
    public TbBrand findById(long id) {
        return brandService.findById(id);
    }

    /**
     * 根据条件分页查询
     *
     * @date 2018/6/12 22:00
     * @author porkchop
     */
    @RequestMapping("/findWithConditionsByPagination")
    public PageResult<TbBrand> findWithConditionsByPagination(@RequestBody TbBrand tbBrand, int rows, int page) {
        return brandService.findWithConditionsByPagination(tbBrand, page, rows);
    }

    /**
     * 删除
     *
     * @date 2018/6/12 22:03
     * @author porkchop
     */
    @RequestMapping("/delete")
    public Result delete(long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败");
        }
    }
}
