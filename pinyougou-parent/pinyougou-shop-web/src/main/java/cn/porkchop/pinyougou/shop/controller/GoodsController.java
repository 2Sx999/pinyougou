package cn.porkchop.pinyougou.shop.controller;

import cn.porkchop.pinyougou.pojo.PageResult;
import cn.porkchop.pinyougou.pojo.Result;
import cn.porkchop.pinyougou.pojo.TbGoods;
import cn.porkchop.pinyougou.pojo.pojogroup.Goods;
import cn.porkchop.pinyougou.sellergoods.service.GoodsService;
import cn.porkchop.pinyougou.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址

    @Autowired
    private GoodsService goodsService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoods> findAll() {
        return goodsService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findByPagination")
    public PageResult findByPagination(int page, int rows) {
        return goodsService.findByPagination(page, rows);
    }

    /**
     * 增加
     *
     * @param goods
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods) {
        //获取登录名
        String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        goods.setSellerId(sellerId);//设置商家ID
        try {
            goodsService.add(goods);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }

    }

    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbGoods goods) {
        try {
            goodsService.update(goods);
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
    public TbGoods findById(Long id) {
        return goodsService.findById(id);
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
            goodsService.delete(ids);
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
    public PageResult findWithConditionsByPagination(@RequestBody TbGoods goods, int page, int rows) {
        return goodsService.findWithConditionsByPagination(goods, page, rows);
    }

    /**
     * 上传图片
     *
     * @date 2018/6/25 23:04
     * @author porkchop
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

}
