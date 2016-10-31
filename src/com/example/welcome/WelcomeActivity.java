package com.example.welcome;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
   TextView tvshowinfo;
   Button btnClick;
   private boolean flag=false;
   public Handler hand=new Handler(){
	   public void handleMessage(Message msg){
		   //处理信息（刷新界面）
		   switch (msg.what){
		   case 0x11:
			   int randNum=(int)(Math.random()*100+1);
				//tvshowinfo.setText(randNum);
				tvshowinfo.setText(String.valueOf(randNum));
		        break;
		   case 0x12:
		        break;
		        
		   default:
		       break;
		        
		        
		   }
		  super.handleMessage(msg);
		  //执行父类中的方法
	   }
	
   };
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		tvshowinfo=(TextView) this.findViewById(R.id.tvshowinfo);
		btnClick=(Button) this.findViewById(R.id.btnClick);
		
		btnClick.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//改变变量（全局变量）
				if(flag==false){
					flag=true;
					
				}else{
					flag=false;
				}
				
				new Thread(new Runnable(){
					//这是匿名内部类，此时传给Thread构造函数的应该是一个实现Runnable的类的对象引用，
					//因此new Runnable(){public void run(){...}}就包括了定义这个类（只不过这个类没有名字）和实例化这个类的对象。
					public void run(){
						
					try{	
					while(true){
						//不停循环
						Thread.sleep(30);
						Message msg=new Message();
						if(flag){
						msg.what=0x11;

						}else{
							msg.what=0x12;
						}
						hand.sendMessage(msg);
					}
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}).start(); 
				
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
