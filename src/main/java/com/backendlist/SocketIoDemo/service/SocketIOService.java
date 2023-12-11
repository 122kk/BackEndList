package com.backendlist.SocketIoDemo.service;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class SocketIOService {
    //使用ConcurrentMap来存储客户端
    public static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();
 
    //给每个事件进行定义，用于客户端和服务端之间的通信
    private static final String TEST_EVENT = "test_event";
 
    //给容器内所有的客户端发送信息
    public void sendMessageToAllUsers(String message){
        if(clientMap.isEmpty()){
            return;
        }
        for(String key:clientMap.keySet()) {
            SocketIOClient socketIOClient = clientMap.get(key);
            socketIOClient.sendEvent("test_event",message);
        }
    }
 
}