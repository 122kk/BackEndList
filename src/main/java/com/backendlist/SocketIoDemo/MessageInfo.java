package com.backendlist.SocketIoDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kj
 * @date 2023/5/9
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo implements Serializable {
    String fromUserName;
    String toUserName;
    String msg;
}
