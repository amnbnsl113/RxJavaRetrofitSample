package mvp.sample.com.rxjavaretrofitsample.network.retrofit;


import android.util.Log;

import java.util.HashMap;

/**
 * @author amanbansal
 * @version 1.0
 * @since 2/1/17
 */
public class RetrofitFieldMap {
    private HashMap<String, Object> mHashMap = new HashMap<>();

    RetrofitFieldMap(HashMap<String, Object> map) {
        mHashMap = map;
    }

    public HashMap<String, Object> getParams() {
        if (mHashMap == null) {
            mHashMap = new HashMap<>();
        }

        /*mHashMap.put(UcExchangeConstants.API_ENDPOINTS.PARAM_API_KEY, UcExchangeConstants.apiKey);
        SharedPreferenceManager sharedPreferenceManager = MyApplication.getInstance().getSharedPreference();
        String userId = sharedPreferenceManager.getString(UcExchangeConstants.API_ENDPOINTS.USER_ID);
        if (userId != null && !userId.isEmpty()) {
            mHashMap.put(UcExchangeConstants.API_ENDPOINTS.API_USER_ID, userId);
        }

        String accessToken = sharedPreferenceManager.getString(UcExchangeConstants.API_ENDPOINTS.ACCESS_TOKEN);
        if (accessToken != null && !accessToken.isEmpty()) {
            mHashMap.put(UcExchangeConstants.API_ENDPOINTS.API_ACCESS_TOKEN, accessToken);
        }
*/
       /* mHashMap.put("app", "android");
        mHashMap.put("version_code", BuildConfig.VERSION_CODE);
        mHashMap.put("version", BuildConfig.VERSION_NAME);
        mHashMap.put("package_name", BuildConfig.APPLICATION_ID);
        mHashMap.put("package_name", BuildConfig.APPLICATION_ID);
        mHashMap.put("package_name", BuildConfig.APPLICATION_ID);*/
        Log.e("Request params=:", mHashMap.toString());
        return mHashMap;
    }
}
