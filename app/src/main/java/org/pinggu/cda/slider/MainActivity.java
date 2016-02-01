package org.pinggu.cda.slider;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import org.pinggu.cda.widget.Slider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Slider sl_discrete = (Slider)findViewById(R.id.slider_sl_discrete);
        sl_discrete.setValueDescriptionProvider(new Slider.ValueDescriptionProvider() {
            @Override
            public String getDescription(int num) {
                int value = sl_discrete.getValue();
                if(value>=0&&value<=25){
                    return "小";
                }else if(value>25&&value<75){
                    return "中";
                }else if(value>=75){
                    return "大";
                }
                return "";
            }
        });
        sl_discrete.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
            }
        });
        sl_discrete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    int value = sl_discrete.getValue();
                    if(value>=0&&value<=25){
                        sl_discrete.setValue(1,true);
                    }else if(value>25&&value<75){
                        sl_discrete.setValue(50,true);
                    }else if(value>=75){
                        sl_discrete.setValue(100,true);
                    }
                }
                return false;
            }
        });
        sl_discrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int value = sl_discrete.getValue();
                        if(value>=0&&value<=25){
                            sl_discrete.setValue(1,true);
                        }else if(value>25&&value<75){
                            sl_discrete.setValue(50,true);
                        }else if(value>=75){
                            sl_discrete.setValue(100,true);
                        }
                    }
                },300);

            }
        });


    }
}
