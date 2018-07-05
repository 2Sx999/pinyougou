//服务层
app.service('contentCategoryService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../contentCategory/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../contentCategory/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../contentCategory/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../contentCategory/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../contentCategory/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../contentCategory/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../contentCategory/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
