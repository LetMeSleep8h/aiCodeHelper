package com.example.aicodehelper;

import com.example.aicodehelper.ai.AiCodeHelper;
import com.example.aicodehelper.ai.AiCodeHelperService;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperApplicationTests {
    @Resource
    private AiCodeHelper aiCodeHelper;
    @Autowired
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        aiCodeHelper.chat("我是小彭");
    }

    @Test
    void chatWithMessage() {
        UserMessage userMessage = UserMessage.from(
        ImageContent.from("https://www.honstech.cc/uploads/202108/20/thumb_500_300_202108200850216963.jpg"),
                TextContent.from("描述图片")
        );
        aiCodeHelper.chatWithMessage(userMessage);
    }
    @Test
    void chatWithMemory() {
    String result = aiCodeHelperService.chat("你好，我是彭");
    System.out.println(result);
    result =aiCodeHelperService.chat("你好，我是谁来着");
    System.out.println(result);
    }
}
