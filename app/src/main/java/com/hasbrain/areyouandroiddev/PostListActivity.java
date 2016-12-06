package com.hasbrain.areyouandroiddev;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.annotations.SerializedName;
import com.hasbrain.areyouandroiddev.api.RedditPostAPI;
import com.hasbrain.areyouandroiddev.datastore.FeedDataStore;
import com.hasbrain.areyouandroiddev.datastore.FileBasedFeedDataStore;
import com.hasbrain.areyouandroiddev.model.RedditPost;
import com.hasbrain.areyouandroiddev.model.RedditPostConverter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListActivity extends AppCompatActivity {
    private String TAG = "PostListActivity";
    private boolean oriented = false;
    public static final String DATA_JSON_FILE_NAME = "data.json";
    private FeedDataStore feedDataStore;
    List<RedditPost> retrofitPost;
    @SerializedName("response")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
//        // Write message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello World!");
//        //Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //This method is called once with the initial value and again
//                // whenever data at this loation is updated
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value!", databaseError.toException());
//            }
//        });


//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(RedditPost.class, new RedditPostConverter());
//        Gson gson = gsonBuilder.create();
//        InputStream is = null;
//        try {
//            is = getAssets().open(DATA_JSON_FILE_NAME);
//            feedDataStore = new FileBasedFeedDataStore(gson, is);
//            feedDataStore.getPostList(new FeedDataStore.OnRedditPostsRetrievedListener() {
//                @Override
//                public void onRedditPostsRetrieved(final List<RedditPost> postList, Exception ex) {
//                    displayPostList(postList);
//
//
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        RedditPostAPI.PostApiClass.getIntances().getPost().enqueue(new Callback<List<RedditPost>>() {
            @Override
            public void onResponse(Call<List<RedditPost>> call, Response<List<RedditPost>> response) {
                if (response.isSuccessful()) {

                    retrofitPost = response.body();
                    displayPostList(retrofitPost);
                } else
                    Toast.makeText(PostListActivity.this, "Response Error: ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<RedditPost>> call, Throwable t) {
                Toast.makeText(PostListActivity.this, "Error: " + t, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            oriented = true;
        }
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            oriented = false;
        }

    }

    protected void displayPostList(final List<RedditPost> postList) {
        //TODO: Display post list
        if (oriented == false) {
            PostAdapter postAdapter = new PostAdapter(PostListActivity.this, postList);
            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(postAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent post_view = new Intent(PostListActivity.this, PostViewActivity.class);
                    RedditPost item = postList.get(i);
                    if (item.getUrl() != null) {
                        post_view.putExtra("Past Reddit Object", item);
                        startActivity(post_view);
                    } else
                        Toast.makeText(PostListActivity.this, "URL Error!!!", Toast.LENGTH_LONG).show();
                }
            });
        }
//        if(oriented == true){
//            GridPostAdapter gridAdapter = new GridPostAdapter(PostListActivity.this, postList);
//            GridView gridView = (GridView) findViewById(R.id.grid_view);
//            gridView.setAdapter(gridAdapter);
//            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Intent post_view = new Intent(PostListActivity.this, PostViewActivity.class);
//                    RedditPost item = postList.get(i);
//                    post_view.putExtra("Past Reddit Object", item);
//                    startActivity(post_view);
//
//                }
//            });
//        }


    }


    protected int getLayoutResource() {
        return R.layout.activity_numbers;
    }
}
