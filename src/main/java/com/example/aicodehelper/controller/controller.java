package com.example.aicodehelper.controller;

import com.example.aicodehelper.ai.AiCodeHelperService;
import jakarta.annotation.Resource;

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
