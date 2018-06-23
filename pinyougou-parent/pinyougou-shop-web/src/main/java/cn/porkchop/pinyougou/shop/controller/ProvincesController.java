package cn.porkchop.pinyougou.shop.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbProvinces;
import cn.porkchop.pinyougou.sellergoods.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/provinces")
public class ProvincesController {


    @Autowired
    private ProvincesService provincesService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbProvinces> findAll() {
        return provincesService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findPage(int page, int rows) {
        return provincesService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param provinces
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbProvinces provinces) {
        try {
            provincesService.add(provinces);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param provinces
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbProvinces provinces) {
        try {
            provincesService.update(provinces);
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
    @RequestMapping("/findOne")
    public TbProvinces findById(Integer id) {
        return provincesService.findById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Integer[] ids) {
        try {
            provincesService.delete(ids);
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
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbProvinces provinces, int page, int rows) {
        return provincesService.findWithConditionsByPagination(provinces, page, rows);
    }

}
