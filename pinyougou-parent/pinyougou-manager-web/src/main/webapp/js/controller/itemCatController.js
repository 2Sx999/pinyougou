//控制层
app.controller('itemCatController', function ($scope, $controller, itemCatService) {

    $controller('baseController', {$scope: $scope});//继承
    $scope.entity={};

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        itemCatService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    //分页
    $scope.findByPagination = function (page, rows) {
        itemCatService.findByPagination(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    //查询实体
    $scope.findById = function (id) {
        itemCatService.findById(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    //保存
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = itemCatService.update($scope.entity); //修改
        } else {
            serviceObject = itemCatService.add($scope.entity);//增加
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    };


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        itemCatService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                    $scope.selectIds = [];
                }
            }
        );
    };

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.findWithConditionsByPagination = function (page, rows) {
        itemCatService.findWithConditionsByPagination(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    //显示下级列表,并且设置面包学导航显示哪一级
    $scope.findByParentIdAndSetLevel = function (entity, level) {
        $scope.level = level;
        if (level == 0) {
            $scope.entity1 = null;
            $scope.entity2 = null;
        } else if (level == 1) {
            $scope.entity1 = entity;
            $scope.entity2 = null;
        } else if (level == 2) {
            $scope.entity2 = entity;
        }
        itemCatService.findByParentId(entity.id).success(function (response) {
            $scope.list = response;
        });
        //更新页面entity的父id
        $scope.entity.parentId = entity.id;
    }
});	
