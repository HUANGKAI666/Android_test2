package com.example.test_wedview;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.IntentSender.SendIntentException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private String url="https://www.baidu.com/";
	private WebView webview;
	private ProgressDialog dialog;
	private float startX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
//		Uri uri = Uri.parse(url);
//		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//		startActivity(intent);
		init();
	}
	private void init() {
		
		webview =(WebView) findViewById(R.id.WebView1);
		//加载本地网页
//		webview.loadUrl("file:///android_assets/**.html");
		//AnidMan...中添加网络权限
		//webview加载web资源
		webview.loadUrl(url);
		//覆盖通过第三方打开网页的方式
		
		                        
		webview.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return(true);
			}
		});
	//启用JS
		
		WebSettings setting =webview.getSettings();
		setting.setJavaScriptEnabled(true);
		webview.setWebChromeClient(new WebChromeClient()
		{
			public void onProgressChanged(WebView view, int newProgress) {
				
				if (newProgress==100) {
					//网页加载完成,关闭进度条
					closeDialog();
					
				}
				else {
					//网页正在加载
					openDialog(newProgress);
					
				}
				
			}

			private void openDialog(int newProgress) {
				// TODO Auto-generated method stub
				if (dialog==null) {
					dialog=new ProgressDialog(MainActivity.this);
					dialog.setTitle("正在加载……");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.show();
					
				}
				else {
					dialog.setProgress(newProgress);}}
			private void closeDialog() {
				// TODO Auto-generated method stub
				if (dialog!=null&&dialog.isShowing()) {
					dialog.dismiss();
					dialog=null;
					}}});}
	//改写返回键的逻辑，让他不点返回键退出
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		if (keyCode==KeyEvent.KEYCODE_BACK) {
//			if (webview.canGoBack()) {
//				webview.goBack();
//				return true;
//			} else {
//				System.exit(0);
//
//			}
//		}
//		return super.onKeyDown(keyCode, event);
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (webview.canGoBack()) {
			webview.goBack();
		} else {
			System.exit(0);

		}
	}
	
	
	
}

	
