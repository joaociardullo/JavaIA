package com.devjoao.springai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@Slf4j
public class SpringIAController {
    private final OpenAiChatClient chatClient;

    public SpringIAController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @GetMapping("/ask")
    public ResponseEntity<String> ask(@RequestParam(value = "meesage",
            defaultValue = "Quais sao os livros best seller")
                                      String messagem) {
        log.info("Message: {} ", messagem);
        return ResponseEntity.ok(chatClient.call(messagem));
    }
}
