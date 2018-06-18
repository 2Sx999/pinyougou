app.controller("brandController", function ($scope, $controller, brandService) {

    $controller("baseController", {$scope: $scope});


    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        });
    };
    $scope.searchEntity = {};
    $scope.findWithConditionsByPagination = function (page, rows) {
        brandService.findWithConditionsByPagination(page, rows, $scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        });
    };
    //保存
    $scope.save = function () {
        var methodName = $scope.entity.id == null ? "add" : "update";
        brandService.save(methodName, $scope.entity).success(function (response) {
            if (response.success === true) {
                $scope.reloadList();
            } else {
                alert(response.message);
            }
        });
    };
    //回显要修改的数据
    $scope.findById = function (id) {
        brandService.findById(id).success(function (response) {
            $scope.entity = response;
        });
    };
    //批量删除
    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(function (response) {
            if (response.success === true) {
                $scope.reloadList();
                $scope.selectIds.splice(0, $scope.selectIds.length);
            } else {
                alert(response.message);
            }
        });
    }
});