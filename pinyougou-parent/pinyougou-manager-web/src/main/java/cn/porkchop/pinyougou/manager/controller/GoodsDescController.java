package cn.porkchop.pinyougou.manager.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbGoodsDesc;
import cn.porkchop.pinyougou.sellergoods.service.GoodsDescService;
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
@RequestMapping("/goodsDesc")
public class GoodsDescController {

    @Autowired
    private GoodsDescService goodsDescService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoodsDesc> findAll() {
        return goodsDescService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findByPagination(int page, int rows) {
        return goodsDescService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param goodsDesc
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbGoodsDesc goodsDesc) {
        try {
            goodsDescService.add(goodsDesc);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param goodsDesc
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbGoodsDesc goodsDesc) {
        try {
            goodsDescService.update(goodsDesc);
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
    public TbGoodsDesc findById(Long id) {
        return goodsDescService.findById(id);
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
            goodsDescService.delete(ids);
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
    public PageResult findWithConditionsByPagination(@RequestBody TbGoodsDesc goodsDesc, int page, int rows) {
        return goodsDescService.findWithConditionsByPagination(goodsDesc, page, rows);
    }

}
