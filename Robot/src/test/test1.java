package test;

import Utils.HttpUtils;
import android.test.AndroidTestCase;
import android.util.Log;

public class test1 extends AndroidTestCase{
	
	public void testSendInfo(){
	String re = HttpUtils.doGet("给我讲个笑话");
     Log.e("info",re);
     String re2 = HttpUtils.doGet("你真傻");
     Log.e("info",re);
     String re3 = HttpUtils.doGet("你真可爱");
     Log.e("info",re);
	}
}
