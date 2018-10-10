package translate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public class Translate {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Scanner scanner = new Scanner(System.in);
    private final static String LINE = "_________________________________";

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println(LINE);
                System.out.print("Enter word: ");
                System.out.println("Translation: " + translate(scanner.nextLine().trim()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String translate(String word) throws IOException {
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        String yandex = "https://translate.yandex.net/api/v1.5/tr.json/translate?lang=en-ru&key=trnsl.1.1.20181010T120242Z.2b3638d6fb241561.e38aeb2aea1868937d9aae1129557ce64e18a0f6&text=" + word.replaceAll(" ", "%20");
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(yandex);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        ResponseForm responseForm = null;
        while ((line = rd.readLine()) != null) {
            responseForm = objectMapper.readValue(line, ResponseForm.class);
        }
        return requireNonNull(responseForm).getText().get(0);
    }
}
