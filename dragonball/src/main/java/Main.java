import model.Response;
import model.Character;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.xml.XmlMapper;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    static void readJSON() {
        ObjectMapper mapper = new ObjectMapper();
        Response r = mapper.readValue(new File("data/response.json"), Response.class);
        r.getCharacters().forEach(System.out::println);

    }

    static void readXML() {
        XmlMapper mapper = new XmlMapper();
        Response r = mapper.readValue(new File("data/response.xml"), Response.class);
        r.getCharacters().forEach(System.out::println);

    }

    static void readAPIRest() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://dragonball-api.com/api/characters?limit=58"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            Response r = mapper.readValue(response.body(), Response.class);
            r.getCharacters().forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void main() throws Exception{
        readJSON();
        //readAPIRest();
        //readXML();

    }
}
