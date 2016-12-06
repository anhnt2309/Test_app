package com.hasbrain.areyouandroiddev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hasbrain.areyouandroiddev.R;
import com.hasbrain.areyouandroiddev.model.RedditPost;

public class PostViewActivity extends AppCompatActivity {
 private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);

        Intent getBundle = getIntent();
        RedditPost object = (RedditPost) getBundle.getExtras().getSerializable("Past Reddit Object");
        String webUrl = object.getUrl().toString();
        webView = (WebView) findViewById(R.id.activity_post_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(webUrl);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack() == true){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
