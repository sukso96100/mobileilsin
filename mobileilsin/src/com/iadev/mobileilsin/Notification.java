package com.iadev.mobileilsin;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iadev.bcilsin.R;
 
public class Notification extends Activity{
     
    private WebView mWebView;
     
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
         
        setLayout();
         
        // 웹뷰에서 자바스크립트실행가능
        mWebView.getSettings().setJavaScriptEnabled(true); 
        // 구글홈페이지 지정
        mWebView.loadUrl("http://bcilsin.ms.kr/?act=news.main&comm=com");
        // WebViewClient 지정
        mWebView.setWebViewClient(new WebViewClientClass());  
         
    }
     
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) { 
            mWebView.goBack(); 
            return true; 
        } 
        return super.onKeyDown(keyCode, event);
    }
     
    private class WebViewClientClass extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
     
    /*
     * Layout
     */
    private void setLayout(){
        mWebView = (WebView) findViewById(R.id.webView1);
    }
}