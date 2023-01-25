package com.example.test_izicap.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class ChatGPTResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("choices")
    private List<Choice> choices;
    @Data
    public static class Choice {
        @JsonProperty("text")
        private String text;
        @JsonProperty("logprobs")
        private double logprobs;
    }
}
