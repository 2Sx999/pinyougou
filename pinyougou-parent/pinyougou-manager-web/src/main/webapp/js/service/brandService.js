app.service("brandService", function ($http) {
    this.findAll = function () {
        return $http.get("../brand/findAll.php");
    };
    this.findByPagination = function (page, rows) {
        return $http.get("../brand/findByPagination.php?page=" + page + "&rows=" + rows);
    };
    this.findWithConditionsByPagination = function (page, rows, searchEntity) {
        return $http.post("../brand/findWithConditionsByPagination.php?page=" + page + "&rows=" + rows, searchEntity);
    };
    this.save = function (methodName, entity) {
        return $http.post("../brand/" + methodName + ".php", entity);
    };
    this.findById = function (id) {
        return $http.get("../brand/findById.php?id=" + id);
    };
    this.delete = function (selectIds) {
        return $http.get("../brand/delete.php?ids=" + selectIds);
    };
    this.findAllForSelect2=function () {
        return $http.get('../brand/findAllForSelect2.php');
    }
});