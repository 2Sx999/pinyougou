//服务层
app.service('specificationOptionService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../specificationOption/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../specificationOption/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../specificationOption/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../specificationOption/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../specificationOption/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../specificationOption/delete.php?ids='+ids);
	};
	//搜索
	this.findWithConditionsByPagination=function(page,rows,searchEntity){
		return $http.post('../specificationOption/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
