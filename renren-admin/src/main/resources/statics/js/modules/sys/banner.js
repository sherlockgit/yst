$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/banner/list',
        datatype: "json",
        colModel: [			
			{ label: 'bannerId', hidden: true, name: 'bannerId', index: 'BANNER_ID', width: 50, key: true },
			{ label: '标题', name: 'title', index: 'TITLE', width: 80 },
            { label: '图片地址', name: 'picture', index: 'PICTURE', width: 80 },
            { label: '跳转地址', name: 'href', index: 'HREF', width: 80 },
			{ label: '排序', name: 'sort', index: 'SORT', width: 80 }, 			
			{ label: '轮播状态', name: 'statu', width: 80, formatter: function(value, options, row){
				if (value == '0') {
                	return '<span>新建</span>';
				} else if (value == '1') {
                    return '<span>已上线</span>';
				} else {
                    return '<span>已下线</span>';
				}
            }},
			{ label: '创建时间', name: 'createTime', index: 'CREATE_TIME', width: 80 }			
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
		banner: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.banner = {statu: 0,sort: 1};
		},
		update: function (event) {
			var bannerId = getSelectedRow();
			if(bannerId == null){
				return ;
			}

			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(bannerId)


        },
		saveOrUpdate: function (event) {
			var url = vm.banner.bannerId == null ? "sys/banner/save" : "sys/banner/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.banner),
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
			var bannerIds = getSelectedRows();
			if(bannerIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/banner/delete",
                    contentType: "application/json",
				    data: JSON.stringify(bannerIds),
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
		getInfo: function(bannerId){
			$.get(baseURL + "sys/banner/info/"+bannerId, function(r){
                vm.banner = r.banner;
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

$("#file").fileinput({
    showUploadedThumbs: false,
    language : 'zh',
    uploadUrl : baseURL + "common/upload/",
    autoReplace : true,
    maxFileCount : 1,
    showUpload: true,
    showCaption: false,
    showCancel: false,
    layoutTemplates :{
        // actionDelete:'', //去除上传预览的缩略图中的删除图标
        actionUpload:'',//去除上传预览缩略图中的上传图片；
        actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
    },
    initialPreview: vm.path,
    allowedFileExtensions : [ "jpg", "png", "gif" ],
    browseClass : "btn btn-primary", //按钮样式
    // previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
}).on("fileuploaded", function(e, data) {
    var res = data.response;
    vm.banner.picture = res.msg;
});