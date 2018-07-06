package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by anitac on 7/3/18.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{//recycler adapter

    private List<Tweet> mTweets;
    //pass in the tweet aray in the constructor
    public TweetAdapter(List<Tweet> tweets){
        mTweets = tweets;
    }
    Context context;

    //for each row, inflate the layout and cache references into viewholder
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet,parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

    //bind values based on position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //which tweet option we're going to show
        //get data according to position
        Tweet tweet = mTweets.get(position);

        //populate the views according to this data
        holder.username.setText(tweet.user.name);
        holder.actualTweet.setText(tweet.body);
        holder.actualDate.setText(tweet.createdAt);

        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.profilePic);
    }

    //to see the tweets
    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    //create viewholder class
    public static class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView profilePic;
            public TextView username;
            public  TextView actualTweet;
            public TextView actualDate;

            public ViewHolder(View itemView){
                super(itemView);

                //perform findviewby id
                profilePic = itemView.findViewById(R.id.profileImage);
                username = itemView.findViewById(R.id.twitterHandle);
                actualTweet = itemView.findViewById(R.id.tvBody);
                actualDate = itemView.findViewById(R.id.dateTime);
            }
    }

    

}
