package com.example.sarahmorley.uo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyTabActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);
        //The endpoint URL
        String myUrl = "https://uo-db-api.herokuapp.com/uo/health";
        //String to place our result in
        String result ="";
        //Instantiate new instance of HttpGetRequest class
        HttpGetRequest getRequest = new HttpGetRequest();

        try{
            result = getRequest.execute(myUrl).get();
            setContentView(R.layout.activity_my_tab);
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText((result));
        }
        catch(Exception ex) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(("Problem"));
        }

    }


}
