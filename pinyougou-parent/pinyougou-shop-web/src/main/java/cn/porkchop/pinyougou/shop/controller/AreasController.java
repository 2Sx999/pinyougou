package cn.porkchop.pinyougou.shop.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbAreas;
import cn.porkchop.pinyougou.sellergoods.service.AreasService;
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
@RequestMapping("/areas")
public class AreasController {

    @Autowired
    private AreasService areasService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbAreas> findAll() {
        return areasService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findPage(int page, int rows) {
        return areasService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param areas
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbAreas areas) {
        try {
            areasService.add(areas);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param areas
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbAreas areas) {
        try {
            areasService.update(areas);
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
    public TbAreas findById(Integer id) {
        return areasService.findById(id);
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
            areasService.delete(ids);
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
    public PageResult search(@RequestBody TbAreas areas, int page, int rows) {
        return areasService.findWithConditionsByPagination(areas, page, rows);
    }

}
