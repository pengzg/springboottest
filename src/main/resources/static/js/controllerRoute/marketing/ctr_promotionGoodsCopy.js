tempApp.controller('ctr_promotionGoodsCopy', function($scope, $rootScope, $location,
		$state,$timeout,http,$stateParams,EzConfirm,$compile,dateUtil,messageFactory,$q,$http,activityDetailFactory) {
	$scope.promotion = {};
	$scope.checkedAreas = "";
	$scope.dataList = [];
	$scope.gradeList2 = [];
	$scope.goodsList = [];
	$scope.today = dateUtil.getDate2()+" 至  "+dateUtil.getDate2();
	$scope.ladderVO = {"ppg_skuid":"","ppg_productid":'',"ppg_productid_nameref":'',"ppg_minnum":'',"ppg_minamount":'',"ppg_gift_num":'',"ppg_mj_amount":'',"ppg_discount":'',"ppg_productprice":'',"ppg_gift_totalnum":''};
	$scope.ladderList = [$scope.ladderVO];
	$scope.couponVO = {};
	$scope.couponRelationList = [$scope.couponVO];
    $scope.iscouponList = [{"bd_code":1,"bd_name":"是"},{"bd_code":2,"bd_name":"否"}];
    if ($stateParams.ppm_id != undefined) {
    	$scope.ppm_id = $stateParams.ppm_id;
    }
    
    /**
     * 详情
     */
    $scope.getDetail = function() {
    	messageFactory.showLoading();
		var success = function(result){
			$scope.vo = result.data;
			if ($scope.vo.detailList.length>0) {
				for (var x in $scope.vo.detailList) {
					var str = {"ps_price":$scope.vo.detailList[x].ppd_product_price,
							"pm_title":$scope.vo.detailList[x].ppd_productid_nameref,
							"ps_id":$scope.vo.detailList[x].ppd_skuid,
							"ps_productid":$scope.vo.detailList[x].ppd_productid,
							"pm_picture":$scope.vo.detailList[x].ppd_productid_picture,
							"ppd_product_gourp_price":$scope.vo.detailList[x].ppd_product_gourp_price
							
						}
					$scope.dataList.push(str);
				}
			} else {
				$scope.dataList = [{}];
			}
			$scope.ladderList = $scope.vo.giftList;
			if ($scope.ladderList.length==0) {
				$scope.ladderList=[{}];
			} 
			$scope.gradeList2 = $scope.vo.gradeList;
			$scope.getBaseGradeList();
			$scope.vo.ppm_state =2;
			if ($scope.vo.ppm_isladder==1) {
				$scope.isLabber = true;
			} else {
				$scope.isLabber = false;
			}
			if ($scope.vo.ppm_isgroup=='Y') {
				$scope.isgroup = true;
			} else {
				$scope.isgroup = false;
			}
			$scope.vo.ppm_startdate = $scope.vo.ppm_enddate = dateUtil.getDate2();
			$scope.queryDeliveryType();
			$scope.vo.ppm_paymethodArr = ($scope.vo.ppm_paymethod).split(",");
			$scope.vo.ppm_paywayArr = ($scope.vo.ppm_payway).split(",");
			$scope.vo.ppm_def3Arr = ($scope.vo.ppm_def3).split(",");
			$scope.couponRelationList =$scope.vo.couponRelList;
			messageFactory.closeLoading();
		};
		var error = function(result){
			messageFactory.closeLoading();
			messageFactory.showMessage('error',result.desc);
			
		};
		var data = {"ppm_id":$scope.ppm_id};
		var url = '/admin/promotion/productPromotionMainControl/getCopyData.action';
		http.post(url,data,success,error);
    }
    
    if ($scope.ppm_id) {
    	$scope.getDetail($scope.ppm_id);
    }
	
	$scope.vo = {'ppm_promotion_type':1,"ppm_promotion_rules":1,"ppm_range":1,"ppm_state":2};
	$scope.vo.ppm_startdate = $scope.vo.ppm_enddate = dateUtil.getDate2();
	$("#start_time").val($scope.today);
	$('#start_time').daterangepicker($rootScope.dateRangeConfig, function(start, end, label) { // 格式化日期显示框
		$scope.vo.ppm_startdate = start.format('YYYY-MM-DD');
		$scope.vo.ppm_enddate = end.format('YYYY-MM-DD');
		$scope.$apply();
    });
	$scope.goods_type = 1;
	
	$scope.queryDeliveryType = function(){
		var success = function(result){
			$scope.deliveryTypeList = result.data;
		}
		var error = function(result){
			
		}
		var url = "/admin/base/baseDataControl/detailItem.action";
		http.post(url,{codekey:"2153"},success,error);
	}
	$scope.queryDeliveryType();
	
	$scope.getDeliveryCheckedIds = function() {
		$scope.checkedIds = "";
		var ids = [];
		$("input[name='delivery_type']:checked").not(
				":disabled").each(function() {
			var selectId = $(this).val();
			ids.push(selectId);
		});
		$scope.vo.ppm_def3 = ids.join(',')
	}
	
	/**
	 *隐藏未选中节点
	 * @param treeObj
	 * @returns
	 */
	function hideUnChecked(treeObj){
		var nodes = treeObj.getNodesByFilter(function(node){
			return node.checked == false;
		});
		treeObj.hideNodes(nodes);
	}
	
	/**
	 * 点击分类事件
	 */
	function onCheck(e, treeId, treeNode) {
		 var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
         nodes=treeObj.getCheckedNodes(true);
         var v=[];
         for(var i=0;i<nodes.length;i++){
        	
         	 v.push(nodes[i].id);
         }
         $scope.checkedAreas = v.join(",");
	};

	/**
	 * 分类树形结构配置
	 */
	var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: onCheck
			}
		};
	$scope.getDetail = function(pa_id,type) {
		activityDetailFactory.getDetail($scope,pa_id,setting,type);
	}
	
	/**
	 * 查询树
	 */
	$scope.getBaseArea = function(){
		activityDetailFactory.getBaseArea($scope,setting);
	}
	
	
	
	
	$scope.getBaseArea();

	
	
    /**
     * 查询商品
     */
    $scope.pager1 = {page:1,rows:'10',sort:'',order:'',searchKey:'',ps_shopid:$rootScope.USER.shopId};
    $scope.searchParam = {};
    $scope.getGoods = function(){
  
    	activityDetailFactory.getGoods($scope);
    }
    /**
     * 查询优惠券
     */
    $scope.couponPager = {page:1,rows:'10',sort:'',order:'',searchKey:'',cb_shopid:$rootScope.USER.shopId};
    $scope.searchParam = {};
    $scope.getCouponList = function(){
  
    	activityDetailFactory.getCouponList($scope);
	}
	

    /**
     * 商品模糊查询
     */
    $scope.keySearchFun = function(key,type){
    	if(type=="goods"){
			$scope.pager1.page =1; 
			$scope.pager1.searchKey =key; 
			
    		$scope.getGoods();
    	} else {
			$scope.couponPager.page =1; 
			$scope.couponPager.searchKey =key; 
    		$scope.getCouponList();
		}
    }
	
    /**
	 * 上一页
	 */
	$scope.prevPage = function(pager,fun){
		activityDetailFactory.prevPage($scope,pager,fun);
	}
	
	/**
	 * 下一页
	 */
	$scope.nextPage = function(pager,fun){
		activityDetailFactory.nextPage($scope,pager,fun);
	}
    /**
     * 选择商品
     */
	$scope.chooseGoods = function(obj,obj2,type){
		if (type == 1) {
			
			var flag = true;
			if($scope.dataList){
				for(var i in $scope.dataList){
					if($scope.dataList[i].ps_id==obj.ps_id){
						flag = false;
						continue;
					}
				}
			}
			if(flag){
				$scope.dataList[obj2] = obj;
				$scope.dataList[obj2].ppd_product_gourp_price = 1;
				
			}else{
				messageFactory.showMessage('error','活动商品不能重复');
				return;
			}
			
			
		} else if (type == 2){
			$scope.dataList2[index] = obj;
		} else if (type == 4){

			var flag = true;
			if($scope.couponRelationList){
				for(var i in $scope.couponRelationList){
					if($scope.couponRelationList[i].cr_couponid==obj.cb_id){
						flag = false;
						continue;
					}
				}
			}
			if(flag){
				obj2.cr_couponid = obj.cb_id;
				obj2.cr_couponid_nameref = obj.cb_title;
			}else{
				messageFactory.showMessage('error','优惠券不能重复');
				return;
			}
			
		} else {
			obj2.ppg_productid_nameref = obj.pm_title;
			obj2.ppg_productid = obj.ps_productid;
			obj2.ppg_skuid = obj.ps_id;
			obj2.ppg_productprice = obj.ps_price;
		}
		
		
		
		// $scope.calculateFun();
		$(".droplistWrap2").hide();
	}
	/**
     * 添加全部商品
     */
    $scope.addAll = function(objList,index){

    	for(var i=0,len=objList.length;i<len;i++){
    		$scope.chooseGoods(objList[i],index+i);
    	}
    }
	
	/**
	 * 添加行
	 */
	$scope.addLine = function(type){
		if (type == 1) {
			$scope.dataList.push({});
		} else if (type ==3) {
			$scope.ladderList.push({});
		} else if (type == 4) {
			$scope.couponRelationList.push({});
		}
		
	}
	
	/**
	 * 移除行
	 */
	$scope.removeLine = function(index, type){
		if (type == 1){
			if($scope.dataList.length>1){
				$scope.dataList.splice(index,1);
				// changeFrameHeight('index.'+$state.current.name);
			}else{
				messageFactory.showMessage('error',"至少保留一条记录");
			}
		} else if (type == 3) {
			if($scope.ladderList.length>1){
				$scope.ladderList.splice(index,1);
			}else{
				messageFactory.showMessage('error',"至少保留一条记录");
			}
		}else if (type == 4) {
			if($scope.couponRelationList.length>1){
				$scope.couponRelationList.splice(index,1);
				// changeFrameHeight('index.'+$state.current.name);
			}else{
				messageFactory.showMessage('error',"至少保留一条记录");
			}
		}   else {
			if($scope.dataList2.length>1){
				$scope.dataList2.splice(index,1);
				// changeFrameHeight('index.'+$state.current.name);
			}else{
				messageFactory.showMessage('error',"至少保留一条记录");
			}
		}
	}
	
	
	$scope.lineNum = 0;
	$scope.subTotal = 0;

	$scope.showDroplist = function (event,fun,type){	
		activityDetailFactory.showDroplist($scope,event,fun,type);
    };
    
	/**
	 * 保存
	 */
	$scope.submit = function(){
		
		
		if (!$scope.vo.ppm_name) {
			messageFactory.showMessage('error','请输入活动主题');
			return;
		}
		
		if( $scope.vo.ppm_picture==undefined || $scope.vo.ppm_picture==""){
			messageFactory.showMessage('error','请上传活动图片');
			return;
		}
		
		if( $("#start_time").val()==""){
			messageFactory.showMessage('error','请选择活动时间');
			return;
		}
		if( $("#end_time").val()==""){
			messageFactory.showMessage('error','请选择活动时间');
			return;
		}
		if( $scope.vo.ppm_startdate <dateUtil.getDate2()){
			messageFactory.showMessage('error','活动开始日期不能小于当前日期');
			return;
		}
		if( $scope.vo.ppm_startdate >$scope.vo.ppm_enddate){
			messageFactory.showMessage('error','活动结束时间不能小于开始时间');
			return;
		}
		$scope.getDeliveryCheckedIds();
		if (!$scope.vo.ppm_def3) {
			messageFactory.showMessage('error','请选择配送方式！');
			return;
		}

		var  reg = /^\d{1,10}$/;
		
		// 团购 start
		if ($scope.isgroup) {
			$scope.vo.ppm_isgroup = "Y";
		} else {
			$scope.vo.ppm_isgroup = "N";
		}
		
		
		if ($scope.vo.ppm_isgroup == "Y") {
			if (!reg.test($scope.vo.ppm_valid_day)) {
				messageFactory.showMessage('error',"有效天数不能包含除数字以外的字符");
				return false;
			}
			if (!reg.test($scope.vo.ppm_limit_num)) {
				messageFactory.showMessage('error',"参入次数不能包含除数字以外的字符");
				return false;
			}
			if (!reg.test($scope.vo.ppm_group_peopler_num)) {
				messageFactory.showMessage('error',"开团人数不能包含除数字以外的字符");
				return false;
			}
			
			
		}
		
		// 团购 end
		
		
		if ($scope.isLabber) {
			$scope.vo.ppm_isladder = 1;
		} else {
			$scope.vo.ppm_isladder = 2;
		}

		
		
		// 参加活动的商品
		var goodsList = [];	
		for(i in $scope.dataList){
			if(!$scope.dataList[i].ps_id){
				continue;
			}
			
			if (!$scope.dataList[i].ps_price) {
				messageFactory.showMessage('error',"请输入商品价格");
				return false;
			}
			if ($scope.vo.ppm_isgroup == "Y") { 
				if (!$scope.dataList[i].ppd_product_gourp_price) {
					messageFactory.showMessage('error',"请输入团购价格");
					return false;
				}
			}
			var detailInfo = {}
			var item = $scope.dataList[i];
			detailInfo["ppd_productid"] = item.ps_productid;
			detailInfo["ppd_productid_nameref"] = item.pm_title;
			detailInfo["ppd_productid_picture"] = item.pm_picture;
			detailInfo["ppd_skuid"] = item.ps_id;
			detailInfo["ppd_product_price"] = item.ps_price;
			detailInfo["ppd_product_gourp_price"] = item.ppd_product_gourp_price;
			$scope.vo.ppm_group_price = item.ppd_product_gourp_price;
			goodsList.push(detailInfo);
		}
		
		if (goodsList.length <1) {
			messageFactory.showMessage('error','请选择参加活动的商品');
			return;
		}
		
		var goodsListStr = JSON.stringify(goodsList);
		
		//赠品 数据
		var giftList = [];		
		for(i in $scope.ladderList){
			if(!$scope.ladderList[i].ppg_skuid){
				messageFactory.showMessage('error',"请选择赠品 ");
				return false;
			}
			var ppgInfo = {}
			var item = $scope.ladderList[i];
			if (!reg.test(item.ppg_minnum)) {
				messageFactory.showMessage('error',"购买产品数量不能包含除数字以外的字符");
				return false;
			}
			
			if (!item.ppg_minnum || item.ppg_minnum<=0) {
				messageFactory.showMessage('error','请选择输入购买产品数量且不能小于等于0');
				return;
			}
			
			for (j in $scope.ladderList) {
				if(!$scope.ladderList[j].ppg_skuid){
					continue;
				}
				
				if ($scope.ladderList[j].ppg_minnum == $scope.ladderList[i].ppg_minnum && i != j) {
					messageFactory.showMessage('error','阶梯区间不能重复');
					return;
				}
				
			}
			
			if (!reg.test(item.ppg_gift_num)) {
				messageFactory.showMessage('error',"赠品数量不能包含除数字以外的字符");
				return false;
			}
			if (!item.ppg_gift_num || item.ppg_gift_num<=0) {
				messageFactory.showMessage('error','请选择输入赠品数量且不能小于等于0');
				return;
			}
			
			ppgInfo = item;
			
			giftList.push(ppgInfo);
		}
		
		if (giftList.length <1) {
			messageFactory.showMessage('error','请选择参加活动的赠品');
			return;
		}
		var giftListStr = JSON.stringify(giftList);
		
		if (!$scope.vo.ppm_def3) {
			messageFactory.showMessage('error','请选择配送方式！');
			return;
		}
		$scope.getPayMethodCheckedIds();
		if (!$scope.vo.ppm_paymethod) {
			messageFactory.showMessage('error','请选择支付方式！');
			return;
		}
		

		$scope.getPayWayCheckedIds();
		if (!$scope.vo.ppm_payway) {
			messageFactory.showMessage('error','请选择支付类型！');
			return;
		}
		// 参加活动的优惠券
		var couponRelationListStr = "";
		$scope.couponRelationList2 = [];
		if ($scope.vo.ppm_iscoupon ==1) {
			for(i in $scope.couponRelationList){
				if(!$scope.couponRelationList[i].cr_couponid){
					continue;
				}

				if (!reg.test($scope.couponRelationList[i].cr_num)) {
					messageFactory.showMessage('error',"优惠券数量不能包含除数字以外的字符");
					return false;
				}
				if (!$scope.couponRelationList[i].cr_num|| $scope.couponRelationList[i].cr_num<=0) {
					messageFactory.showMessage('error','请选择输入优惠券数量且不能小于等于0');
					return;
				}

				$scope.couponRelationList2.push($scope.couponRelationList[i]);
	
			}
			
			if ($scope.couponRelationList2.length <1) {
				messageFactory.showMessage('error','请选择参加活动的优惠券');
				return;
			}
			
			couponRelationListStr = JSON.stringify($scope.couponRelationList2);
		}
		





	
		var success = function(result){
			messageFactory.showMessage('success','提交成功');
			$scope.goBack();
			$scope.dataList = [{}];
			$scope.dataList2 = [{}];
			$scope.subTotal = 0;
		}
		var error = function(result){
			messageFactory.showMessage('error',result.desc);
		}
		
		$scope.vo.ppm_type = 1;
		$scope.vo.ppm_range = 1;
		$scope.vo.ppm_group_type = 3;
		$scope.vo.ppm_id = "";
		EzConfirm.create({
			heading : '提示',
			text : "您确定提交吗？"
		}).then(function() {
			var url = "/admin/promotion/productPromotionMainControl/update.action";
			http.post(url,$.extend({'ppdListStr':goodsListStr,"gfListStr":giftListStr,"promotionAreas":$scope.checkedAreas,"promotionGrades":$scope.getCheckedIds,"couponListStr":couponRelationListStr},$scope.vo),success,error);
		}, function() {

		});
	}
	
	

	
	// 返回
	$scope.goBack = function(){
		
		$state.go("index.marketing.promotionGoods");
		
	}
		
	/**
	 * 显示图片上传
	 */
	$scope.upImage = function($event){
		activityDetailFactory.upImage($scope,$event);
	};
	
	/**
	 * 加减数目
	 */
	$scope.changeNum = function(x,name,opt,type) {
		activityDetailFactory.changeNum($scope,x,name
				,opt,type);
	}
	
	/**
	 * 按金额与按数量
	 */
	$scope.promotionTypeChange = function(){
		if($scope.vo.ppm_promotion_type==1){
			$scope.vo.ppm_promotion_rules = 1;
		}else{
			$scope.vo.ppm_promotion_rules = 4;
		}
	}


	/**
	 * 查询树
	 */
	$scope.getBaseArea = function(){
		activityDetailFactory.getBaseArea($scope,setting);
	}
	
	/**
	 * 客户等级
	 */
	$scope.getBaseGradeList = function(){
			
    	var success = function(result){
			$scope.gradeList = result.data.rows;
			for (x in $scope.gradeList) {
				for (y in $scope.gradeList2) {
					
					if ($scope.gradeList[x].bg_id == $scope.gradeList2[y].ppmg_gradeid) {
						$scope.gradeList[x].checked = true;
					}
				}
			}
		};
		var error = function(result){
			messageFactory.closeLoading();
			messageFactory.showMessage('error',result.desc);
			
		};
		
		var url = '/admin/base/baseGradeControl/dataGrid.action';
		
		http.post(url,{"rows":20,"page":1,"bg_state":1},success,error);
	}
	
	
	
	
	$scope.getCheckedIds = function()
	{
	  $scope.checkedIds = "";
	  var ids = [];
	  $("input.js_grade:checked").not(":disabled").each(function(){		  
	    var selectId = $(this).attr("data-id");	
	   //  console.log(selectId);
	    ids.push(selectId);
	  });
	  return ids.join(',');
	}
	
	$scope.upImage = function($event) {
	    
	      $scope.ue_myeditor.addListener("beforeInsertImage", function(t, arg) {
	        var imgs = "";

	        if (arg.length > 0) {
	          imgs = arg[0].src;
	        }
	        var imgsArr = imgs.split(",");
      	$scope.vo.ppm_picture_show = imgsArr[0].split("|")[0].replace("m.shequkuaixian.com","imgtest.sqkx.net");
       	$scope.vo.ppm_picture =imgsArr[0].split("|")[0].split("static/upload/image")[1];
	       
	      });
		    
		    var myImage = $scope.ue_myeditor.getDialog("insertimage");
		    myImage.open();
	  };
	 

	  	/**
	 * 支付方式
	 */
	$scope.getPayMethodCheckedIds = function()
	{
	  $scope.payMethodCheckedIds = "";
	  var ids = [];
	  $("input[name='payMethod']:checked").not(":disabled").each(function(){		  
	    var selectId = $(this).val();	
	   //  console.log(selectId);
	    ids.push(selectId);
	  });
	  $scope.vo.ppm_paymethod = ids.join(','); 
	}
	  	/**
	 * 支付方式列表
	 */
	$scope.payMethodList = [];
	$scope.queryPayMethodList = function(){
		var success = function(result){
			 
			 $scope.payMethodList = result.data;
		  }
		  var error = function(result){
			  messageFactory.closeLoading();
			  messageFactory.showMessage('error',result.desc);
		  }
		var url = '/admin/base/baseDataControl/detailItem.action?codekey=2163';
		http.post(url,null,success,error);
	}
	$scope.queryPayMethodList();


	$scope.getPayWayCheckedIds = function()
	{
	  $scope.payWayCheckedIds = "";
	  var ids = [];
	  $("input[name='payWay']:checked").not(":disabled").each(function(){		  
	    var selectId = $(this).val();	
	   //  console.log(selectId);
	    ids.push(selectId);
	  });
	  $scope.vo.ppm_payway = ids.join(','); 
	}
	/**
	 * 支付类型列表
	 */
	$scope.payWayList = [];
	$scope.queryPayWayList = function(){
	  var success = function(result){
		$scope.payWayList = result.data;
		// $scope.payWayList = [{"bd_code":"1", "bd_name":"线上支付"},{"bd_code":"2", "bd_name":"线下支付"}];
	  }
	  var error = function(result){
		  messageFactory.closeLoading();
		  messageFactory.showMessage('error',result.desc);
	  }
		var url = '/admin/base/baseDataControl/detailItem.action?codekey=2166';
		http.post(url,null,success,error);
	}
	$scope.queryPayWayList();

	$scope.upVideo = function($event) {
		$scope.ue_myvideoeditor.addListener("afterUpVideo",
			function(t, arg) {
				$scope.vo.ppm_def1 = arg[0].url;
				$scope.vo.ppm_def1_show = arg[0].url;
			}
		);
		var myvideo = $scope.ue_myvideoeditor
				.getDialog("insertvideo");
		myvideo.open();
	};
	$scope.clearVideo = function(){
		$scope.vo.ppm_def1 = "";
		$scope.vo.ppm_def1_show = "";
	}

	$scope.upImage2 = function($event) {
	    
		$scope.ue_myeditor2.addListener("beforeInsertImage", function(t, arg) {
		  var imgs = "";

		  if (arg.length > 0) {
			imgs = arg[0].src;
		  }
		  var imgsArr = imgs.split(",");
		$scope.vo.ppm_def2_show = imgsArr[0].split("|")[0].replace("m.shequkuaixian.com","imgtest.sqkx.net");
		 $scope.vo.ppm_def2 =imgsArr[0].split("|")[0].split("static/upload/image")[1];
		 
		});
		  
		  var myImage = $scope.ue_myeditor2.getDialog("insertimage");
		  myImage.open();
	};
})