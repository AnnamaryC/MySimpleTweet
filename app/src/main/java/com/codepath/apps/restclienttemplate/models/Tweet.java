package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

/**
 * Created by anitac on 7/3/18.
 */
@Parcel
public class Tweet {
    //listing atributes
    public String body;
    public long uid; //database id for the tweet
    public User user;
    public String createdAt;

    public Tweet() {
        //empty on purpose
    }

    //deserialize the JSON
    public static Tweet fromJSON(JSONObject jsonObject)throws JSONException{
        Tweet tweet = new Tweet();

        //extract values from Json
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        return tweet;
    }
}
