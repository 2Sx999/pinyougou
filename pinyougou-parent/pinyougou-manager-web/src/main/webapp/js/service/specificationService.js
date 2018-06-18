//服务层
app.service('specificationService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../specification/findAll.php');
    };
    //分页
    this.findByPagination = function (page, rows) {
        return $http.get('../specification/findByPagination.php?page=' + page + '&rows=' + rows);
    };
    //查询实体
    this.findById = function (id) {
        return $http.get('../specification/findById.php?id=' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../specification/add.php', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../specification/update.php', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../specification/delete.php?ids=' + ids);
    };
    //搜索
    this.findWithConditionsByPagination = function (page, rows, searchEntity) {
        return $http.post('../specification/findWithConditionsByPagination.php?page=' + page + "&rows=" + rows, searchEntity);
    };
    this.findAllForSelect2=function () {
        return $http.get('../specification/findAllForSelect2.php');
    }
});
