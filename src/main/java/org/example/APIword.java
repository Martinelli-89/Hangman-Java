package org.example;

import java.net.*;
import java.io.*;
import java.io.IOException;
public class APIword{

    static String apiCall () throws IOException {

        String response="";
        URL fetchWord = new URL("https://random-word-api.herokuapp.com/word");
        URLConnection yc = fetchWord.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            response = (inputLine);
        in.close();
        return response.substring(2,response.length()-2);
    }
}
