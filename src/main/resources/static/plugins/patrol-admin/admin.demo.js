function search(){
    let params = $("#searchForm").toForm();
    $("#dataList").jqGrid('setGridParam',{
        url : "/admin/demo/search",
        datatype : 'json',
        type : "post",
        page : 1,
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        postData : params,
        pager: "#pageData",
        viewrecords : true,
        loadComplete : function(result){
        }
    }).trigger("reloadGrid");
}

$(document).ready(function () {
    pageinit();
    $(window).bind("resize", function () {
        let width = $(".jqGrid_wrapper").width();
        $("#dataList").setGridWidth(width);
    })
    $("#jqgh_dataList_rn").html("序号");
});

function pageinit(){
    $.jgrid.defaults.styleUI = "Bootstrap";
    $("#dataList").jqGrid({
        url : "/admin/demo/search",
        datatype : "json",
        height : "100%",
        autowidth : true,
        rownumbers : true,
        multiboxonly : false,
        viewrecords : true,
        rowList: [20],
        colNames: ["用户ID","用户昵称","手机号", "邮箱", "IP地址","修改时间","创建时间", "操作"],
        colModel: [
            {name: "id",index: "id", sortable :false, align: "center",width: 30},
            {name: "name",index: "name", sortable :false, align: "center",width: 30},
            {name: "mobile",index: "mobile", sortable :false, align: "center",width: 35},
            {name: "email",index: "email", sortable :false, align: "center",width: 35},
            {name: "ip",index: "ip", sortable :false, align: "center",width: 35},
            {name: "modify_date_cn",index: "modify_date", sortable :false, align: "center",width: 35},
            {name: "create_date_cn",index: "create_date", sortable :false, align: "center",width: 35},
            {name: "doing",index: "doing", sortable :false, align: "center",width: 35,formatter : function (cellvalue,options,rowObject){
                return "<a href='javascript:;'><span class='text-info'>修改</span></a>  " +
                    "<a href='javascript:;'><span class='text-danger'>删除</span></a>";
            }},
        ],
        pager : "#pageData",
        loadComplete : function(result){

        }
    });
};