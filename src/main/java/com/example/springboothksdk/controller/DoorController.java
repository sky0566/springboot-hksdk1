package com.example.springboothksdk.controller;


import com.example.springboothksdk.dto.ControlDoorDTO;
import com.example.springboothksdk.dto.LoginDTO;
import com.example.springboothksdk.service.DoorService;
import com.example.springboothksdk.utils.ResponseMessage;
import com.sun.jna.NativeLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoorController {

    @Autowired
    DoorService doorService;

    @GetMapping("/init")
    public ResponseMessage init(){
       if (doorService.init()){
           return ResponseMessage.success("初始化成功");
       }else {
           return ResponseMessage.fail("初始化失败");
       }
    }

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody LoginDTO loginDTO){
        if ("success".equals(doorService.login(loginDTO))){
            return ResponseMessage.success("登录成功");
        }else {
            return ResponseMessage.fail(doorService.login(loginDTO));
        }

    }

    @PostMapping("/logout")
    public ResponseMessage logout(){
        if (doorService.logout()){
            return ResponseMessage.success("注销登录成功");
        }else {
            return ResponseMessage.fail("注销登录失败");
        }

    }

    @PostMapping("/controlDoor")
    public ResponseMessage controlDoor(@RequestBody ControlDoorDTO doorDTO){
        if (doorService.controllDoor(doorDTO)){
            return ResponseMessage.success("修改状态成功");
        }else {
            return ResponseMessage.fail("修改状态失败");
        }

    }

}
