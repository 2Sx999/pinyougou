//服务层
app.service('contentService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../content/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../content/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../content/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../content/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../content/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../content/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../content/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
