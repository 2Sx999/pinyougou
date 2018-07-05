//服务层
app.service('userService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../user/findAll.php');
    };
    //分页
    this.findByPagination = function (page, rows) {
        return $http.get('../user/findByPagination.php?page=' + page + '&rows=' + rows);
    };
    //查询实体
    this.findById = function (id) {
        return $http.get('../user/findById.php?id=' + id);
    };
    //增加
    this.add = function (entity, smsCode) {
        return $http.post('../user/add.php?smsCode=' + smsCode, entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../user/update.php', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../user/delete.php?ids=' + ids);
    };
    //搜索
    this.search = function (page, rows, searchEntity) {
        return $http.post('../user/findWithConditionsByPagination.php?page=' + page + "&rows=" + rows, searchEntity);
    };
    //发送验证码
    this.sendCode = function (phone) {
        return $http.get("../user/sendCode.php?phone=" + phone);
    }
});
