package com.moreira.livechatproject.infra.config.adapters.websocket;

import com.moreira.livechatproject.infra.config.adapters.websocket.dtos.ChatInputRequest;
import com.moreira.livechatproject.infra.config.adapters.websocket.dtos.ChatOutputResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutputResponse newMessage(ChatInputRequest request) {
        return new ChatOutputResponse(HtmlUtils.htmlEscape(request.username() + ": " + request.message()));
    }
}
