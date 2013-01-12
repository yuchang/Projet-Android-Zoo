package com.example.projet_android_zoo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main extends BaseActivity {

    private ScrollLayout mScrollLayout;
	private RadioButton[] mButtons;
	private String[] mHeadTitles;
	private int mViewCount;
	private int mCurSel;	
	
	private ImageView mHeadLogo;
	private TextView mHeadTitle;
	private ProgressBar mHeadProgress;
	private ImageButton mHead_share;
	private ImageButton mHeadPub_post;
	private ImageButton mHeadPub_tweet;	
	
	private RadioButton fbNews;
	private RadioButton fbQuestion;
	private RadioButton fbTweet;
	private RadioButton fbactive;
	private ImageView fbSetting;	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		this.initHeadView();
        this.initFootBar();
        this.initPageScroll();
    }
    
    private void initHeadView(){
    	mHeadLogo = (ImageView)findViewById(R.id.main_head_logo);
    	mHeadTitle = (TextView)findViewById(R.id.main_head_title);
    	mHeadProgress = (ProgressBar)findViewById(R.id.main_head_progress);
    	mHead_share = (ImageButton)findViewById(R.id.main_head_share);
    	mHeadPub_post = (ImageButton)findViewById(R.id.main_head_pub_post);
    	mHeadPub_tweet = (ImageButton)findViewById(R.id.main_head_pub_tweet);
    	
    	mHead_share.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//UIHelper.showSearch(v.getContext());
			}
		});
    	mHeadPub_post.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//UIHelper.showQuestionPub(v.getContext());
			}
		});
    	mHeadPub_tweet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//UIHelper.showTweetPub(Main.this);
			}
		});
    }   
    
    
    private void initFootBar(){
    	fbNews = (RadioButton)findViewById(R.id.main_footbar_news);
    	fbQuestion = (RadioButton)findViewById(R.id.main_footbar_question);
    	fbTweet = (RadioButton)findViewById(R.id.main_footbar_tweet);
    	fbactive = (RadioButton)findViewById(R.id.main_footbar_active);
    	
    	fbSetting = (ImageView)findViewById(R.id.main_footbar_setting);
    	fbSetting.setOnClickListener(new View.OnClickListener() {
    		public void onClick(View v) {    			
    			//UIHelper.showSettingLoginOrLogout(Main.this, mGrid.getQuickAction(0));
    			//mGrid.show(v);
    		}
    	});    	
    }   
    
    private void initPageScroll(){
    	mScrollLayout = (ScrollLayout) findViewById(R.id.main_scrolllayout);
    	
    	LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_linearlayout_footer);
    	mHeadTitles = getResources().getStringArray(R.array.head_titles);
    	mViewCount = mScrollLayout.getChildCount();
    	mButtons = new RadioButton[mViewCount];
    	
    	for(int i = 0; i < mViewCount; i++){
    		mButtons[i] = (RadioButton)linearLayout.getChildAt(i*2);
    		mButtons[i].setTag(i);
    		mButtons[i].setChecked(false);
    		mButtons[i].setOnClickListener(new View.OnClickListener() {
    			public void onClick(View v){
    				int pos = (Integer)(v.getTag());
    				if(mCurSel == pos) {
    					switch (pos) {
    						case 0 : //Activités
    							Log.v("mCursel", "case0");
    							break;
    						case 1 : //Liste d'animaux
    							Log.v("mCursel", "case1");
    							break;
    						case 2 : //Carte de Zoo
    							Log.v("mCursel", "case2");
    							break;
    						case 3 : //FAQ
    							Log.v("mCursel", "case3");
    							break;
    						default : break;
    					}
    				}
    				mScrollLayout.snapToScreen(pos);
    			}
    		});
    	}
    	
    	mCurSel = 0;
    	mButtons[mCurSel].setChecked(true);
    	
    	mScrollLayout.SetOnViewChangeListener(new ScrollLayout.OnViewChangeListener(){
    		public void OnViewChange(int viewIndex){
    			switch(viewIndex){
    				case 0 : //Activités
    					Log.v("ScrollLayout", "case0");
    					break;
    				case 1 : //Liste d'animaux
    					Log.v("ScrollLayout", "case1");
    					break;
    				case 2 : //Carte de Zoo
    					Log.v("ScrollLayout", "case2");
    					break;
    				case 3 : //FAQ
    					Log.v("ScrollLayout", "case3");
    					break;
    				default : break;
    			}
    			setCurPoint(viewIndex);
    		}
    	});
    }
    
    private void setCurPoint(int index){
    	if (index < 0 || index > mViewCount - 1 || mCurSel == index)
    		return;
    	
    	mButtons[mCurSel].setChecked(false);
    	mButtons[index].setChecked(true);    	
    	mHeadTitle.setText(mHeadTitles[index]);    	
    	mCurSel = index;
    }
    
}
