//服务层
app.service('seckillOrderService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../seckillOrder/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../seckillOrder/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findOne=function(id){
		return $http.get('../seckillOrder/findOne.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../seckillOrder/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../seckillOrder/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../seckillOrder/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../seckillOrder/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
