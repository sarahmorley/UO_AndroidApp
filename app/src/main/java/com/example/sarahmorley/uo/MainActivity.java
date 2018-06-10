package com.example.sarahmorley.uo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view)
    {
        EditText username = (EditText)findViewById(R.id.userNameTxtBx);
        EditText password = (EditText)findViewById(R.id.passwordTxtBx);

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent intent = new Intent(this, MyTabActivity.class);
            startActivity(intent);

        }else {
            setContentView(R.layout.activity_main);
            TextView RegLogTextView = (TextView) findViewById(R.id.RegLogTextView);
            RegLogTextView.setText(("You have not logged in. Please Try Again"));
        }
    }

    public void Register(View view)
    {
        EditText username = (EditText)findViewById(R.id.userNameTxtBx);
        EditText password = (EditText)findViewById(R.id.passwordTxtBx);

        //The endpoint URL
        String regUrl = "https://uo-db-api.herokuapp.com/uo/users";
        String result;
        Integer res;

        // Instantiate new instance of HttpPostRequest Class
        HttpPostRequest postRequest = new HttpPostRequest();

        try{
            result = postRequest.execute(regUrl, username.getText().toString(), password.getText().toString()).get();
            res = Integer.parseInt(result);
            if(res == 201)
            {
                setContentView(R.layout.activity_main);
                TextView RegLogTextView = (TextView)findViewById(R.id.RegLogTextView);
                RegLogTextView.setText(("You have successfully Registered"));
            }
            else
            {
                setContentView(R.layout.activity_main);
                TextView RegLogTextView = (TextView)findViewById(R.id.RegLogTextView);
                RegLogTextView.setText((result));
            }
        }
        catch(Exception ex) {
            result = ex.toString();
        }

    }
}
