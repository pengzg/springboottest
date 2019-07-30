tempApp.controller('ctr_userList', function($scope,EzConfirm,messageFactory,http,$state,$stateParams,$rootScope) {
    $scope.pager = {page:1,rows:'20',sort:'mb_ts',order:'desc',pageList:['10','20','30']};
    $scope.orderPager = {page:1,rows:'20',sort:'om_order_time',order:'desc',pageList:['10','20','30'],om_shopid:$rootScope.USER.shopId};
    $scope.searchParam = {};
    var format = 'yyyy-MM-dd';
	$scope.dateNow = dateRangeUtil.getCurrentMonth(format);
	$scope.startdate = $scope.dateNow[0];
	$scope.enddate = $scope.dateNow[1];
	$scope.searchParam.startDate = $scope.dateNow[0];
	$scope.searchParam.endDate = $scope.dateNow[1];
	$("#start_date").val($scope.startdate);
	$("#end_date").val($scope.enddate);
	$scope.searchParam_order = {};
	$scope.orderTypeList = [{"type_id":"","name":"全部"},{"type_id":"1","name":"水票订单"},{"type_id":"2","name":"送水订单"},{"type_id":"3","name":"取水订单"},{"type_id":"4","name":"充值订单"}]
    
   
	/**
	 * 查询列表
	 */
	var queryUserList = function(){
		messageFactory.showLoading();
		var success = function(result){
			$scope.userList = result.data.rows;
			$scope.pager.total = result.data.total;
			$scope.pager.pageTotal = Math.ceil($scope.pager.total/$scope.pager.rows);
			messageFactory.closeLoading();
		}
		var error = function(result){
			messageFactory.closeLoading();
			messageFactory.showMessage('error',result.desc);
			
		}
		
		var url = '/admin/member/memberBaseControl/dataGrid.action';
		http.post(url,$.extend({},$scope.pager,$scope.searchParam),success,error);
	}
    
	/**
	 * 查询
	 */
	$scope.searchFun = function(){
		$scope.searchParam.startDate = $("#start_date").val();
		$scope.searchParam.endDate = $("#end_date").val();
		if($scope.pager.page==1){
			queryUserList();
		}else{
			$scope.pager.page = 1;
		}
	}
    
	/**
	 * 监听
	 */
	$scope.$watch(function(){
		var newValue = $scope.pager.page+' '+$scope.pager.rows+' '+$scope.pager.sort+' '+$scope.pager.order+' ';
		return newValue;
	},queryUserList);
	
	/**
	 * 显示弹框
	 */
	$scope.showDialog = function(type){
		$scope.dialog = type;
	}
	/**
	 * 关闭弹框
	 */
	$scope.closeDialog = function(){
		$scope.dialog = 0;
	}
	/**
	 * 跳转到详情
	 */
	$scope.getDetail = function(id) {
		//$state.go("index.user.userdetail",{'id':id});
		$scope.dialogTitle = "用户详情";
		$scope.showDialog(1);
		$scope.toDetail(id);
	}
	
	$scope.viewOrder = function(x) {
		//$state.go("index.user.userdetail",{'id':id});
		$scope.om_memberid = x.mb_id;
		$scope.dialogTitle2 = "查看["+x.mb_nickname+"]的订单";
		$scope.searchParam_order.om_order_type = "";
		$scope.showDialog(2);
		$scope.orderPager.page = 1;
		$scope.queryOrderList();
	}
	
	
	/**
     * 获取用户详情
     */
	 $scope.toDetail = function(id){
		 messageFactory.showLoading();
			var success = function(result){
				$scope.vo = result.data;
				messageFactory.closeLoading();
			}
			var error = function(result){
				messageFactory.closeLoading();
				messageFactory.showMessage('error',result.desc);
				
			}
			var url = '/admin/member/memberBaseControl/getDetail.action';
			http.post(url,{'mb_id':id},success,error);
	 }
	
	/**
	 * 删除用户
	 */
	 $scope.deleteUser = function(id){
		var success = function(result){
			queryUserList();
		}
		var error = function(result){
			messageFactory.closeLoading();
			messageFactory.showMessage('error',result.desc);
			
		}
		var url = '/admin/member/memberBaseControl/delete.action';
		EzConfirm.create({
			heading : '提示',
			text : '确认删除吗？'
		}).then(function() {
			http.post(url,{"mb_id":id},success,error);
		}, function() {
			//console.log('取消？')
		});
	}
	 
	 
	   /**
		 * 修改用户状态
		 */
		$scope.changeStatus = function(id,text){
			var success = function(result){
				messageFactory.closeLoading();
				messageFactory.showMessage('success',result.desc);
				queryUserList();
			}
			var error = function(result){
				messageFactory.closeLoading();
				messageFactory.showMessage('error',result.desc);
			}
			
			var data ={'mb_id':id}
			var url = "/admin/member/memberBaseControl/changeStatus.action";
			var	msg = '您确定'+text+'该用户吗？';
			EzConfirm.create({
				heading : '提示',
				text : msg
			}).then(function() {			
				http.post(url, data, success, error);
			}, function() {

			});
		}
		
		
		$scope.queryOrderList = function(){
			var success = function(result){
				  $scope.orderList = result.data.rows;
				  $scope.orderPager.total = result.data.total;
				  $scope.orderPager.pageTotal = Math.ceil($scope.orderPager.total/$scope.orderPager.rows);
				  messageFactory.closeLoading();
			  }
			  var error = function(result){
				  messageFactory.closeLoading();
				  messageFactory.showMessage('error',result.desc);
			  }
			  $scope.searchParam_order.om_memberid = $scope.om_memberid;
			  var url = '/admin/order/orderMainControl/dataGrid.action';
			  http.post(url,$.extend({},$scope.orderPager,$scope.searchParam_order),success,error);
		}		
	 
		 /**
		 * 监听订单的分页
		 */
		$scope.$watch(function(){
			var newValue = $scope.orderPager.page+' '+$scope.orderPager.rows+' '+$scope.orderPager.sort+' '+$scope.orderPager.order+' ';
			return newValue;
		},$scope.queryOrderList);
		
		/**
		 * 查询订单详情
		 */
		$scope.goOrderDetail = function(x){
			var url = $state.href('index.order.orderDetail',{'om_id':x.om_id,'om_order_code':x.om_order_code});
	        window.open(url,'_blank');
			// $state.go('index.order.orderDetail',{'om_id':x.om_id,'om_order_code':x.om_order_code});
		}
		
		$scope.chooseType = function(x){
			$scope.searchParam_order.om_order_type = x.type_id;
			$scope.orderPager.page = 1;
			$scope.queryOrderList();
		}

		$scope.clearParams = function(){
			$("#start_date").val($scope.startdate);
			$("#end_date").val($scope.enddate);
			$scope.searchParam.searchKey = '';
		}
		/* 查询余额 */
		$scope.viewYe = function(x){
			var url = $state.href('index.gl.accountlist',{'mba_memberid':x.mb_id});
	        window.open(url,'_blank');
		}
	 
})