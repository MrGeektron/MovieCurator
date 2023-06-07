import org.json.JSONArray;
import org.json.JSONObject;

public class TMDbAPIConfiguration {
    String baseURL;
    String secureBaseURL;
    String[] backdropSizes;
    String[] logoSizes;
    String[] posterSizes;
    String[] profileSizes;
    String[] stillSizes;
    String[] changeKeys;


    public TMDbAPIConfiguration(String configString) {
        JSONObject jsonObject = new JSONObject(configString);
        JSONObject imagesObject = (JSONObject) jsonObject.get("images");
        if(imagesObject.get("base_url") instanceof String) {
            baseURL = (String) imagesObject.get("base_url");
        }
        if(imagesObject.get("secure_base_url") instanceof String) {
            secureBaseURL = (String) imagesObject.get("secure_base_url");
        }
        if(imagesObject.get("backdrop_sizes") instanceof JSONArray) {
            backdropSizes = convertJSONArray( (JSONArray) imagesObject.get("backdrop_sizes"));
        }
        if(imagesObject.get("logo_sizes") instanceof JSONArray) {
            logoSizes = convertJSONArray( (JSONArray) imagesObject.get("logo_sizes"));
        }
        if(imagesObject.get("poster_sizes") instanceof JSONArray) {
            posterSizes = convertJSONArray( (JSONArray) imagesObject.get("poster_sizes"));
        }
        if(imagesObject.get("profile_sizes") instanceof JSONArray) {
            profileSizes = convertJSONArray( (JSONArray) imagesObject.get("profile_sizes"));
        }
        if(imagesObject.get("still_sizes") instanceof JSONArray) {
            stillSizes = convertJSONArray( (JSONArray) imagesObject.get("still_sizes"));
        }
        if(jsonObject.get("change_keys") instanceof JSONArray) {
            changeKeys = convertJSONArray( (JSONArray) jsonObject.get("change_keys"));
        }
    }

    public String[] convertJSONArray(JSONArray array) {
        String[] stringArray = new String[array.length()];
        for(int i = 0; i < array.length(); i++) {
            stringArray[i] = (String) array.get(i);
        }
        return stringArray;
    }
}
