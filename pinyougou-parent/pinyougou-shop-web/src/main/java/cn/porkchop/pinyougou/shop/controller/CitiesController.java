package cn.porkchop.pinyougou.shop.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbCities;
import cn.porkchop.pinyougou.sellergoods.service.CitiesService;
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
@RequestMapping("/cities")
public class CitiesController {


    @Autowired
    private CitiesService citiesService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbCities> findAll() {
        return citiesService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findPage(int page, int rows) {
        return citiesService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param cities
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbCities cities) {
        try {
            citiesService.add(cities);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param cities
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbCities cities) {
        try {
            citiesService.update(cities);
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
    public TbCities findById(Integer id) {
        return citiesService.findById(id);
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
            citiesService.delete(ids);
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
    public PageResult search(@RequestBody TbCities cities, int page, int rows) {
        return citiesService.findWithConditionsByPagination(cities, page, rows);
    }

}
