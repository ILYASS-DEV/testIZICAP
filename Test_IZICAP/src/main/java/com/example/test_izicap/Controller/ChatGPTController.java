package com.example.test_izicap.Controller;

import com.example.test_izicap.Entity.ChatGPTResponse;
import com.example.test_izicap.Service.ChatGPTService;
import com.example.test_izicap.Service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/API")
public class ChatGPTController {
    @Autowired
    private ChatGPTService chatGPTService;

    @Autowired
    private CsvService csvService;

    @GetMapping("/response")
    @ResponseBody
    public ChatGPTResponse getResponse(@RequestParam("prompt") String prompt) throws UnsupportedEncodingException {
        ChatGPTResponse response = chatGPTService.getResponse(prompt);
        csvService.writeToFile(response);
        return response;
    }
}


