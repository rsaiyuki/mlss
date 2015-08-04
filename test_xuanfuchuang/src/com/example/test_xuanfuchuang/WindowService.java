package com.example.test_xuanfuchuang;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;

public class WindowService extends Service {

	private Timer timer;
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		showWindow();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(timer==null) {
			timer = new Timer();
		}
//		timer.scheduleAtFixedRate(new TimerTask() {
//
//			@Override
//			public void run() {
//				handler.sendEmptyMessage(1);
//
//			}
//		}, 0, 500);
		
		return super.onStartCommand(intent, flags, startId);
	}
	ImageView img;
	public void showWindow(){
		WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		WindowManager.LayoutParams params= new WindowManager.LayoutParams();
		params.type = LayoutParams.TYPE_PHONE;
		//͸��
		params.format = PixelFormat.RGBA_8888;
		//���ɵ������������ȡ����
		params.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL|LayoutParams.FLAG_NOT_TOUCHABLE|LayoutParams.FLAG_NOT_FOCUSABLE;
		
		params.gravity = Gravity.CENTER;
		//λ��
		params.x = 0;
		params.y = 0;
		 DisplayMetrics dm = new DisplayMetrics();
	        ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
		params.width = dm.widthPixels;
		params.height = dm.heightPixels;

		VideoView videoView = new VideoView(this);

		MediaController mController = new MediaController(this);
		videoView.setMediaController(mController);
//		Uri uri = Uri.parse("http://www.sciencep.com/movies/1411711067.mp4");
//		videoView.setVideoURI(uri);
//		String path = Environment.getExternalStorageDirectory()
//				.getAbsolutePath()+"/hfsz/video/1438158523441.mp4";
//		videoView.setVideoPath(path);
//		videoView.setLayoutParams(params);
//		windowManager.addView(videoView, params);
//		videoView.requestFocus();
//		videoView.start();
		img = new ImageView(this);
		img.setBackgroundResource(R.drawable.fffi);
		img.setLayoutParams(params);
		windowManager.addView(img, params);
		as = new AnimationSet(true);
		RotateAnimation ram = new RotateAnimation(0,360 , Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT,0.5f);
		ram.setDuration(500);
		as.addAnimation(ram);
	}
	AnimationSet as;
//	Handler handler = new Handler(){
//		public void handleMessage(android.os.Message msg) {
//			img.startAnimation(as);
//		};
//	};
}
