package com.example.springboothksdk.service;


import com.example.springboothksdk.enums.ErrorEnum;
import com.example.springboothksdk.basics.*;
import com.example.springboothksdk.dto.ControlDoorDTO;
import com.example.springboothksdk.dto.LoginDTO;
import com.sun.jna.NativeLong;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.logging.Logger;

@Service
public class DoorService {

    protected final Logger log = Logger.getLogger(this.getClass().getName());

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    public static NativeLong g_lVoiceHandle;// voice talk handle

    static int m_iTreeNodeNum;// tree node num
    static DefaultMutableTreeNode m_DeviceRoot;
    static HashMap<String, DeviceInfo> m_hashDeviceInfo; // login info
    private boolean m_isPlaying; // isPlaying
    private static int m_iChannelNum;// channel num
    private static NativeLong m_lLogID; // login ID
    private static NativeLong lUserID = new NativeLong();

    static NativeLong m_lPreviewHandle;// preview handle

    private JPanel contentPane;
    private Panel panelRealPlay = new Panel();
    @SuppressWarnings("rawtypes")
    private static JComboBox comboBoxWindow;
    private JButton btnButtonPlay;
    private JPanel panel;
    private JLabel lblNewLabel_4;
    private Panel panelPlay;
    static JTree treeDevice;
    private static JTable tableAlarm;
    private JScrollPane scrollPane;
    private JMenuItem MenuItemVoice;

    public boolean init(){
        //SDK初始化
        return hCNetSDK.NET_DVR_Init();
    }

    public String login(LoginDTO loginDTO){
        HCNetSDK.NET_DVR_DEVICEINFO_V40 deviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();
        HCNetSDK.NET_DVR_USER_LOGIN_INFO loginInfo= new HCNetSDK.NET_DVR_USER_LOGIN_INFO();
        String m_sDeviceIP = loginDTO.getM_sDeviceIP();//设备ip地址
        loginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(m_sDeviceIP.getBytes(), 0, loginInfo.sDeviceAddress, 0, m_sDeviceIP.length());

        String m_sUsername = loginDTO.getM_sUsername();//设备用户名
        loginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(m_sUsername.getBytes(), 0, loginInfo.sUserName, 0, m_sUsername.length());

        String m_sPassword = loginDTO.getM_sPassword();//设备密码
        loginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(m_sPassword.getBytes(), 0, loginInfo.sPassword, 0, m_sPassword.length());

        loginInfo.wPort = loginDTO.getwPort();
        loginInfo.bUseAsynLogin = loginDTO.getbUseAsynLogin(); //是否异步登录：0- 否，1- 是
        loginInfo.write();
        NativeLong id = hCNetSDK.NET_DVR_Login_V40(loginInfo.getPointer(), deviceInfo.getPointer());
        if (id.longValue() == 0 || id.longValue()==lUserID.longValue()+1)
        {
            System.out.println("登录成功！");
            lUserID = id;
            return "success";
        }
        else
        {
            return "登录失败，错误码为"+hCNetSDK.NET_DVR_GetLastError()+",错误为"+ ErrorEnum.getNameByCode(hCNetSDK.NET_DVR_GetLastError());
        }
    }

    public boolean logout(){
        //退出程序时调用注销登录、反初始化接口
        boolean flag = hCNetSDK.NET_DVR_Logout(lUserID);
        hCNetSDK.NET_DVR_Cleanup();
        return flag;
    }

    public boolean controllDoor(ControlDoorDTO doorDTO){
        return hCNetSDK.NET_DVR_ControlGateway(lUserID, doorDTO.getGatewayIndex(), doorDTO.getDwStaic());
    }

}
