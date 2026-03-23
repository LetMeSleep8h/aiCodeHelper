package com.example.aicodehelper.ai;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AiCodeHelperServiceTest {
    @Resource
    private AiCodeHelperService aiCodeHelperService;
    @Resource
    private McpToolProvider mcpToolProvider;
    @Test
            void chat()

    {
        String result = aiCodeHelperService.chat("你好，我是小彭");
        System.out.println(result);
    }

//    @Test
//    void chatForReport() {
//        String userMessage = "你好，我是小彭，学习编程两个月，请帮我制定学习计划";
//        AiCodeHelperService.Report report = aiCodeHelperService.chatForReport(userMessage);
//        System.out.println(report);
//    }
    @Test
    void chatWithRag()
    {
        Result<String> result = aiCodeHelperService.chatWithRag("怎么学习java？");
        System.out.println(result.sources());
        System.out.println(result.content());

    }
    @Test
    void chatWithMcp()
    {
        System.out.println(aiCodeHelperService.chat("什么是面试鸭刷题网站？"));
    }
}