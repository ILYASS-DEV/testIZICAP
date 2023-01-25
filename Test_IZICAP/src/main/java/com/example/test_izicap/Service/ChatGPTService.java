package com.example.test_izicap.Service;

import com.example.test_izicap.Entity.ChatGPTResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChatGPTService {
    private String openaiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private String openaiKey = "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";
    private String model = "davinci-codex";


    private RestTemplate restTemplate;

    public ChatGPTResponse getResponse(String prompt) throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiKey);

        JSONObject body = new JSONObject();
        body.put("prompt", prompt);
        body.put("model", model);
        body.put("max_tokens", 4000);
        body.put("temperature", 1.0);

        // request
        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);
        ResponseEntity<ChatGPTResponse> response = restTemplate.exchange(openaiUrl, HttpMethod.POST, request, ChatGPTResponse.class);
        return response.getBody();
    }
}
