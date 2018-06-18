//控制层
app.controller('typeTemplateController', function ($scope, $controller, typeTemplateService, brandService, specificationService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中  
    $scope.findAll = function () {
        typeTemplateService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    //分页
    $scope.findByPagination = function (page, rows) {
        typeTemplateService.findByPagination(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };

    //查询实体
    $scope.findById = function (id) {
        typeTemplateService.findById(id).success(
            function (response) {
                response.specIds = JSON.parse(response.specIds);
                response.brandIds = JSON.parse(response.brandIds);
                response.customAttributeItems = JSON.parse(response.customAttributeItems);
                $scope.entity = response;
            }
        );
    };

    //保存
    $scope.save = function () {
        $scope.entity.specIds = JSON.stringify($scope.entity.specIds);
        $scope.entity.brandIds = JSON.stringify($scope.entity.brandIds);
        $scope.entity.customAttributeItems = JSON.stringify($scope.entity.customAttributeItems);
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {//如果有ID
            serviceObject = typeTemplateService.update($scope.entity); //修改
        } else {
            serviceObject = typeTemplateService.add($scope.entity);//增加
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
        typeTemplateService.dele($scope.selectIds).success(
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
        typeTemplateService.findWithConditionsByPagination(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    //加载所有品牌
    $scope.findAllBrandsForSelect2 = function () {
        brandService.findAllForSelect2().success(function (response) {
            $scope.brandList = {'data': response};
        });
    };
    //加载所有规格
    $scope.findAllSpecificationForSelect2 = function () {
        specificationService.findAllForSelect2().success(function (response) {
            $scope.specificationList = {'data': response};
        })
    };
    // $scope.brandList = {
    //     data: [{
    //         id: 1,
    //         text: '联想'
    //     }, {
    //         id: 2,
    //         text: '华为'
    //     }, {
    //         id: 3,
    //         text: '小米'
    //     }]
    // };//品牌列表模拟数据

    $scope.extractTextFromJsonString = function (jsonString) {
        var json = JSON.parse(jsonString);
        var value="";
        for(var i=0;i<json.length;i++){
            value+=json[i]['text']+",";
        }
        return value.substr(0,value.length-1);
    }

});
