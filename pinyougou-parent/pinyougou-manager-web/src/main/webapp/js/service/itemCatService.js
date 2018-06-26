//服务层
app.service('itemCatService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../itemCat/findAll.php');
	};
	//分页 
	this.findByPagination=function(page,rows){
		return $http.get('../itemCat/findByPagination.php?page='+page+'&rows='+rows);
	};
	//查询实体
	this.findById=function(id){
		return $http.get('../itemCat/findById.php?id='+id);
	};
	//增加 
	this.add=function(entity){
		return  $http.post('../itemCat/add.php',entity );
	};
	//修改 
	this.update=function(entity){
		return  $http.post('../itemCat/update.php',entity );
	};
	//删除
	this.dele=function(ids){
		return $http.get('../itemCat/delete.php?ids='+ids);
	};
	//搜索
	this.findWithConditionsByPagination=function(page,rows,searchEntity){
		return $http.post('../itemCat/findWithConditionsByPagination.php?page='+page+"&rows="+rows, searchEntity);
	};
    //根据上级ID查询下级列表
    this.findByParentId=function(parentId){
        return $http.get('../itemCat/findByParentId.php?parentId='+parentId);
    }


});
