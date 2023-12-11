package com.backendlist.SocketIoDemo.service;
 
import com.alibaba.druid.support.json.JSONUtils;
import com.backendlist.SocketIoDemo.MessageInfo;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Slf4j
@Service
public class SocketIOClientService{
    public void sendMessage(String name) {
        // 服务端socket.io连接通信地址
        String url = "http://127.0.0.1:8003?userName="+name;
        System.out.println("lalalala");
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            //失败后重试次数
            options.reconnectionAttempts = 2;
            // 失败重连的时间间隔
            options.reconnectionDelay = 1000;
            // 连接超时时间(ms)
            options.timeout = 500;
 
            final Socket socket = IO.socket(url, options);
 
            socket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage1(String name) {
        // 服务端socket.io连接通信地址
        String url = "http://127.0.0.1:8003?userName="+name;
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            //失败后重试次数
            options.reconnectionAttempts = 2;
            // 失败重连的时间间隔
            options.reconnectionDelay = 1000;
            // 连接超时时间(ms)
            options.timeout = 500;
            final Socket socket = IO.socket(url, options);

            //客户端监听某个事件,这个是系统定义的事件(链接事件)
            socket.on(Socket.EVENT_CONNECT, message -> System.out.println("连接成功"));

            // 自定义事件`test_event` -> 接收服务端成功连接消息
            System.out.println("###############################################################");
            socket.on("test_event", objects -> System.out.println("这是客户端接受到的消息:"+objects));
            socket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage2(String name) {
        // 服务端socket.io连接通信地址
        String url = "http://127.0.0.1:8003?userName="+name;
        try {
            IO.Options options = new IO.Options();
            options.transports = new String[]{"websocket"};
            //失败后重试次数
            options.reconnectionAttempts = 2;
            // 失败重连的时间间隔
            options.reconnectionDelay = 1000;
            // 连接超时时间(ms)
            options.timeout = 500;
            final Socket socket = IO.socket(url, options);

            //客户端监听某个事件,这个是系统定义的事件(链接事件)
            socket.on(Socket.EVENT_CONNECT, message -> System.out.println("连接成功"));

            // 自定义事件`test_event` -> 接收服务端成功连接消息
            // socket.on("test_event", objects -> System.out.println(objects[0].toString()));
            socket.connect();
            MessageInfo msg1=new MessageInfo();
            msg1.setMsg("这是"+name+"的消息");
            msg1.setToUserName("张三");
            msg1.setFromUserName(name);
            // String msg="这是"+name+"的消息";
            // String ToUserName="张三";
            // String FromUserName=name;
            // JSONObject jsonObject=new JSONObject(messageInfo);
            // String msg1 = jsonObject.toString();

            socket.emit("sendMessage", msg1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}