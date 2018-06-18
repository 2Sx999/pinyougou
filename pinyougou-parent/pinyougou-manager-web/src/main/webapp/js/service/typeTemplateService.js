//服务层
app.service('typeTemplateService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../typeTemplate/findAll.php');
    };
    //分页
    this.findByPagination = function (page, rows) {
        return $http.get('../typeTemplate/findByPagination.php?page=' + page + '&rows=' + rows);
    };
    //查询实体
    this.findById = function (id) {
        return $http.get('../typeTemplate/findById.php?id=' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../typeTemplate/add.php', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../typeTemplate/update.php', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../typeTemplate/delete.php?ids=' + ids);
    };
    //搜索
    this.findWithConditionsByPagination = function (page, rows, searchEntity) {
        return $http.post('../typeTemplate/findWithConditionsByPagination.php?page=' + page + "&rows=" + rows, searchEntity);
    }

});
