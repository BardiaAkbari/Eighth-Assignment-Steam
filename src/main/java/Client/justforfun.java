package Client;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

public class justforfun {
    public static void main(String[] args) throws IOException {
        Client client = new Client("slslsl", "qqqqq", "rrrrr", "1111111");
        ObjectMapper objectMapper = new ObjectMapper();
        String kir = objectMapper.writeValueAsString(client);
        JSONObject jsonObject = new JSONObject(kir);
        System.out.println(jsonObject.getString("iD"));

    }
}
