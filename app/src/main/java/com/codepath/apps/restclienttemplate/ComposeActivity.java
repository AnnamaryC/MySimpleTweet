package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;

public class ComposeActivity extends AppCompatActivity {

    Button button = (Button) findViewById(R.id.tweetbutton);
    EditText editText = (EditText) findViewById(R.id.composeTweet);
    private TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                client.sendTweet(editText.getText(), new JsonHttpResponseHandler());
            }
        });
    }



}
