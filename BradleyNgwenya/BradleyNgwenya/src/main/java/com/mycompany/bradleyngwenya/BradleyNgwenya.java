/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bradleyngwenya;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BradleyNgwenya {

    private static String registeredUsername = null;
    private static String registeredPassword = null;
    private static String registeredCellNumber = null;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        registerUser();
        loginUser();

        while (true) {
            String[] options = {"Send Message", "Show Recently Sent Messages", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "QuickChat Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                sendMessage();
            } else if (choice == 1) {
                showMessages();
            } else {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }
        }
    }

    private static void registerUser() {
        while (registeredUsername == null) {
            String username = JOptionPane.showInputDialog("Step 1 - Enter your username:");
            if (username == null) System.exit(0); // Cancel
            JOptionPane.showMessageDialog(null, validateUsername(username));
        }

        while (registeredPassword == null) {
            String password = JOptionPane.showInputDialog("Step 2 - Enter your password:");
            if (password == null) System.exit(0);
            JOptionPane.showMessageDialog(null, validatePassword(password));
        }

        while (registeredCellNumber == null) {
            String cell = JOptionPane.showInputDialog("Step 3 - Enter your cell number (with international code):");
            if (cell == null) System.exit(0);
            JOptionPane.showMessageDialog(null, validateCellNumber(cell));
        }
    }

    private static void loginUser() {
        while (!isLoggedIn) {
            String username = JOptionPane.showInputDialog("Login - Enter username:");
            String password = JOptionPane.showInputDialog("Login - Enter password:");
            String response = login(username, password);
            JOptionPane.showMessageDialog(null, response);
            if (response.contains("Login successful")) isLoggedIn = true;
        }
    }

    private static void sendMessage() {
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(null, "You must be logged in to send messages.");
            return;
        }

        String recipient = JOptionPane.showInputDialog("Enter recipient phone number:");
        if (recipient == null) return;

        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
        if (messageText == null) return;

        if (messageText.length() > 250) {
            JOptionPane.showMessageDialog(null, "Message exceeds 250 characters.");
            return;
        }

        String messageID = String.format("%010d", System.currentTimeMillis() % 1000000000);
        Message msg = new Message(messageID, recipient, messageText);

        String[] choices = {"Send", "Discard", "Store"};
        int option = JOptionPane.showOptionDialog(null, "Choose an action:", "Message Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);

        switch (option) {
            case 0 -> msg.sendMessage();
            case 1 -> JOptionPane.showMessageDialog(null, "Message discarded.");
            case 2 -> msg.storeMessage();
        }
    }

    private static void showMessages() {
        if (Message.sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }

        StringBuilder builder = new StringBuilder("Sent Messages:\n\n");
        for (Message msg : Message.sentMessages) {
            builder.append("ID: ").append(msg.messageID).append("\n")
                   .append("Recipient: ").append(msg.recipientCell).append("\n")
                   .append("Message: ").append(msg.messageText).append("\n")
                   .append("Hash: ").append(msg.messageHash).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, builder.toString(), "QuickChat - Sent Messages", JOptionPane.INFORMATION_MESSAGE);
    }

    // === Registration/Login Methods ===

    public static String validateUsername(String username) {
        if (username.length() <= 5 && username.contains("_")) {
            registeredUsername = username;
            return "Awesome! Your username has been successfully captured.";
        }
        return "Oops! Username must be <= 5 characters and include an underscore (_).";
    }

    public static String validatePassword(String password) {
        if (password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isDigit) &&
                password.matches(".*[!@#$%^&*()\\-+=<>?/|{}\\[\\]~].*")) {
            registeredPassword = password;
            return "Great! Your password has been successfully captured.";
        }
        return "Password must be at least 8 characters long, contain a capital letter, a number, and a special character.";
    }

    public static String validateCellNumber(String cellNumber) {
        String pattern = "^\\+\\d{1,3}\\d{10}$";
        if (Pattern.matches(pattern, cellNumber)) {
            registeredCellNumber = cellNumber;
            return "Thanks! Your cell number has been successfully added.";
        }
        return "Cell number format is invalid. Include the international code (e.g., +27...).";
    }

    public static String login(String username, String password) {
        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            return "You're in! Login successful.";
        }
        return "Login failed. Check your credentials.";
    }
}

class Message {
    String messageID;
    String recipientCell;
    String messageText;
    String messageHash;
    static List<Message> sentMessages = new ArrayList<>();

    public Message(String messageID, String recipientCell, String messageText) {
        this.messageID = messageID;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    public String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : "";
        return messageID.substring(0, 2) + ":" + sentMessages.size() + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public void sendMessage() {
        sentMessages.add(this);
        JOptionPane.showMessageDialog(null, "Message sent successfully.");
    }

    public void storeMessage() {
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write("{\n");
            file.write("\"messageID\": \"" + messageID + "\",\n");
            file.write("\"recipientCell\": \"" + recipientCell + "\",\n");
            file.write("\"messageText\": \"" + messageText + "\",\n");
            file.write("\"messageHash\": \"" + messageHash + "\"\n");
            file.write("},\n");
            JOptionPane.showMessageDialog(null, "Message stored in JSON.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message.");
        }
    }
}
class MessageManager {
        private List<String> sentMessages = new ArrayList<>();
        private List<String> disregardedMessages = new ArrayList<>();
        private List<String> storedMessages = new ArrayList<>();
        private Map<String, String> messageHashes = new HashMap<>(); //Hash -> Messages
        private Map<String, String> messageIDs = new HashMap<>();  //ID -> Messages

        public void addMessage(String message, String catergory, String id, String hash){
            switch (catergory.toLowerCase()){
                case "sent":
                      sentMessages.add(message);
                      break;
                case "disregarded":
                      disregardedMessages.add(message);
                      break;
                case "stored":
                      storedMessages.add(message);
                      break;            
            }
            messageIDs.put(id, message);
            messageHashes.put(hash, message);
        }

        public String findLongestMessage(){
             return sentMessages.stream().max(Comparator.comparingInt(String::length)).orElse("No message found");
        }
        public String searchByMessageID(String id){
            return messageIDs.getOrDefault(id, "Message not found");
        }
     
        public List<String> searchMessageByRecipient(String recipient) {
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, String> entry : messageIDs.entrySet()){
                if (entry.getKey().contains(recipient)){
                    result.add(entry.getValue());
                }
            }
             return result;
        }

public boolean deletedMessageByHash(String hash) {
    if (messageHashes.containsKey(hash)){
        messageHashes.remove(hash);
        return true;
    }
    return false;
  }        

  public void displayReport(){
    System.out.println("Sent Messages Report:");
    for (String message : sentMessages) {
        System.out.println("Messages: " + message);
    }
  } 

}