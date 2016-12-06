package com.hasbrain.areyouandroiddev;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hasbrain.areyouandroiddev.model.RedditPost;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class PostAdapter extends ArrayAdapter<RedditPost> {

    public PostAdapter(Activity context, List<RedditPost> redditPosts) {
        super(context, 0, redditPosts);
    }

    static class ViewHolderItem {
        TextView score;
        TextView authors;
        TextView domain;
        TextView title;
        TextView comment;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        ViewHolderItem viewHolder;
        if (listItemView == null) {
            //inflate layout
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_post_list, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.score = (TextView) listItemView.findViewById(R.id.post_score);
            viewHolder.authors = (TextView) listItemView.findViewById(R.id.author);
            viewHolder.comment = (TextView) listItemView.findViewById(R.id.no_comment);
            viewHolder.domain = (TextView) listItemView.findViewById(R.id.domain);
            viewHolder.title = (TextView) listItemView.findViewById(R.id.post_title);
            listItemView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolderItem) listItemView.getTag();
        }

        //Reset
        viewHolder.score.setText("");
        viewHolder.authors.setText("");
        viewHolder.domain.setText("");
        viewHolder.title.setText("");
        viewHolder.comment.setText("");

        //Data
        RedditPost currentRedditPost = getItem(position);
        if (currentRedditPost == null)
            return listItemView;

        String score = (currentRedditPost.getScore() == -1) ? "$$" : "" + currentRedditPost.getScore();
        String author = (currentRedditPost.getAuthor() == null) ? "No Author" : currentRedditPost.getAuthor();
        String domain = (currentRedditPost.getDomain() == null) ? "No Domain" : currentRedditPost.getDomain();
        String title = (currentRedditPost.getTitle() == null) ? "No Tile" : currentRedditPost.getTitle();
        String comment = (currentRedditPost.getCommentCount() == -1) ? "$$" : "" + currentRedditPost.getCommentCount();

        //UI

        // set score value
        if (currentRedditPost.getScore() != -1) {
            viewHolder.score.setText(score);
        }
        // set author value
        if (currentRedditPost.getAuthor() != null) {
            viewHolder.authors.setText(author);
        }
        // set domain value
        if (currentRedditPost.getDomain() != null) {
            viewHolder.domain.setText(domain);
        }
        // set title value
        if (currentRedditPost.getTitle() != null) {
            viewHolder.title.setText(title);
        }
        // set comment value
        if (currentRedditPost.getCommentCount() != -1) {
            viewHolder.comment.setText(comment);
        }


        //abc
        return listItemView;
    }
}
