package com.qidu.pay.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yanruqi.CatersSystem.R;
public class PayActivity extends Activity {
	private WebView webview ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);

	    webview = (WebView) super.findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true); // 启用JavaScript
		webview.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				
				boolean startsWith = url.startsWith("weixin://wap/pay?");
			  if (startsWith) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
			} else {

			}
				return super.shouldOverrideUrlLoading(view, url);
			}
		});
		webview.getSettings().setBuiltInZoomControls(true); // 控制页面缩放
		webview.loadUrl("weixin://wap/pay?");
	}
}
