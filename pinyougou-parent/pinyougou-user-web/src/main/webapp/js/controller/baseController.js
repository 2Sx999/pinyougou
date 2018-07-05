app.controller("baseController",function ($scope) {
    //重新加载列表
    $scope.reloadList = function () {
        $scope.findWithConditionsByPagination($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 20,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {//页面加载时也会触发
            $scope.reloadList();//重新加载
        }
    };
    //勾选复选框
    $scope.selectIds = [];
    $scope.updateSelectionIds = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }



});