package com.example.harpreet.vasdapunjab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Feedback extends Fragment {


    WebView webView ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback,container,false);

        webView = (WebView) view.findViewById(R.id.webviewFeedBack);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSckeR1ob0ogOYYGyRpkgF8vXMJWiYd8am8IFib8td9P_ks-4w/viewform?usp=sf_link");
        return view;
    }
}
