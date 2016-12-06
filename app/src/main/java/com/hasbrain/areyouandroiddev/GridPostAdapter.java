//package com.hasbrain.areyouandroiddev;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.hasbrain.areyouandroiddev.R;
//import com.hasbrain.areyouandroiddev.model.RedditPost;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class GridPostAdapter extends BaseAdapter {
//    List<RedditPost> redditPosts;
//
//    public GridPostAdapter(Activity context, List<RedditPost> redditPosts) {
//
//    }
//
//    static class ViewHolderItem {
//        TextView score;
//        TextView authors;
//        TextView domain;
//        TextView title;
//        TextView comment;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        long id = getItemId(i);
//        return id;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        Object a = getItem(i);
//        return a;
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View listItemView = convertView;
//        PostAdapter.ViewHolderItem viewHolder;
//        if (listItemView == null) {
//            //inflate layout
//            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.post_grid_view, parent, false);
//            viewHolder = new PostAdapter.ViewHolderItem();
//            viewHolder.score = (TextView) listItemView.findViewById(R.id.grid_score);
//            viewHolder.authors = (TextView) listItemView.findViewById(R.id.grid_author);
//            viewHolder.comment = (TextView) listItemView.findViewById(R.id.grid_no_comment);
//            viewHolder.domain = (TextView) listItemView.findViewById(R.id.grid_domain);
//            viewHolder.title = (TextView) listItemView.findViewById(R.id.grid_title);
//            listItemView.setTag(viewHolder);
//
//        } else {
//            viewHolder = (PostAdapter.ViewHolderItem) listItemView.getTag();
//        }
//
//        //Reset
//        viewHolder.score.setText("");
//        viewHolder.authors.setText("");
//        viewHolder.domain.setText("");
//        viewHolder.title.setText("");
//        viewHolder.comment.setText("");
//
//        //Data
//        RedditPost currentRedditPost = (RedditPost) getItem(position);
//        if (currentRedditPost == null)
//            return listItemView;
//
//        String score = (currentRedditPost.getScore() == -1) ? "$$" : "" + currentRedditPost.getScore();
//        String author = (currentRedditPost.getAuthor() == null) ? "No Author" : currentRedditPost.getAuthor();
//        String domain = (currentRedditPost.getDomain() == null) ? "No Domain" : currentRedditPost.getDomain();
//        String title = (currentRedditPost.getTitle() == null) ? "No Tile" : currentRedditPost.getTitle();
//        String comment = (currentRedditPost.getCommentCount() == -1) ? "$$" : "" + currentRedditPost.getCommentCount();
//
//        //UI
//
//        // set score value
//        if (currentRedditPost.getScore() != -1) {
//            viewHolder.score.setText(score);
//        }
//        // set author value
//        if (currentRedditPost.getAuthor() != null) {
//            viewHolder.authors.setText(author);
//        }
//        // set domain value
//        if (currentRedditPost.getDomain() != null) {
//            viewHolder.domain.setText(domain);
//        }
//        // set title value
//        if (currentRedditPost.getTitle() != null) {
//            viewHolder.title.setText(title);
//        }
//        // set comment value
//        if (currentRedditPost.getCommentCount() != -1) {
//            viewHolder.comment.setText(comment);
//        }
//
//
//        //abc
//        return listItemView;
//    }
//}
