//服务层
app.service('provincesService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../provinces/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../provinces/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../provinces/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../provinces/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../provinces/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../provinces/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../provinces/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
