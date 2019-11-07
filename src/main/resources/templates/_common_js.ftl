<!--common js-->
<script type="text/javascript">
    var imgUrl = '${imgUrl!}';
    var staticUrl = '${staticUrl!}';
</script>

<#if adminTemplate??>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/bootstrap.min.js?v=3.3.6"></script>
    <#--<script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/content.js?v=1.0.0"></script>-->
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/layer/layer.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/toastr/toastr.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/peity/jquery.peity.min.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/plugins/fancybox/jquery.fancybox.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/baidu-ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/baidu-ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" src="${staticUrl!}/plugins/baidu-ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="${staticUrl!}/patrol.js"></script>
    <script type="text/javascript" src="${staticUrl!}/plugins/patrol-admin/admin.index.js"></script>
    <#if adminTemplate=="adminConsole">
        <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/hplus.js?v=4.1.0"></script>
        <script type="text/javascript" src="${staticUrl!}/plugins/hplus-admin/js/contabs.js"></script>
    </#if>

    <#if adminTemplate=="adminDemo">
        <script type="text/javascript" src="${staticUrl!}/plugins/patrol-admin/admin.demo.js"></script>
    </#if>
    <#if adminTemplate=="adminUser">
        <script type="text/javascript" src="${staticUrl!}/plugins/patrol-admin/admin.user.js"></script>
    </#if>

</#if>


