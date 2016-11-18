package com.hasbrain.areyouandroiddev;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hasbrain.areyouandroiddev.model.RedditPost;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends ArrayAdapter<RedditPost> {

    public PostAdapter(Activity context, List<RedditPost> redditPosts){
        super(context,0,redditPosts);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView =convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_post_list,parent, false);
        }
        RedditPost currentRedditPost = getItem(position);
        TextView score =(TextView) listItemView.findViewById(R.id.post_score);
        score.setText(""+currentRedditPost.getScore());
        TextView authors = (TextView) listItemView.findViewById(R.id.author);
        authors.setText(""+currentRedditPost.getAuthor());
        TextView domain = (TextView) listItemView.findViewById(R.id.domain);
        domain.setText(""+currentRedditPost.getDomain());
        TextView title = (TextView) listItemView.findViewById(R.id.post_title);
        title.setText(""+currentRedditPost.getTitle());
        TextView comment = (TextView) listItemView.findViewById(R.id.no_comment);
        comment.setText(""+currentRedditPost.getCommentCount());


        return listItemView;
    }
}
