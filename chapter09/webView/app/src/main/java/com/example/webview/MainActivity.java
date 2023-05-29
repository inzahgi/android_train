package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取布局管理器中添加的WebView控件
        WebView webview=findViewById(R.id.webView);

        //WebChromeClient webChromeClient = new WebChromeClient();
        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String  url) {
//                view.loadUrl(url); // 根据传入的参数再去加载新的网页
//                return true; // 表示当前WebView可以处理打开新网页的请求，不用借助                系统浏览器
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
                //return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webview.loadUrl("https://www.baidu.com/"); // 指定要加载的网页
    }
}