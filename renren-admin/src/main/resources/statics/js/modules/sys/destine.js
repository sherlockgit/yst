$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/destine/list',
        datatype: "json",
        colModel: [			
			{ label: 'destineId', name: 'destineId', index: 'DESTINE_ID', width: 50, key: true },
			{ label: '会员ID', name: 'userId', index: 'USER_ID', width: 80 }, 			
			{ label: '预约姓名', name: 'uname', index: 'UNAME', width: 80 }, 			
			{ label: '手机号码', name: 'phone', index: 'PHONE', width: 80 }, 			
			{ label: '项目ID', name: 'proId', index: 'PRO_ID', width: 80 }, 			
			{ label: '项目类型[0-足疗 1-保健 2-纤体 3-养生]', name: 'proType', index: 'PRO_TYPE', width: 80 }, 			
			{ label: '项目名称', name: 'proName', index: 'PRO_NAME', width: 80 }, 			
			{ label: '项目金额', name: 'proAmt', index: 'PRO_AMT', width: 80 }, 			
			{ label: '预约状态[0-待确认 1-待服务 2-已取消 3-已完成]', name: 'distineStatus', index: 'DISTINE_STATUS', width: 80 }, 			
			{ label: '预约服务时间', name: 'destineTime', index: 'DESTINE_TIME', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'CREATE_TIME', width: 80 }, 			
			{ label: '', name: 'memo', index: 'MEMO', width: 80 }			
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
		destine: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.destine = {};
		},
		update: function (event) {
			var destineId = getSelectedRow();
			if(destineId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(destineId)
		},
		saveOrUpdate: function (event) {
			var url = vm.destine.destineId == null ? "sys/destine/save" : "sys/destine/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.destine),
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
			var destineIds = getSelectedRows();
			if(destineIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/destine/delete",
                    contentType: "application/json",
				    data: JSON.stringify(destineIds),
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
		getInfo: function(destineId){
			$.get(baseURL + "sys/destine/info/"+destineId, function(r){
                vm.destine = r.destine;
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