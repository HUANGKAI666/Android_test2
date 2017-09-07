package cn.jiguang.share.dem;

import android.R.drawable;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;








import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.ShareParams;




public class MainActivity extends Activity {
	private BabyPopWindow popWindow;
	
    private static final String TAG="SelectPlatActivity";
    private ProgressDialog progressDialog;
    //1 分享
    private int type;
    private GridView gridView;
    private List<Fruit> dataList;
    public static String share_url = "https://www.baidu.cn";
    public static String share_text = "早上好晚上好！";
    public static String share_title = " 你好";
    public static String share_imageurl = "http://img2.3lian.com/2014/f5/63/d/23.jpg";
    public static String share_imageurl_1 = "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1308/02/c0/24056523_1375430477597.jpg";
    public static String share_videourl = "http://v.youku.com/v_show/id_XOTQwMDE1ODAw.html?from=s1.8-1-1.2&spm=a2h0k.8191407.0.0";
    public static String share_musicurl = "http://music.huoxing.com/upload/20130330/1364651263157_1085.mp3";
    public static String music_shareUrl = "https://y.qq.com/n/yqq/song/109325260_num.html?ADTAG=h5_playsong&no_redirect=1";
    public static final String KEY_PLAT_NAME="PLAT_NAME";


    
   
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button bt = (Button) findViewById(R.id.button1);
//       View view=LayoutInflater.from(this).inflate(R.layout.activity_select, null);
//       popupWindow= new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       popWindow = new BabyPopWindow(this);
       bt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
//			popupWindow.setFocusable(true);
//			popupWindow.setOutsideTouchable(true);
//			popupWindow.update();
			popWindow.showAsDropDown(v);
		}
	});
 
        
       
    }
}
