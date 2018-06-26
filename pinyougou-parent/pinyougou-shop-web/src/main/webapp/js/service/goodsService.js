//服务层
app.service('goodsService', function ($http) {

    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../goods/findAll.php');
    };
    //分页
    this.findByPagination = function (page, rows) {
        return $http.get('../goods/findByPagination.php?page=' + page + '&rows=' + rows);
    };
    //查询实体
    this.findById = function (id) {
        return $http.get('../goods/findById.php?id=' + id);
    };
    //增加
    this.add = function (entity) {
        return $http.post('../goods/add.php', entity);
    };
    //修改
    this.update = function (entity) {
        return $http.post('../goods/update.php', entity);
    };
    //删除
    this.dele = function (ids) {
        return $http.get('../goods/delete.php?ids=' + ids);
    };
    //搜索
    this.findWithConditionsByPagination = function (page, rows, searchEntity) {
        return $http.post('../goods/findWithConditionsByPagination.php?page=' + page + "&rows=" + rows, searchEntity);
    };
    this.uploadFile = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);
        return $http({
            method: 'POST',
            url: "../goods/upload.php",
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        });
    }
});
