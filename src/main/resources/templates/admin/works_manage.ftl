<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>作品列表</title>
    <#assign adminTemplate = "adminWorks" />
    <#include "../_common_css.ftl" />
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>作品列表</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="panel panel-default panel-body">
                            <form method="post" id="searchForm" class="form-group form-group-sm" href="/admin/works/search">
                                <div class="form-group form-inline">
                                    <div class="form-group">
                                        <label class="control-label">&nbsp;&nbsp;&nbsp;作品标题：</label>
                                        <input name="title" type="text" class="form-control" placeholder="作品标题" />
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">&nbsp;&nbsp;&nbsp;作品状态：</label>
                                        <select name="state" class="form-control">
                                            <option value="-1">全部</option>
                                            <option value="0">未发布</option>
                                            <option value="1">已发布</option>
                                            <option value="2">已下线</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button style="margin-top: 5px;" type="button" class="btn btn-info btn-sm" onclick="Patrol.jqGridSearch('searchForm','pageData','dataList')">
                                            <i class='glyphicon glyphicon-search'></i>&nbsp;&nbsp;查&nbsp;&nbsp;询
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div id="ignb-doing">
                            <button style="margin-top: -15px" type="button" class="btn btn-w-m btn-success" onclick="Patrol.pager('/admin/works/turn','作品编辑');">新增作品</button>
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
    </div>
</body>


<#include "../_common_js.ftl" />

<script>
    $(document).ready(function () {
        $('.fancybox').fancybox({
            openEffect: 'none',
            closeEffect: 'none'
        });
    });
</script>

</html>
