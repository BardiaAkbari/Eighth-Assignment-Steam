package Client;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

public class justforfun {
    public static void main(String[] args) throws IOException {
//        JSONObject jsonObject = new JSONObject("{\"number\" : \"6\" , \"gameName\" :" + "rrrr" + "\", \"clientID\" : \"" + "tttt " + "\"}");
        System.out.println("{\"number\" : \"6\" , \"gameName\" :" + "rrrr" + "\", \"clientID\" : \"" + "tttt " + "\"}");
    }
}
