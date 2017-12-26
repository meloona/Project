package sas.ita.com.yusr.splashwithpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator;
import sas.ita.com.yusr.R;

public class Slide_Main extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    CircleIndicator indicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide__main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        indicator=(CircleIndicator) findViewById(R.id.indicator);
        myadapter=new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        indicator.setViewPager(viewPager);
    }
}
