package cn.jiguang.share.dem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.ShareParams;



import android.R.drawable;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;


/**
 * 宝贝详情界面的弹窗
 * @author http://yecaoly.taobao.com
 *
 */
@SuppressLint("CommitPrefEdits")
public class BabyPopWindow{
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
	    private ProgressDialog progressDialog;
	
	private PopupWindow popupWindow;


	private final int ADDORREDUCE=1;
	private Context context;
	/**保存选择的颜色的数据*/
	private String str_color="";
	/**保存选择的类型的数据*/
	private String str_type="";

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
                String toastMsg = (String) msg.obj;
         
            if(progressDialog!=null&&progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    };
    private PlatActionListener mPlatActionListener = new PlatActionListener() {
        @Override
        public void onComplete(Platform platform, int action, HashMap<String, Object> data) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享成功";
                handler.sendMessage(message);
            }
        }

        @Override
        public void onError(Platform platform, int action, int errorCode, Throwable error) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享失败:" + error.getMessage();
                handler.sendMessage(message);
            }
        }

        @Override
        public void onCancel(Platform platform, int action) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享取消";
                handler.sendMessage(message);
            }
        }
    };
    
  
	
	public BabyPopWindow(Context context) {
		this.context=context;
		View view=LayoutInflater.from(context).inflate(R.layout.activity_select, null);

		popupWindow=new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		//设置popwindow的动画效果

		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		
	
	        gridView = (GridView) view.findViewById(R.id.gridView1);
	        dataList = new ArrayList<>();
	        List<String> platformList = JShareInterface.getPlatformList();
	        if(platformList==null||platformList.isEmpty()){
//	            Toast.makeText(this,"请检查是否已经正确集成了JShare或者调用了JShareInterface.init",Toast.LENGTH_SHORT).show();
	          //  finish();
	            return;
	        }

	            for (String platform:platformList){
	                	Fruit f = new Fruit();
	                  f.setName(platform);
	                  f.setImageId(drawable.ic_btn_speak_now);
	                  dataList.add(f);
	        }
	        gridView.setAdapter(new FruitAdapter(context, dataList));


	        
	        gridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					final String platform = dataList.get(position).getName();
				        ShareParams shareParams = new ShareParams();

				     
			                shareParams.setTitle(share_title);
			                shareParams.setText(share_text);
			                shareParams.setShareType(Platform.SHARE_WEBPAGE);
			                shareParams.setUrl(share_url);
			                shareParams.setImageUrl(share_imageurl);
			               
			                JShareInterface.share( platform, shareParams, mPlatActionListener);
			                
	               
					
				}
			});
	    }

	

	/**弹窗显示的位置*/  
	public void showAsDropDown(View parent){
		popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
		popupWindow.setFocusable(true);
		popupWindow.setOutsideTouchable(true);
		popupWindow.update();
	}
	
	/**消除弹窗*/
	public void dissmiss(){
		popupWindow.dismiss();
	}
	

}
  






	

