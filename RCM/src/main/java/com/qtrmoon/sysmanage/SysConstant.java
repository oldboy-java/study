package com.qtrmoon.sysmanage;

public class SysConstant {
    public final static String CURRENT_USER="CURRENT_USER";
    
    // 0浏览访问角色;1主系统管理角色；2分系统管理员/制定权限角色;3注册默认
    public static final String ROLE_CLASSIFY_NOLIMIT = "0";

    public static final String ROLE_CLASSIFY_ADMIN = "1";

    public static final String ROLE_CLASSIFY_COMMON = "2";

    public static final String ROLE_CLASSIFY_REGIST = "3";

    public static final String ROLE_ISLOCAL = "1";// 本地角色

    public static final String ROLE_NOTLOCAL = "0";// 通用角色

    public static final String FUNCTION_SHOW = "1";// 菜单类
    public static final String FUNCTION_PAGE_HIDE = "2";// 菜单隐藏，角色配置显示
    public static final String FUNCTION_HIDE = "0";// 菜单和角色配置都隐藏

    public static final String USER_AUDIT = "1";//手动添加,已审核

    public static final String USER_UNAUDIT = "0";//注册,末审核

    public static final String USER_SUPERADMIN = "x";//超管员

    public static final String ORGAN_ORGAN = "1";// 机构

    public static final String ORGAN_DEPARTMENT = "0";// 部门
    
}
