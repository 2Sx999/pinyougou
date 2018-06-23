//控制层
app.controller('userController', function ($scope, $controller, userService) {
    //获取登陆的用户名
    $scope.getUserName = function () {
        userService.getUserName().success(
            function (response) {
                $scope.userName= response.userName;
            }
        );
    };
});
