package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.Switch;

public class HomeActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().hide();

        // Web View
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://192.168.3.1:8000"); // URL for raspberry pi stream

        WebSettings webSettings = webView.getSettings();

        // BROWSER SETTINGS
        webSettings.setJavaScriptEnabled(true);

        // Switch
//        Switch cameraSwitch = (Switch) findViewById(R.id.cameraSwitch);
//        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    // activate weapon detector
//                } else {
//                    // deactivate weapon detector
//                }
//            }
//        });
    }
}