/**
 * Created by WangSheng on 2019/10/14.
 */
/*登录事件*/
$(".vip-login-submit").click(function(){
    let _params = $(".m-t").toFormCustom();
    let _result = Patrol.ajax("/admin/loginSubmit",_params,false);
    if(_result==null){
        Patrol.toastr("提示","操作异常，请刷新页面重试",1);
        return false;
    }
    if(_result.code===0){
        Patrol.href("/admin/console");
    }else{
        Patrol.toastr("提示",_result.msg,1);
        return false;
    }
});

/*退出登录事件*/
$(".login-out").click(function(){
    Patrol.prompt("确定退出？","","warning",true,["确定","取消"],function () {
        Patrol.href("/admin/logout");
    })
});

