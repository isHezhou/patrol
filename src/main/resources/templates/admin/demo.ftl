<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>示例页</title>
    <#assign adminTemplate = "adminDemo" />
    <#include "../_common_css.ftl" />
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>标题</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="panel panel-default panel-body">
                            <form method="post" id="searchForm" class="form-group form-group-sm">
                                <div class="form-group form-inline">
                                    <div class="form-group">
                                        <label class="control-label">&nbsp;&nbsp;&nbsp;用户昵称：</label>
                                        <input name="nick" type="text" class="form-control" placeholder="用户昵称" />
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">&nbsp;&nbsp;&nbsp;手机号：</label>
                                        <input name="mobile" type="text" class="form-control" placeholder="手机号" />
                                    </div>
                                    <div class="form-group">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button style="margin-top: 5px;" type="button" class="btn btn-info btn-sm" onclick="search()">
                                            <i class='glyphicon glyphicon-search'></i>&nbsp;&nbsp;查&nbsp;&nbsp;询
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div id="ignb-doing">
                            <button style="margin-top: -15px" type="button" class="btn btn-w-m btn-success">新增</button>
                            <button style="margin-top: -15px" type="button" class="btn btn-w-m btn-warning">批量保存排序号</button>
                            <button style="margin-top: -15px" type="button" class="btn btn-w-m btn-danger" onclick="Patrol.model('modalForm')">弹层</button>
                        </div>

                        <div class="jqGrid_wrapper">
                            <table id="dataList"></table>
                            <div id="pageData"></div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </div>
</body>


<#include "../_common_js.ftl" />

</html>


<#--模态弹层-->
<div id="modalForm" class="modal inmodal fade" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog" style="width:600px;">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal" type="button">
                    <span aria-hidden="true">×</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" style="font-size:14px;">新增/修改信息</h4>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="row">
                        <input name="pk" id="pk" class="form-control col-sm-1" type="hidden"/>
                        <div class="col-sm-12 form-group-sm">
                            <div class="form-group col-sm-10"  style="margin:0 0 5px 0">
                                <label class="col-sm-4" style="line-height:35px;"><span style="color: red;font-size: 14px;margin-top: 5px;">*</span>&nbsp;标题</label>
                                <div class="col-sm-8">
                                    <input name="title" id="title" class="form-control col-sm-1"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 form-group-sm">
                            <div class="form-group col-sm-10"  style="margin:0 0 5px 0">
                                <label class="col-sm-4" style="line-height:35px;"><span style="color: red;font-size: 14px;margin-top: 5px;">*</span>&nbsp;描述</label>
                                <div class="col-sm-8">
                                    <input name="desc" id="desc" class="form-control col-sm-1"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 form-group-sm" style="margin-top:30px;">
                            <span class="col-sm-3"></span>
                            <button type="button" class="col-sm-2 btn btn-white btn-sm" data-dismiss="modal">取消</button>
                            <span class="col-sm-2"></span>
                            <button type="button" class="col-sm-2 btn btn-primary btn-sm" onclick="checkParam()">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>