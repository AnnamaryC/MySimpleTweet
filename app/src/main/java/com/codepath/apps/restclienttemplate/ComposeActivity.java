package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class ComposeActivity extends AppCompatActivity {

    Button button ;
    EditText editText;
    private final int REQUEST_CODE = 20;
    private TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) { ///****NOT FULLY IMPLEMENTED
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        button = (Button) findViewById(R.id.tweetbutton);
        editText = (EditText) findViewById(R.id.composeTweet);
        client = TwitterApp.getRestClient(this);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                client.sendTweet(editText.getText().toString(), new JsonHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            super.onSuccess(statusCode, headers, response);
                            Tweet tweet = Tweet.fromJSON(response);
                            Intent intent = new Intent();
                            intent.putExtra("atweet", Parcels.wrap(tweet));
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });
            }
        });
    }



}
