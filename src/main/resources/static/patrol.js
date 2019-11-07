/*** Created by WangSheng on 2019/10/14.*/
; $(function () {
    $.fn.toForm = function() {
        let serializeObj = {};
        $(this.serializeArray()).each(function() {
            serializeObj[this.name] = this.value;
        });
        return serializeObj;
    };
    $.fn.toFormCustom = function () {
        let serializeObj = {};
        let params = $("*[tag='param']");
        params.each(function (index,item) {
            serializeObj[item.name] = item.value;
        });
        let paramsCk = $('input[tag="param"]:checked');
        paramsCk.each(function (index,item) {
            serializeObj[item.name] = item.value;
        });
        return serializeObj;
    };
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "onclick": null,
        "showDuration": "2000",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
});

let Patrol = {
    /*JqGrid表格初始化*/
    jqGrid : function($cellCustom,$callBack,$hasNumber){
        $cellCustom();
        $(window).bind("resize", function () {
            let width = $(".jqGrid_wrapper").width();
            $("#dataList").setGridWidth(width);
        })
        if($hasNumber){
            $("#jqgh_dataList_rn").html("序号");
        }
        $callBack();
    },
    /*JqGrid表格查询封装*/
    jqGridSearch : function($searchForm,$pageData,$pageList){
        let params = $("#searchForm").toForm();
        $("#"+$pageList).jqGrid('setGridParam',{
            url : $("#searchForm").attr("href"),
            datatype : 'json',
            type : "post",
            page : 1,
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            postData : params,
            pager: "#"+$pageData,
            viewrecords : true,
            loadComplete : function(result){

            }
        }).trigger("reloadGrid");
    },
    /*Ajax请求封装*/
    ajax: function ($location, $param, $sync) {
        let _result = null;
        $.ajax({
            type: "post", url: $location, data: $param, async: $sync,
            success: function ($data) {
                _result = $data;
            }
        });
        return _result;
    },
    /*模态弹层展示*/
    model : function ($id,$isStatic) {
        if($isStatic){
            $("#"+$id).modal({show : true, backdrop : 'static'});
        }else{
            $("#"+$id).modal();
        }
    },
    /*模态弹层隐藏*/
    modelHidden : function($id){
        $('#'+$id).modal('hide');
    },
    /*链接跳转*/
    href : function ($link) {
        window.location = $link;
    },
    /*toastr 通知【$title标题，$content内容，$type类型（0成功，1失败）】*/
    toastr : function ($title, $content, $type) {
        [function () {
            toastr.success($content, $title);
        }, function () {
            toastr.error($content, $title);
        }][$type]();
    },

    /*prompt 提示框【$title标题，$text描述，$type类型（success，warning，error）】*/
    prompt: function ($title, $text,$type,$callBack) {
        swal({
            title: $title,
            text: $text,
            type: $type
        }, function () {
            if($callBack!==undefined){
                $callBack();
            }
        });
    },

    /*prompt 提示框【$title标题，$text描述，$type类型（success，warning，error），$hasCancel是否存在取消按钮，$btnText确定和取消按钮文案，$callBack回调函数】*/
    promptConfirm: function ($title, $text, $type, $hasCancel, $btnText, $callBack) {
        let _hasCancel = false;
        if ($hasCancel !== undefined) {
            _hasCancel = $hasCancel;
        }
        swal({
            title: $title,
            text: $text,
            type: $type,
            showCancelButton: _hasCancel,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: $btnText[0],
            cancelButtonText: _hasCancel ? $btnText[1] : "",
            closeOnConfirm: true
        }, function () {
            $callBack();
        });
    },

    /*prompt 提示框【$title标题，$text描述，$type类型（success，warning，error），$hasCancel是否存在取消按钮，$btnText确定和取消按钮文案，$callBack回调函数，$isClose确定后是否关闭弹框】*/
    promptConfirm: function ($title, $text, $type, $hasCancel, $btnText, $callBack,$isClose) {
        let _hasCancel = false;
        if ($hasCancel !== undefined) {
            _hasCancel = $hasCancel;
        }
        swal({
            title: $title,
            text: $text,
            type: $type,
            showCancelButton: _hasCancel,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: $btnText[0],
            cancelButtonText: _hasCancel ? $btnText[1] : "",
            closeOnConfirm: $isClose
        }, function () {
            $callBack();
        });
    },
    /*新增Tab页*/
    pager : function ($url,$title) {
        let _wpd = window.parent.document;
        $(_wpd).find('.J_menuTabs .page-tabs-content ').find(".J_menuTab.active").removeClass("active");
        $(_wpd).find('.J_mainContent').find("iframe").css("display", "none");
        let iframe = '<iframe class="J_iframe" name="iframe10000" width="100%" height="100%" src="' + $url + '" frameborder="0" data-id="' + $url
            + '" seamless="" style="display: inline;"></iframe>';
        $(_wpd).find('.J_menuTabs .page-tabs-content ').append(
            ' <a href="javascript:;" class="J_menuTab active" data-id="'+$url+'">' + $title + ' <i class="fa fa-times-circle"></i></a>');
        $(_wpd).find('.J_mainContent').append(iframe);
    },
    /*关闭当前Tab页*/
    pagerClose : function () {
        $(".J_menuTab.active",window.top.document).find(".fa.fa-times-circle").click();
    },
    timer : function ($callBack,time) {
        setInterval(function () {
            $callBack();
        }, time)
    }
};