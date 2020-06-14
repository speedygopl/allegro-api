package pl.javaleader.allegroapi;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class Base64 {
    public static void main(String[] args) throws UnsupportedEncodingException {


        String clientId = "f9784904e1d24dae876fc8a6d3438494";
        String clientSecret = "JRP762AMtz2sDIZQIJQggBE8MG9MD0tItxHaLuHHKUvkWcIxdtSQN2qJEzrUOJkp";
        String encodedData = DatatypeConverter.printBase64Binary((clientId + ":" + clientSecret).getBytes("UTF-8"));
        String authorizationHeaderString = "Authorization: Basic " + encodedData;
        System.out.println(authorizationHeaderString);
    }
    }
