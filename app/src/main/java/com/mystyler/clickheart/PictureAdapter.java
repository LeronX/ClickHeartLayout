package com.mystyler.clickheart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class  PictureAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflator;
    private int[ ] pic={R.mipmap.bear_1,R.mipmap.bear_2,R.mipmap.bear_3,R.mipmap.bear_4,
            R.mipmap.bear_5,R.mipmap.bear_6,R.mipmap.bear_7,R.mipmap.bear_8,
            R.mipmap.bubble_1,R.mipmap.bubble_2,R.mipmap.bubble_3,R.mipmap.bubble_4,
            R.mipmap.bubble_5,R.mipmap.bubble_6,R.mipmap.bubble_7,R.mipmap.bubble_8,
            R.mipmap.bubble_9,R.mipmap.bubble_10,
            R.mipmap.cat_1,R.mipmap.cat_2,R.mipmap.cat_3,R.mipmap.cat_4,
            R.mipmap.cat_5,R.mipmap.cat_6,R.mipmap.cat_7,R.mipmap.cat_8,
            R.mipmap.colorheart_1,R.mipmap.colorheart_2,R.mipmap.colorheart_3,R.mipmap.colorheart_4,
            R.mipmap.colorheart_5,R.mipmap.colorheart_6,R.mipmap.colorheart_7,R.mipmap.colorheart_8,
            R.mipmap.colorheart_9,R.mipmap.colorheart_10,R.mipmap.colorheart_11,R.mipmap.colorheart_12,
            R.mipmap.colorheart_13,R.mipmap.colorheart_14,
            R.mipmap.colorheart_15,R.mipmap.colorheart_16,R.mipmap.colorheart_17,R.mipmap.colorheart_18,
            R.mipmap.colorheart_19,R.mipmap.colorheart_20,R.mipmap.colorheart_21,R.mipmap.colorheart_22,
            R.mipmap.colorheart_23,R.mipmap.colorheart_24,
            R.mipmap.colorheart_25,R.mipmap.colorheart_26,R.mipmap.colorheart_27,R.mipmap.colorheart_28,
            R.mipmap.rabbit_1,R.mipmap.rabbit_2,R.mipmap.rabbit_3,R.mipmap.rabbit_4,
            R.mipmap.rabbit_5,R.mipmap.rabbit_6,R.mipmap.rabbit_7,R.mipmap.rabbit_8,
            R.mipmap.cow_1, R.mipmap.cow_2, R.mipmap.cow_3, R.mipmap.cow_4, R.mipmap.cow_5,
            R.mipmap.candy_1,R.mipmap.candy_2,R.mipmap.candy_3,
            R.mipmap.star_1, R.mipmap.star_2, R.mipmap.star_3,
            R.mipmap.flower_1, R.mipmap.flower_2, R.mipmap.flower_3};


    Timer timer;
    private ListView listview;


    public PictureAdapter( Context context, ListView listview) {
        inflator = LayoutInflater.from(context);
        this.context = context;
        this.listview = listview;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int acposition = position;
        convertView = inflator.inflate(R.layout.item, null);
        ImageView imageView = (ImageView) convertView
                    .findViewById(R.id.image);
        TextView likeCount = (TextView) convertView
                    .findViewById(R.id.count);
        likeCount.setTag(position);
        imageView.setImageResource(R.mipmap.background);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer != null) {
                    timer.cancel();
                }
                timer = null;
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //两秒定时 统计2s内的点击次数
                    }
                }, 2000);


                final float y = ScreenUtil.getScreenHeightInPx(context) - MainActivity.pointY;
                MainActivity.heartLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.heartLayout.addHeart(pic[new Random().nextInt(76)], MainActivity.pointX, y);
                    }
                });

                onLick(acposition);
            }

        });
        return convertView;
    }

    private void onLick(int acposition) {
        TextView tx = (TextView)listview.findViewWithTag(acposition);
        int i = Integer.valueOf((String)tx.getText());
        tx.setText(String.valueOf(i+1));
    }


}
