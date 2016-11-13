package com.iteam.app;

import java.util.ArrayList;



import android.app.Activity;
//import android.app.TabActivity;
//import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.TabHost;
import android.widget.ImageView;


public class Main_IteamActivity extends Activity {
	
	//private TabHost tabHost;
	private ViewPager mTabPager;//声明对象
	private ImageView mTab1,mTab2,mTab3;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_iteam);
       //启动activity时不自动弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); 
        innitView();
	}

	private void innitView() {

		mTabPager = (ViewPager)findViewById(R.id.tabpager);
		mTab1 = (ImageView) findViewById(R.id.img_task);
        mTab2 = (ImageView) findViewById(R.id.img_group);
        mTab3 = (ImageView) findViewById(R.id.img_settings);
//		tabHost = Main_IteamActivity.this.getTabHost();
//		TabHost.TabSpec spec;
//		Intent intent;
        mTab1.setOnClickListener(new MyOnClickListener(0));
        mTab2.setOnClickListener(new MyOnClickListener(1));
        mTab3.setOnClickListener(new MyOnClickListener(2));
		
		 //将要分页显示的View装入数组中
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.main_task, null);
        View view2 = mLi.inflate(R.layout.main_group, null);
        View view3 = mLi.inflate(R.layout.main_setting, null);
        
        //添加每个View数据
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        
        //创建填充viewPager的适配器
        PagerAdapter mPagerAdapter = new PagerAdapter() {
			
			
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			
			public int getCount() {
				return views.size();
			}

			
			public void destroyItem(View container, int position, Object object) {
				((ViewPager)container).removeView(views.get(position));
			}
			
			//
			//public CharSequence getPageTitle(int position) {
				//return titles.get(position);
			//}
			
			
			public Object instantiateItem(View container, int position) {
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
		};
		
		mTabPager.setAdapter(mPagerAdapter);
		
	}
    /**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}
		
		public void onClick(View v) {
			mTabPager.setCurrentItem(index);
		}
	};
    
	
}
