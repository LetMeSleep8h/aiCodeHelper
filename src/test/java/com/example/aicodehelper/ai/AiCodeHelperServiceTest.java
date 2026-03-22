package com.example.aicodehelper.ai;

import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AiCodeHelperServiceTest {
    @Resource
    private AiCodeHelperService aiCodeHelperService;
    @Test
            void chat()

    {
        String result = aiCodeHelperService.chat("你好，我是小彭");
        System.out.println(result);
    }
}