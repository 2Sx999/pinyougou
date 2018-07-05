//服务层
app.service('citiesService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../cities/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../cities/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../cities/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../cities/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../cities/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../cities/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../cities/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
