package com.mystyler.clickheart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static HeartLayout heartLayout;
    public static float pointX ;
    public static float pointY ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list);
        PictureAdapter adapter = new PictureAdapter(this,listView);
        listView.setAdapter(adapter);

        heartLayout = (HeartLayout)findViewById(R.id.heart_layout);
        heartLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        pointX = motionEvent.getRawX();
                        pointY = motionEvent.getRawY();
                        break;
                }
                return false;
            }
        });





    }
}
