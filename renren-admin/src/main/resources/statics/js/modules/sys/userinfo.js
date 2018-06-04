$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/userinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'USER_ID', width: 50, key: true },
			{ label: '用户姓名', name: 'userName', index: 'USER_NAME', width: 80 }, 			
			{ label: '用户类型[1-VIP  2-普通用户]', name: 'userType', index: 'USER_TYPE', width: 80 }, 			
			{ label: '性别', name: 'userSex', index: 'USER_SEX', width: 80 }, 			
			{ label: '手机号码', name: 'phone', index: 'PHONE', width: 80 }, 			
			{ label: '住址', name: 'address', index: 'ADDRESS', width: 80 }, 			
			{ label: '微信名称', name: 'wxUname', index: 'WX_UNAME', width: 80 }, 			
			{ label: '微信OPENID', name: 'wxOpenid', index: 'WX_OPENID', width: 80 }, 			
			{ label: '微信头像', name: 'wxHeadpic', index: 'WX_HEADPIC', width: 80 }, 			
			{ label: '说明', name: 'memo', index: 'MEMO', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		userInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.userInfo = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var url = vm.userInfo.userId == null ? "sys/userinfo/save" : "sys/userinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.userInfo),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/userinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(userId){
			$.get(baseURL + "sys/userinfo/info/"+userId, function(r){
                vm.userInfo = r.userInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});