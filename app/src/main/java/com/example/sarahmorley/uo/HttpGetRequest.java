package com.example.sarahmorley.uo;
import android.os.AsyncTask;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpGetRequest extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String stringUrl = params[0];
        String error = "";
        try {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(stringUrl)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            return response.toString();

        }
        catch (Exception ex){
            error = ex.toString();
            return error.toString();
        }
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }
}
