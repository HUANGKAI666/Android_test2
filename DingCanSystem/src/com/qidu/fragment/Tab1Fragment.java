package com.qidu.fragment;

import java.util.ArrayList;
import java.util.List;


import com.qidu.activity.DetailsActivity;
import com.qidu.adapter.Tab1Adapter;
import com.qidu.bean.Food;
import com.yanruqi.CatersSystem.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Tab1Fragment extends Fragment implements OnClickListener {
	private List<Food> fruitList = new ArrayList<Food>();
	private List<Food> fruitList2 = new ArrayList<Food>();
	private List<Food> fruitList3 = new ArrayList<Food>();
	private ListView listView;
	private View rootView;
	private Button bt1;
	private Button bt4;
	private Button bt3;
	private Button bt2;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		rootView = inflater.inflate(R.layout.tab01, container, false);
		return rootView;
	}

	@SuppressLint("ResourceAsColor") @Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initFruits();
		bt1 = (Button) rootView.findViewById(R.id.store_btn1);
		bt2 = (Button) rootView.findViewById(R.id.store_btn2);
		bt3 = (Button) rootView.findViewById(R.id.store_btn3);
		bt4 = (Button) rootView.findViewById(R.id.store_btn4);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt1.setTextColor(getResources().getColor(R.color.red));


		Tab1Adapter adapter = new Tab1Adapter(getActivity(),
				R.layout.tab01_item, fruitList);
		listView = (ListView) rootView.findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Food fruit = fruitList.get(position);
				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				intent.putExtra("name", fruit.getName());
				intent.putExtra("content", fruit.getContent());
				intent.putExtra("price", fruit.getPrice());
				intent.putExtra("image", fruit.getImageId());
				startActivity(intent);
			}
		});
	}



	private void initFruits() {
		Food a1 = new Food(
				"烤肉",
				"九里·烤肉连锁店，龙湖北城天街店位于金牛区蓉北商贸大道龙湖北城天街5楼。凯德店位于成华区万科路的凯德广场4楼。独具特色的装修风格，店内环境明亮宽敞，别致整洁，就餐氛围舒适可人，"
						+ "舒适优雅。店内供应种类繁多的各式肉类、海鲜、中式餐点以及酒水饮料，食材新鲜，调味丰富，健康烧烤。商家精选材料，肉质鲜嫩、久烤不老，"
						+ "营养成份不流失，加上秘制调料，鲜嫩汁浓，原汁原味，是朋友聚会、家庭聚餐的佳处。",
				R.drawable.img1, "115");
		fruitList.add(a1);
		Food a2 = new Food(
				"一把骨",
				"一把骨隶属成都佘氏一把骨餐饮管理有限公司旗下品牌，公司本着人无我有、人有我优、不断创新的宗旨，坚持诚信经营，为广大客户提供优质的服务，在本领域获得广泛的认可。本店主要以猪筒骨骨头汤熬制而成，汤香味纯，卤骨头“又大又实在”，“慢慢”啃完上面的肉，再“狠狠吸一把骨髓”，“那叫一个香”！配上蜂窝玉米，“解腻”。大冬天去吃“比较舒服”。另：还供应干锅，欢迎您的光临！"
						+ "", 
		R.drawable.img2, "66");
		fruitList.add(a2);
		Food a3 = new Food(
				"绝城芋儿鸡",
				"鲜锅兔（鲜、嫩、辣）且兔肉保证每日配送当天宰杀之鲜兔，成都三环内同自贡光大街老街兔合作餐馆，鲜锅兔之主要辅料（小米辣、生姜均从自贡光大街老街兔总店直接配送）",
		R.drawable.img3, "60");
		fruitList.add(a3);
		Food a4 = new Food(" 小龙虾 ", "购买须知 有效期 2017.5.31 至 2017.6.30（周末、法定节假日通用） 使用时间 17:00-22:00 预约提醒  无需预约，消费高峰时可能需要等位堂食外带堂食外带均可，可以打包，打包费详情咨询商家温馨提示团购用户不可同时享受商家其他优惠酒水饮料等问题，请致电商家咨询，以商家反馈为准如部分菜品因时令或其他不可抗因素导致无法提供，店内会用等价菜品替换，具体事宜请与店内协商商家服务提供免费WiFi停车位收费标准：咨询商户",
		R.drawable.img4, "83");
		fruitList.add(a4);
		Food a5 = new Food("豪亭双人套餐", "豪亭会所环境优雅，设施一流，是您休闲娱乐，商务洽谈，家人团聚和朋友聚会的场所。豪亭全体员工将秉承“顾客至上，服务一流”的宗旨，力求做到尽善尽美。豪亭会所的目标是：塑造企业形象，走规模经营之路向会所管理集团发展，以企业文化和服务品质参与市场竞争，以一流的设施，追求规范化和个性化的服务，全力营造优雅宽敞、舒适的环境，满足顾客个性化需求，为顾客创造一个尊贵奢华，温馨典雅，舒适惬意的休闲空间。" +
				"", 
		R.drawable.img5, "88");
		fruitList.add(a5);
		Food a6 = new Food("山姆老爹牛排", "•	单人自助：11:00-21:30最多可用餐2小时 周一到周五16:00-21:30用餐每人需到店另付10元；周六、周日以及法定节假日全天用餐每人需到店另付10元 2，到店如另付10元可增加韩式小火锅 3，请勤拿少取，倡导吃光盘中餐，不浪费食物，就餐前每人预付10元押金，就餐结束后整桌剩余食物小于等于200g，整桌自助酒水剩余小于等于200ml方可到收银台取回全部押金。如若整桌食物（无论生熟）酒水超出200g押金不退还。 5，仅限堂食，不提供餐前、后外带； 6，如有疑问，请致电商家咨询，以商家反馈为准；" +
				"", 
			R.drawable.img6,"98");
		fruitList.add(a6);
		Food a7 = new Food("黄记煌三汁焖锅 ", "有效期 2017.1.3 至 2017.6.30（周末、法定节假日通用） 使用时间 11:00-22:00 预约提醒 无需预约，消费高峰时可能需要等位 限购限用提醒 最多可叠加使用6张 不兑现、不找零 包间 店内无包间 堂食外带 仅限堂食，不提供餐前外带，餐毕未吃完可打包，打包费详情咨询 家 温馨提示 团购用户不可同时享受商家其他优惠 酒水饮料等问题，请致电商家咨询，以商家反馈为准 商家服务：提供免费WiFi 停车位收费标准：具体情况咨询商家（目前商城免费停放）" +
				"",
				R.drawable.img7, "76");
		fruitList.add(a7);
		Food a8 = new Food("西部鲜果蛋糕", "有效期 2014.12.17 至 2017.7.3（周末、法定节假日通用） 使用时间 10:30-20:00 预约提醒 电话预约，请至少提前1小时致电商家预约，预约保留30分钟 配送方式 仅限到店自提，不提供配送服务 温馨提示 如需发票，请提前致电商家询问 团购用户不可同时享受商家其他优惠 商家服务 提供免费WiFi" +
				"",
				R.drawable.img8, "72");
		fruitList.add(a8);
		Food a9 = new Food("Mr.Fish鱼鲜生海鲜", "有效期 2017.1.3 至 2017.6.30（周末、法定节假日通用） 使用时间 11:00-22:00 预约提醒 无需预约，消费高峰时可能需要等位 限购", 
				R.drawable.img9,"100");
		fruitList.add(a9);
		Food a10 = new Food("玛喜达韩国料理 ", "免费提供餐巾纸 年糕料理小套餐(2人餐) 5选2 蔬菜年糕火锅 /芝士年糕火锅/ 牛肉年糕火锅/ 海鲜年糕火锅 火腿年糕火锅  其他菜品 面1人份、鱼饼1人份、特色炒饭1人份、鸡蛋2人份" +
				"",
				R.drawable.img10,"110");
		fruitList.add(a10);
		Food a11 = new Food("好巴适庭院老火锅", "单人自助：11:00-21:30最多可用餐2小时 周一到周五16:00-21:30用餐每人需到店另付10元；周六、周日以及法定节假日" +
				"", R.drawable.img11,
				"120");
		fruitList.add(a11);
		Food a12 = new Food("曼柠香泰式海鲜火锅", "免费提供餐巾纸 1、套餐菜品包含：15头鲍鱼4只，大花蟹2只，大肉蟹2只，扇贝8只，生蚝8只，基围虾16只，新西兰青口8只，圣子12只花甲16只，鱼豆腐10个，土豆1.5斤，青笋1.5斤，豆皮8两金针菇8两，黄瓜8两，粉条1斤，米饭6碗。2、海鲜采用的都是空运过来的新鲜海鲜，为了保证食材的新需要现杀现做，请提前30分钟致电商家预约预定；3、本套餐出品营业时间：晚上18：00-凌晨2：00" +
				"", R.drawable.img12,"111");
		fruitList.add(a12);
		Food a13 = new Food("XCAKE艾蛋糕", "小榴芒规格：约8寸1,圆形 生产日期：配送当日生产 保存须知：冷链保鲜 免费提供蜡烛1包+刀1把+蛋糕叉5把+小盘5包，如超出，收费标准与商家协商 可免费在蛋糕上写6个字；免费赠送卡片1张 免费提供包装" +
				"", R.drawable.img13,"85");
		fruitList.add(a13);
		Food a14 = new Food("爱思客幸福秘方蛋糕 ", "电话预约，请至少提前4小时致电商家预约，预约逾期不保留，预约时需提供美团券 配送方式 自提配送皆可，如需配送，门店半径5公里内范围免费，超出范围 费标准：10元/5km 温馨提示 选择好您所需要的蛋糕款式，付款后获得一个12位数的团购券密码 然后将团购券密码+蛋糕款式+送货时间+配送地址发送短信   18981929127告知详细信息及特殊要求。 团购用户不可同时享受商家其他优惠 商家服务 提供免费WiFi 发票信息 本单发票由商家提供，请在消费时向商家索取" +
				"",R.drawable.img14, "54");
		fruitList.add(a14);
		Food a15 = new Food("芭菲盛宴", "有效期 2013.5.31 至 2017.6.30（周末、法定节假日通用） 使用时间 11:30-14:30 预约提醒 无需预约，消费高峰可能需要等位 其他优惠 凭美团券到店消费不可同时享受店内其他优惠 使用规则 本单仅限1人享用 1米（不含）以下儿童可享受本自助餐不另收费；1米（含）-1.米（含）儿童享受实际价的半价优惠，需到店支付；1.4（不含米以上儿童需独立使用1张美团券；70岁及以上老人凭有效件可享受实际价的半价优惠，需到店支付仅限大厅用餐，商家无包间 部分菜品因时令原因有所不同，请以店内当日实际供应为准" +
				"", R.drawable.img15,"156");
		fruitList.add(a15);
		
		fruitList2.add(a14);
		fruitList2.add(a3);
		fruitList2.add(a2);
		fruitList2.add(a8);
		fruitList2.add(a7);
		fruitList2.add(a4);
		fruitList2.add(a13);
		fruitList2.add(a5);
		fruitList2.add(a6);
		fruitList2.add(a9);
		fruitList2.add(a10);
		fruitList2.add(a12);
		fruitList2.add(a1);
		fruitList2.add(a11);
		fruitList2.add(a15);
		
		fruitList3.add(a6);
		fruitList3.add(a4);
		fruitList3.add(a5);
		fruitList3.add(a3);
		fruitList3.add(a2);
		fruitList3.add(a1);
		fruitList3.add(a12);
		fruitList3.add(a10);
		fruitList3.add(a9);
		fruitList3.add(a8);
		fruitList3.add(a14);
		fruitList3.add(a7);
		fruitList3.add(a15);
		fruitList3.add(a13);
		fruitList3.add(a1);
		
		

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub


	
		switch (arg0.getId()) {
		case R.id.store_btn1:
			bt1.setTextColor(getResources().getColor(R.color.red));
			bt2.setTextColor(getResources().getColor(R.color.blak));
			bt3.setTextColor(getResources().getColor(R.color.blak));
			bt4.setTextColor(getResources().getColor(R.color.blak));
			
		
			Tab1Adapter adapter = new Tab1Adapter(getActivity(),
					R.layout.tab01_item, fruitList);
			listView.setAdapter(adapter);
			break;
		case R.id.store_btn2:
			bt2.setTextColor(getResources().getColor(R.color.red));
			bt1.setTextColor(getResources().getColor(R.color.blak));
			bt3.setTextColor(getResources().getColor(R.color.blak));
			bt4.setTextColor(getResources().getColor(R.color.blak));
			Tab1Adapter adapter2 = new Tab1Adapter(getActivity(),
					R.layout.tab01_item, fruitList2);
			listView.setAdapter(adapter2);

			break;
		case R.id.store_btn3:
			bt3.setTextColor(getResources().getColor(R.color.red));
			bt2.setTextColor(getResources().getColor(R.color.blak));
			bt1.setTextColor(getResources().getColor(R.color.blak));
			bt4.setTextColor(getResources().getColor(R.color.blak));
			Tab1Adapter adapter3 = new Tab1Adapter(getActivity(),
					R.layout.tab01_item, fruitList3);
			listView.setAdapter(adapter3);

			break;
		case R.id.store_btn4:
			bt4.setTextColor(getResources().getColor(R.color.red));
			bt2.setTextColor(getResources().getColor(R.color.blak));
			bt3.setTextColor(getResources().getColor(R.color.blak));
			bt1.setTextColor(getResources().getColor(R.color.blak));
		
		

			break;

		default:
			break;
		}

	}

}
