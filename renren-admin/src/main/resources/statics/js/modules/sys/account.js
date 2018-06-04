$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/account/list',
        datatype: "json",
        colModel: [			
			{ label: 'accountId', name: 'accountId', index: 'ACCOUNT_ID', width: 50, key: true },
			{ label: '会员ID', name: 'userId', index: 'USER_ID', width: 80 }, 			
			{ label: '累计充值', name: 'totalIn', index: 'TOTAL_IN', width: 80 }, 			
			{ label: '累计消费', name: 'totalOut', index: 'TOTAL_OUT', width: 80 }, 			
			{ label: '账户余额', name: 'balance', index: 'BALANCE', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'UPDATE_TIME', width: 80 }			
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
		account: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.account = {};
		},
		update: function (event) {
			var accountId = getSelectedRow();
			if(accountId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(accountId)
		},
		saveOrUpdate: function (event) {
			var url = vm.account.accountId == null ? "sys/account/save" : "sys/account/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.account),
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
			var accountIds = getSelectedRows();
			if(accountIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/account/delete",
                    contentType: "application/json",
				    data: JSON.stringify(accountIds),
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
		getInfo: function(accountId){
			$.get(baseURL + "sys/account/info/"+accountId, function(r){
                vm.account = r.account;
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