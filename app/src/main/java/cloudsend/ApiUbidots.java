package cloudsend;

import android.os.AsyncTask;

import com.ubidots.ApiClient;
import com.ubidots.Variable;

public class ApiUbidots extends AsyncTask<Integer, Void, Void> {
    private final String API_KEY = "229452d93e9cd774aed5b92bafd42dc3c56b5ef4";
    private final String VARIABLE_ID = "55239546762542544e244871";

    @Override
    protected Void doInBackground(Integer... params) {
        ApiClient apiClient = new ApiClient(API_KEY);
        Variable batteryLevel = apiClient.getVariable(VARIABLE_ID);

        batteryLevel.saveValue(params[0]);
        return null;
    }
}
