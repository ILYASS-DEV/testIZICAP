package com.example.test_izicap.Service;

import com.example.test_izicap.Entity.ChatGPTResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    private static final String FILE_NAME = "chatGPT-response.csv";
    private static final String[] FILE_HEADER = {"id", "text", "logprobs"};

    public void writeToFile(ChatGPTResponse response) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(FILE_NAME),
                CSVFormat.DEFAULT.withHeader(FILE_HEADER))) {
            for (ChatGPTResponse.Choice choice : response.getChoices()) {
                printer.printRecord(response.getId(), choice.getText(), choice.getLogprobs());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
