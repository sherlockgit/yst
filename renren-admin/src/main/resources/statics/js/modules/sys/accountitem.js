$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/accountitem/list',
        datatype: "json",
        colModel: [			
			{ label: 'itemId', name: 'itemId', index: 'ITEM_ID', width: 50, key: true },
			{ label: '会员ID', name: 'userId', index: 'USER_ID', width: 80 }, 			
			{ label: '充值', name: 'amtIn', index: 'AMT_IN', width: 80 }, 			
			{ label: '消费', name: 'amtOut', index: 'AMT_OUT', width: 80 }, 			
			{ label: '账户余额', name: 'balance', index: 'BALANCE', width: 80 }, 			
			{ label: '交易状态[0-失败  1-成功]', name: 'tranStatus', index: 'TRAN_STATUS', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'CREATE_TIME', width: 80 }, 			
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
		accountItem: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.accountItem = {};
		},
		update: function (event) {
			var itemId = getSelectedRow();
			if(itemId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(itemId)
		},
		saveOrUpdate: function (event) {
			var url = vm.accountItem.itemId == null ? "sys/accountitem/save" : "sys/accountitem/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.accountItem),
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
			var itemIds = getSelectedRows();
			if(itemIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/accountitem/delete",
                    contentType: "application/json",
				    data: JSON.stringify(itemIds),
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
		getInfo: function(itemId){
			$.get(baseURL + "sys/accountitem/info/"+itemId, function(r){
                vm.accountItem = r.accountItem;
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