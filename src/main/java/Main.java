import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args)  {
        try {
            int id = Integer.parseInt(args[0]);
            String stringForResponce = getJsonString(id);
            String resultString = getResponce(stringForResponce);
            System.out.println(resultString);
        }

        catch (NumberFormatException e){
            System.out.println("Введено не верный аргумент");
        }
        catch (Exception e){
            System.out.println("User not found!");
        }
    }

    public static String getJsonString(int id) throws IOException{
        URL url = new URL("https://reqres.in/api/users/" +id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String stringForRsponce = bufferedReader.readLine();
        return stringForRsponce;

    }
    public static String getResponce(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person json = mapper.readValue(response, Person.class);
        String resultString = json.getDataPerson().getFirstName() + " " + json.getDataPerson().getLastName();
        return resultString;
    }
}
