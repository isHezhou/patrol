package com.patrol.common.enums;

/***
 * 公共页枚举
 *
 * @author WangSheng/2019-09-14
 */
public enum Pages {

    $404("404页面", "404"),
    $WEB_INDEX("前端首页", "web/index"),

    $ADMIN_LOGIN("后台登录页", "admin/login"),
    $ADMIN_CONSOLE("后台控制台", "admin/console"),
    $ADMIN_WELCOME("后台欢迎页", "admin/welcome"),
    $ADMIN_LINK_MANAGE("友情链接管理页", "admin/link_manage"),
    $ADMIN_WORKS_MANAGE("作品管理页", "admin/works_manage"),
    $ADMIN_WORKS_MANAGE_EDIT("作品编辑页", "admin/works_manage_edit"),
    $ADMIN_ARTIST_MANAGE("艺术家管理页","admin/artist_manage"),
    $ADMIN_ARTIST_MANAGE_EDIT("艺术家编辑页","admin/artist_manage_edit"),


    $ADMIN_OPUS("示例", "admin/demo"),
    $ADMIN_USERMANAGEMENT("用户管理页面", "admin/usermanagement"),
    $ADMIN_USERADD("添加/编辑用户页面", "admin/useradd-edit");


    public final String DESC;
    public final String TEMPLATES;

    Pages(String desc, String templates) {
        this.DESC = desc;
        this.TEMPLATES = templates;
    }

}
