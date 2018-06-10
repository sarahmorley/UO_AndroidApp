package com.example.sarahmorley.uo;
import android.os.AsyncTask;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpPostRequest extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... params){
        String stringUrl = params[0];
        String userName = params[1];
        String passWord = params[2];
        String error = "";
        try {

            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("username", userName)
                    .add("password", passWord)
                    .build();

            Request request = new Request.Builder()
                    .url(stringUrl)
                    .post(formBody)
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response ServerResponse = client.newCall(request).execute();
            String response = String.valueOf(ServerResponse.code());
            return response;

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
