//服务层
app.service('areasService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../areas/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../areas/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../areas/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../areas/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../areas/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../areas/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../areas/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
