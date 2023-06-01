package Client;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class justforfun {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\SteamDownloads\\99ec6105-9d91-484d-b0e6-2995c32bd43d\\323190.txt");
        if (file.exists()) {
            System.out.println("kir");
        }
    }
}
