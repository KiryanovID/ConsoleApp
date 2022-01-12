import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args)  {
        int id = Integer.parseInt(args[0]);
        try {
            System.out.println(getResponce(getJsonString(id)));
        }
        catch (Exception e){
            System.out.println("User not found!");
        }
    }

    public static String getJsonString(int id) throws IOException{
        URL url = new URL("https://reqres.in/api/users/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        return bufferedReader.readLine();

    }
    public static String getResponce(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Json json = mapper.readValue(response, Json.class);
        return json.getData().getFirst_name() + " " + json.getData().getLast_name();
    }
}
