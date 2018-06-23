//服务层
app.service('userService', function ($http) {
    //读取列表数据绑定到表单中
    this.getUserName = function () {
        return $http.get('../user/getUserName.php');
    };
});
