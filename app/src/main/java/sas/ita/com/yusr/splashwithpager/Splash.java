package sas.ita.com.yusr.splashwithpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import sas.ita.com.yusr.R;

public class Splash extends AppCompatActivity {
  private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=(TextView)findViewById(R.id.textview);
        iv=(ImageView) findViewById(R.id.imageview);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(animation);
        iv.startAnimation(animation);
      final   Intent i= new Intent(this, Slide_Main.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
