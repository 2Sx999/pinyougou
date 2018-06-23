//服务层
app.service('freightTemplateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../freightTemplate/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../freightTemplate/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findOne=function(id){
		return $http.get('../freightTemplate/findOne.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../freightTemplate/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../freightTemplate/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../freightTemplate/delete.php?ids='+ids);
	};
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../freightTemplate/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	}    	
});
