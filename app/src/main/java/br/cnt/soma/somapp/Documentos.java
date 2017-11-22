package br.cnt.soma.somapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Documentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentos);

        WebView web = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        web.loadUrl("https://drive.google.com/drive/folders/1d8KdudVZ2GdBsvtCsIkFNmEwB_ecumn8?usp=sharing");
    }
}
