package com.example.springboothksdk.enums;

public enum ErrorEnum {
    /**
     * 没有错误
     */
    NET_DVR_NOERROR("没有错误", 0),
    /**
     * 用户名密码错误
     */
    NET_DVR_PASSWORD_ERROR("用户名密码错误,注册时输入的用户名或者密码错误", 1),
    /**
     * 权限不足
     */
    NET_DVR_NOENOUGHPRI("权限不足,一般和通道相关，例如有预览通道1权限，无预览通道2权限，即有预览权限但不完全，预览通道2返回此错误。",2),
    /**
     * SDK未初始化
     */
    NET_DVR_NOINIT("SDK未初始化,必须先调用NET_DVR_Init，该接口是调用其他SDK函数的前提且一个程序进程只需要调用一次", 3),
    /**
     * 通道号错误
     */
    NET_DVR_CHANNEL_ERROR("通道号错误,设备通道分模拟通道和数字通道（IP通道），NET_DVR_Login_V40登录设备成功之后会返回设备支持的通道个数和起始通道号取值，详见“通道和通道号号相关说明", 4),
    /**
     * 设备总的连接数超过最大
     */
    NET_DVR_NOENNET_DVR_OVER_MAXLINKOUGHPRI("设备总的连接数超过最大,例如网络摄像机只支持6路预览，预览第7路即会返回失败，错误码返回5。不同设备性能不一样，支持路数也不同。", 5),
    /**
     * 版本不匹配
     */
    NET_DVR_VERSIONNOMATCH("版本不匹配,SDK和设备的版本不匹配", 6),
    /**
     * 连接设备失败
     */
    NET_DVR_NETWORK_FAIL_CONNECT("连接设备失败,设备不在线或网络原因引起的连接超时等",7),
    /**
     * 向设备发送失败
     */
    NET_DVR_NETWORK_SEND_ERROR("向设备发送失败",8),
    /**
     * 从设备接收数据失败
     */
    NET_DVR_NETWORK_RECV_ERROR("从设备接收数据失败", 9),
    /**
     * 从设备接收数据超时
     */
    NET_DVR_NETWORK_RECV_TIMEOUT("从设备接收数据超时",10),
    /**
     * 传送的数据有误
     */
    NET_DVR_NETWORK_ERRORDATA("传送的数据有误,发送给设备或者从设备接收到的数据错误，如远程参数配置时输入设备不支持的值。",11),
    /**
     * 无此权限
     */
    NET_DVR_OPERNOPERMIT("无此权限,用户对某个功能模块的权限，例如无预览权限用户预览返回此错误。", 13),
    /**
     * 设备忙
     */
    NET_DVR_BUSY("设备忙", 24),
    /**
     * 设备资源不足
     */
    NET_DVR_DVRNORESOURCE("设备资源不足",28),
    /**
     * 用户不存在
     */
    NET_DVR_USERNOTEXIST("用户不存在,注册的用户ID已注销或不可用。",47),
    /**
     * 登录设备的用户数达到最大
     */
    NET_DVR_MAX_USERNUM("登录设备的用户数达到最大。", 52),
    /**
     * 从设备接收数据超时
     */
    NET_DVR_IPMISMATCH("从设备接收数据超时",55),
    /**
     * 注销时用户ID正在进行某操作。
     */
    NET_DVR_USERID_ISUSING("注销时用户ID正在进行某操作", 74),
    /**
     * 远程用户配置结构中存在相同的用户名
     */
    NET_DVR_WITHSAMEUSERNAME("远程用户配置结构中存在相同的用户名", 79),
    /**
     * 用户还没登录成功
     */
    NET_DVR_USER_NOT_SUCC_LOGIN("版本不匹配,用户还没登录成功", 102),
    /**
     * 用户名不存在（V5.1.7~V5.3.1版本的IPC、IPD的错误码）
     */
    NET_DVR_USERNAME_NOT_EXIST("用户名不存在（V5.1.7~V5.3.1版本的IPC、IPD的错误码）",152),
    /**
     * 用户名被锁定
     */
    NET_ERR_USERNAME_LOCKED("用户名被锁定",153),
    /**
     * 无效用户ID
     */
    NET_DVR_INVALID_USERID("无效用户ID", 154),
    /**
     * 用户名密码不正确，测试服务器的用户名或密码错误
     */
    NET_DVR_TEST_SERVER_PASSWORD_ERROR("用户名密码不正确，测试服务器的用户名或密码错误",170),
    /**
     * 用户名相同
     */
    NET_ERR_SAME_USER_NAME("用户名相同",914),
    /**
     * 无效用户名
     */
    NET_ERR_INVALID_USER_NAME("无效用户名", 915),
    /**
     * 设备忙
     */
    NET_ERR_USERALREADY_LOGON("设备忙", 923),
    /**
     * 用户名或密码非法
     */
    NET_DVR_ERR_CLUSTER_USERNAEM_OR_PASSWORD_INVALID("用户名或密码非法",2136);

    private String name;
    private Integer code;

    ErrorEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName(ErrorEnum errorEnum) {
        return errorEnum.name;
    }
    

    public Integer getCode(ErrorEnum errorEnum) {
        return errorEnum.code;
    }

    public Integer getCode() {
        return code;
    }
    

    public static String getNameByCode(Integer code){
        for(ErrorEnum errorEnum:ErrorEnum.values()){
            if(code.equals(errorEnum.getCode())){
                return errorEnum.getName(errorEnum);
            }
        }
        return  "请去SDK手册查询具体原因";
    }
}
