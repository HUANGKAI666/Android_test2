package test;

import Utils.HttpUtils;
import android.test.AndroidTestCase;
import android.util.Log;

public class test1 extends AndroidTestCase{
	
	public void testSendInfo(){
	String re = HttpUtils.doGet("���ҽ���Ц��");
     Log.e("info",re);
     String re2 = HttpUtils.doGet("����ɵ");
     Log.e("info",re);
     String re3 = HttpUtils.doGet("����ɰ�");
     Log.e("info",re);
	}
}
