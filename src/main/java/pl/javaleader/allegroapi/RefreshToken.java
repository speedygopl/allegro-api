package pl.javaleader.allegroapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.log.SystemLogHandler;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class RefreshToken {
    public static void main(String[] args) throws IOException {
        //utworzenie mappera json
        ObjectMapper objectMapper = new ObjectMapper();
        //utworzenie obiektu tokena
        Token token = objectMapper.readValue(new File("token.txt"), Token.class);


        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "basic Zjk3ODQ5MDRlMWQyNGRhZTg3NmZjOGE2ZDM0Mzg0OTQ6SlJQNzYyQU10ejJzRElaUUlKUWdnQkU4TUc5TUQwdEl0eEhhTHVISEtVdmtXY0l4ZHRTUU4ycUpFenJVT0prcA==");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://allegro.pl.allegrosandbox.pl/auth/oauth/token?grant_type=refresh_token&refresh_token="+token.getRefresh_token()+"&redirect_uri=http://localhost:8080", HttpMethod.POST, requestEntity, String.class);
        String response = responseEntity.getBody();


        //utworzenie streamu dla System.Out.Println do zapisywania w pliku
        //utworzenie zmiennej do wyświetlania na konsoli
        PrintStream file = new PrintStream(new File("token.txt"));
        PrintStream console = System.out;

        //stream odpowiedzi serwera do pliku
        System.setOut(file);
        System.out.println(response);

        //przestawienie streamu na konsolę i wyświetlenie informacji o obiekcie token
        System.setOut(console);
        token = objectMapper.readValue(new File("token.txt"), Token.class);
        System.out.println(token.toString());



    }
}
