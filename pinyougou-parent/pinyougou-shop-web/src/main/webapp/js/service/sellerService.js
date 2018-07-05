//服务层
app.service('sellerService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../seller/findAll.php');
    };
    //分页
    this.findByPagination = function (page, rows) {
        return $http.get('../seller/findByPagination.php?page=' + page + '&rows=' + rows);
    };
    //查询实体
    this.findById = function (id) {
        return $http.get('../seller/findById.php?id=' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../seller/add.php', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../seller/update.php', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../seller/delete.php?ids=' + ids);
    };
    //搜索
    this.findWithConditionsByPagination = function (page, rows, searchEntity) {
        return $http.post('../seller/findWithConditionsByPagination.php?page=' + page + "&rows=" + rows, searchEntity);
    };
    //读取列表数据绑定到表单中
    this.getUserName = function () {
        return $http.get('../seller/getUserName.php');
    };
});
