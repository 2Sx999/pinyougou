//服务层
app.service('orderService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../order/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../order/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findOne=function(id){
		return $http.get('../order/findOne.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../order/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../order/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../order/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../order/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
