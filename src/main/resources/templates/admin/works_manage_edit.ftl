<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>作品编辑</title>
    <#assign adminTemplate = "adminWorksEdit" />
    <#include "../_common_css.ftl" />
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>作品编辑</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t">
                            <input id="worksId" name="worksId" class="form-control" type="hidden">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标题：</label>
                                <div class="col-sm-8">
                                    <input id="title" name="title" class="form-control" type="text" placeholder="标题">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">描述：</label>
                                <div class="col-sm-8">
                                    <input id="description" name="description" class="form-control" type="text" aria-required="true" aria-invalid="false" placeholder="描述">
                                    <#--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 如果为空，默认以内容的前30个字作为描述</span>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">内容：</label>
                                <div class="col-sm-8">
                                    <script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-5">
                                    <a class="btn btn-default" onclick="Jlwh.pagerClose()">取消</a>
                                    <a class="btn btn-primary" onclick="Works._form._submit()">提交</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>


<#include "../_common_js.ftl" />
<script type="text/javascript">
    Works._works_id = "${worksId!}";
</script>


</html>
