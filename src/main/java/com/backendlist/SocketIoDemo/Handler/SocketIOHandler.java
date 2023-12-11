package com.backendlist.SocketIoDemo.Handler;

import cn.hutool.extra.ssh.JschUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.backendlist.SocketIoDemo.MessageInfo;
import com.backendlist.SocketIoDemo.service.SocketIOService;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
 
 
@Slf4j
@Component
public class SocketIOHandler {
    @Autowired
    private SocketIOServer socketIoServer;//服务端对象

    // @Autowired
    // SocketIOClient socketIOClient;

    //Spring IoC容器创建之后，在加载SocketIOService Bean之后启动
    //服务端启动
    @PostConstruct
    private void autoStartup() throws Exception {
        try {
            socketIoServer.start();
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("SocketIOServer启动失败");
        }
    }
 
    //Spring IoC容器在销毁SocketIOService Bean之前关闭,避免重启项目服务端口占用问题
    //服务端关闭
    @PreDestroy
    private void autoStop() throws Exception {
        socketIoServer.stop();
    }


 
    //客户端连接的时候触发
    @OnConnect
    public void onConnect(SocketIOClient client) {
        String username = client.getHandshakeData().getSingleUrlParam("userName");
        SocketIOService.clientMap.put(username,client);
        //客户端:/127.0.0.1:64540  sessionId:9acac9ab-a000-43a7-bf97-31fac791e4f4 username: 张三已连接
        log.info("客户端:" + client.getRemoteAddress() + "  sessionId:" + client.getSessionId() +" username: "+ username+ "已连接");
    }

    @OnEvent("sendMessage")
    public void onEvent(SocketIOClient client,Object msg1){
        System.out.println("这是客户端消息:"+msg1);

        client.sendEvent("test_event", JSONUtils.toJSONString(msg1));

    }
 
    //客户端关闭连接时触发
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        //客户端:9acac9ab-a000-43a7-bf97-31fac791e4f4断开连接
        log.info("客户端:" + client.getSessionId() + "断开连接");
 
    }
 
}