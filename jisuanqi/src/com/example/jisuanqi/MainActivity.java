package com.example.jisuanqi;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,
	dengyu,dian,jia,jian,cheng,chu,clear,del;
	EditText editText1;
	boolean clear_flag;//清空标示
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itme);
		bt1 = (Button) findViewById(R.id.btn1);
		bt2 = (Button) findViewById(R.id.btn2);
		bt3 = (Button) findViewById(R.id.btn3);
		bt4 = (Button) findViewById(R.id.btn4);
		bt5 = (Button) findViewById(R.id.btn5);
		bt6 = (Button) findViewById(R.id.btn6);
		bt7 = (Button) findViewById(R.id.btn7);
		bt8 = (Button) findViewById(R.id.btn8);
		bt9 = (Button) findViewById(R.id.btn9);
		bt0 = (Button) findViewById(R.id.btn0);
		dengyu = (Button) findViewById(R.id.dengyu);
		jia = (Button) findViewById(R.id.jia);
		jian = (Button) findViewById(R.id.jian);
		cheng = (Button) findViewById(R.id.cheng);
		chu = (Button) findViewById(R.id.chu);
		dian = (Button) findViewById(R.id.dian);
		clear = (Button) findViewById(R.id.clear);
		del = (Button) findViewById(R.id.del);
		editText1 = (EditText) findViewById(R.id.editText1);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);
		bt7.setOnClickListener(this);
		bt8.setOnClickListener(this);
		bt9.setOnClickListener(this);
		bt0.setOnClickListener(this);
		jia.setOnClickListener(this);
		jian.setOnClickListener(this);
		cheng.setOnClickListener(this);
		chu.setOnClickListener(this);
		del.setOnClickListener(this);
		clear.setOnClickListener(this);
		dian.setOnClickListener(this);
		dengyu.setOnClickListener(this);
		editText1.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String str = editText1.getText().toString();
		switch (arg0.getId()) {
		case R.id.btn0:
		case R.id.btn1:
		case R.id.btn2:
		case R.id.btn3:
		case R.id.btn4:
		case R.id.btn5:
		case R.id.btn6:
		case R.id.btn7:
		case R.id.btn8:
		case R.id.btn9:
		case R.id.dian:
			if (clear_flag) {
				clear_flag = false;
				str = "";
				editText1.setText("");
				
			}
			
			editText1.setText(str+((Button)arg0).getText());
			
			break;
		case R.id.jia:
		case R.id.jian:
		case R.id.cheng:
		case R.id.chu:
			if (clear_flag) {
				clear_flag = false;
				str = "";
				editText1.setText("");
				
			}
			editText1.setText(str+" "+((Button)arg0).getText()+" ");
			break;
		case R.id.clear:
			clear_flag = false;
			str = "";
			editText1.setText("");
			break;
		case R.id.del:
			if (clear_flag) {
				clear_flag = false;
				str = "";
				editText1.setText("");
			}
		
			else if(str!=null&&!str.equals("")) {
				editText1.setText(str.substring(0,str.length()-1));
			}
			break;
		case R.id.dengyu:
			getRuslt();
			break;
		}
	}
	//运算结果
	private void getRuslt() {
		// TODO Auto-generated method stub
		String exp = editText1.getText().toString();
		if (exp == null||exp.equals("")) {
			return;
			
		}
		if (!exp.contains(" ")) {
			return;
			
		}
		if (clear_flag) {
			clear_flag = false;
			
		}
		clear_flag = true;
		double result=0;
		String s1 = exp.substring(0,exp.indexOf(" "));//运算符前面的字符
		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//截取运算符
		String s2 = exp.substring(exp.indexOf(" ")+3);//运算符后面的字符
		if (!s1.equals("")&&!s2.equals("")) {
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if (op.equals("+")) {
				result = d1 + d2;
				
			} else if(op.equals("-")){
				result = d1 - d2;
			}
			else if(op.equals("×")){
				result = d1 * d2;
			}
			else if(op.equals("÷")){
				if (d2==0) {
					result = 0;
				} else {
					result = d1 / d2;
				}
				
			}
			if (!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
				int r = (int) result;
				editText1.setText("☺经过琴姐周密的计算结果为："+r+"");
			}
			else {
				editText1.setText("☺经过琴姐周密的计算结果为："+result+"");
			}
			
			
		}
		else if (!s1.equals("")&&s2.equals("")) {
			editText1.setText(exp);
		}
else if (s1.equals("")&&!s2.equals("")) {
	double d2 = Double.parseDouble(s2);
	if (op.equals("﹢")) {
		result = 0 + d2;
		
	} else if(op.equals("﹣")){
		result = 0 - d2;
	}
	else if(op.equals("×")){
		result =0;
	}
	else if(op.equals("÷")){
		result =0;
		
	}
	if (!s1.contains(".")&&!s1.contains(".")&&!op.equals("÷")) {
		int r = (int) result;
		editText1.setText("☺经过琴姐周密的计算结果为："+r+"");
	}
	else {
		editText1.setText("☺经过琴姐周密的计算结果为："+result+"");
	}
		}
    else{
	editText1.setText("");
	
	
	
}
		
		
	}

	
}
