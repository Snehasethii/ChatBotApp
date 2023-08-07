package main;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ChatBotMain
{
    private Map<String, String> responses;
    public ChatBotMain() {
        responses = new HashMap<>();
        //add all your questions and answers here
        responses.put("hello", "Hi there!");
        responses.put("how are you?", "I'm doing well, thanks for asking!");
        responses.put("what's your name?", "My name is Chatbot.");
        responses.put("what are your hobbies?", "Coding, Writing, Reading are my hobbies");
    }

    public String respond(String input) {
        String response = "";
        // check whether question is valid or not
        // response = responses.getOrDefault(input, "I don't understand your question.");

        if (responses.containsKey(input)){
            response = responses.get(input);
        }else{
            response="I don't know your question.";
        }
        return response;
    }

    public static void main(String[] args) {
        ChatBotMain chatBot = new ChatBotMain();
        // enter name for bot
        JFrame frame = new JFrame("Chatbot");
        JTextField inputField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(outputArea, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        inputField.addActionListener(e -> {

            String input = inputField.getText();
            String response = chatBot.respond(input);
            System.out.println("response from chatbot is : "+response);
            
            outputArea.append(input + "\n");
            outputArea.append(response + "\n");
            inputField.setText("");
        });
    }
}


