package com.capg.work;

import java.io.*;
import java.util.regex.Matcher;    
import java.util.regex.Pattern;
import java.util.Scanner;  

class Header{
    private String from;
    private String to;
    
    public Header(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
}
class Email{
    private Header header;
    private String body;
    private String greetings;
    
    public Email(Header header, String body, String greetings) {
        this.header = header;
        this.body = body;
        this.greetings = greetings;
    }
    public Header getHeader() {
        return header;
    }
    public void setHeader(Header header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getGreetings() {
        return greetings;
    }
    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }
}
class EmailOperations{
    public int emailVerify(Email e) {
        String emailRegex = "^[a-zA-Z]+" + "@" + "[a-zA-Z]+\\.[a-zA-Z]{2,7}$";
		
		//	String regex ="^[a-zA-z]"+"[a-zA-z]+" + "[\s][a-zA-z]*['-]*"  + "[a-zA-z]+$"; for reference
		
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher1 = pattern.matcher(e.getHeader().getFrom());
        Matcher matcher2 = pattern.matcher(e.getHeader().getTo());
        boolean b1 = matcher1.matches(); 
        boolean b2 = matcher2.matches();
        
        if(b1 && b2) {
            return 2;
        }
        if(b1 || b2) {
            return 1;
        }
        return 0;
    }
    
    public String bodyEncryption(Email e) {
        //convert the body to characters array
        char messageBody[] = e.getBody().toCharArray();
        final int SHIFT_BY = 3;
        
        //code to apply ceaser cypher
        for(int i = 0; i < messageBody.length; i++) {
            if(Character.isAlphabetic(messageBody[i])) {
                //its alphabet so apply shifting
                if(Character.isUpperCase(messageBody[i])) {
                    //means ASCII code is from 65 to 90
                    messageBody[i] = (char)(messageBody[i] + SHIFT_BY);
                    if(messageBody[i] > 90) {
                        //reset values to the starting alphabet
                        messageBody[i] = (char)(65 + (messageBody[i] % 90));
                    }
                }else {
                    //means ASCII code is from 97 to 122
                    //means ASCII code is from 65 to 90
                    messageBody[i] = (char)(messageBody[i] + SHIFT_BY);
                    if(messageBody[i] > 122) {
                        //reset values to the starting alphabet
                        messageBody[i] = (char)(97 + (messageBody[i] % 122));
                    }
                }
            }
        }
        
        return new String(messageBody);
    }
    
    public String greetingMessage(Email e) {
        String split[] = e.getHeader().getFrom().split("@");
        String name = split[0];
        String greet = e.getGreetings()+" " + name;
        return greet;        
    }
}
public class Source{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter from and to email id ");
        String from = sc.nextLine();
        String to = sc.nextLine();
        
        Header h1 = new Header(from,to);
        Email e2 = new Email(h1,"Hi There Hows you","Regards");
        EmailOperations E1 = new EmailOperations();
        
        System.out.println(E1.emailVerify(e2));
        System.out.println(E1.bodyEncryption(e2));
        System.out.println(E1.greetingMessage(e2));
        
        sc.close();
    }
}