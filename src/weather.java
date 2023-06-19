
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class weather {
    public static void main(String[] args) {
        String urlAdress =" http://api.openweathermap.org/data/2.5/weather?q=penza&mode=json&units=metric&cnt=7&appid=3ce9ea94136b1a3424e7f503c5355391";
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = br.readLine()) != null){
                content.append(line + "\n");

            }

            br.close();

        }catch (Exception e){
            System.out.println("kapibara vret!!!");
        }

        System.out.println(content);
        if(!content.isEmpty()){
            JSONObject obj = new JSONObject();
            
            System.out.println("Температура: " + obj.getJSONObject("main").getDouble("temp"));
            System.out.println("Максимум: " + obj.getJSONObject("main").getDouble("temp_max"));
            System.out.println("Минимум: " + obj.getJSONObject("main").getDouble("temp_min"));
            System.out.println("Давлениеи: " + obj.getJSONObject("main").getDouble("pressure"));
        }
    }
}
