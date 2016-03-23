package eu.battlekart;

import android.app.Activity;
import android.os.Bundle;
import com.frenchcomputerguy.rest.PostRequest;
import com.frenchcomputerguy.rest.Request;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Test", "This is a test");
        Request post = new PostRequest("http://httpbin.org/post", parameters);
        try {
            post.getResponse().getJSONObject().getJSONObject("headers").getString("Test");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
