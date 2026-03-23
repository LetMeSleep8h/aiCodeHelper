package com.example.aicodehelper.controller.ai;

import com.example.aicodehelper.ai.AiCodeHelperService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class controller {
    @Resource
    private AiCodeHelperService aiCodeHelperService;

//    @GetMapping("/chat")
//    public Flux<ServerSentEvent<String>> chat(int memoryid,String messageConverters){
//            aiCodeHelperService.chatStream(memoryId,message)
//                    .map(chunk ->ServerSentEvent.<String>builder()
//                            .date(chunk)
//                            .build());
//    }
}
