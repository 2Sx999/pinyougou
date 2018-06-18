//服务层
app.service('itemService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../item/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../item/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../item/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../item/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../item/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../item/delete.php?ids='+ids);
	};
	//搜索
	this.findWithConditionsByPagination=function(page,rows,searchEntity){
		return $http.post('../item/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
