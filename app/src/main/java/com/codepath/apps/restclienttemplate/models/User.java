package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by anitac on 7/3/18.
 */

public class User {
    //list atributes
    public String name;
    public long uid;
    public String screenName;
    public  String profileImageUrl;

    //deserialize JSON
    public static User fromJSON(JSONObject object)throws JSONException{
        User user = new User();

        //extract and fill values
        user.name = object.getString("name");
        user.uid = object.getLong("uid");
        user.screenName = object.getString("screen_name");
        user.profileImageUrl = object.getString("profile_image_url");
        return  user;
    }
}
