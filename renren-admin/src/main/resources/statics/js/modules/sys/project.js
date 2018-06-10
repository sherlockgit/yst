$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/project/list',
        datatype: "json",
        colModel: [			
			{ label: 'proId', name: 'proId', index: 'PRO_ID', width: 50, key: true },
			{ label: '项目名称', name: 'proName', index: 'PRO_NAME', width: 80 }, 			
			{ label: '项目推荐语', name: 'proBrief', index: 'PRO_BRIEF', width: 80 }, 			
			{ label: '项目状态[0-新建 1-已上线 2-已下线]', name: 'proStatus', index: 'PRO_STATUS', width: 80 }, 			
			{ label: '项目类型[0-足疗 1-保健 2-纤体 3-养生]', name: 'proType', index: 'PRO_TYPE', width: 80 }, 			
			{ label: '项目定价', name: 'proAmt', index: 'PRO_AMT', width: 80 }, 			
			{ label: '服务时长/分钟', name: 'proLong', index: 'PRO_LONG', width: 80 }, 			
			{ label: '项目介绍', name: 'proContent', index: 'PRO_CONTENT', width: 80 }, 			
			{ label: '每天人数限制', name: 'maxPeople', index: 'MAX_PEOPLE', width: 80 }, 			
			{ label: '封面图', name: 'coverPic', index: 'COVER_PIC', width: 80 }, 			
			{ label: '介绍轮播图', name: 'cyclePic', index: 'CYCLE_PIC', width: 80 }, 			
			{ label: '受理预约开始时间', name: 'beginTime', index: 'BEGIN_TIME', width: 80 }, 			
			{ label: '受理预约结束时间', name: 'endTime', index: 'END_TIME', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'CREATE_TIME', width: 80 }, 			
			{ label: '项目说明', name: 'memo', index: 'MEMO', width: 80 }			
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
		project: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.project = {};
		},
		update: function (event) {
			var proId = getSelectedRow();
			if(proId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(proId)
		},
		saveOrUpdate: function (event) {
			var url = vm.project.proId == null ? "sys/project/save" : "sys/project/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.project),
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
			var proIds = getSelectedRows();
			if(proIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/project/delete",
                    contentType: "application/json",
				    data: JSON.stringify(proIds),
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
		getInfo: function(proId){
			$.get(baseURL + "sys/project/info/"+proId, function(r){
                vm.project = r.project;
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

$('#datetimeStart').datetimepicker({
    format: 'hh:ii'
});

$('#datetimeEnd').datetimepicker({
    format: 'hh:ii'
});