package com.backendlist.controller;


import com.backendlist.SocketIoDemo.service.SocketIOClientService;
import com.backendlist.SocketIoDemo.service.SocketIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.io.IOException;
 
@RestController
@Api(tags = "socketIo接口", description = "socketIo接口")
public class SocketIOClientController {
    @Autowired
    private SocketIOClientService socketIOClientService;
    @Autowired
    private SocketIOService socketIOService;
    //测试和服务端的连接
    @GetMapping("/testConnect")
    @ApiOperation("测试和服务端的连接")
    public void testConnect() throws IOException {
        socketIOClientService.sendMessage("张三");
    }

    @GetMapping("/sendMessageTo")
    @ApiOperation("测试接受消息")
    public void sendMessageTo() throws IOException {
        socketIOClientService.sendMessage1("张三");
    }

    @GetMapping("/MessageTo")
    @ApiOperation("测试发送消息")
    public void MessageTo() throws IOException {
        socketIOClientService.sendMessage2("李四");
    }



    @GetMapping("/sendMessageToAllUsers")
    @ApiOperation("测试给所有连接的用户发消息")
    public void sendMessage(String message123){
        socketIOService.sendMessageToAllUsers(message123);
    }

}