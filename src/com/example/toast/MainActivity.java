package com.example.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private TextView tv_title;
    private TextView tv_content;
    private Button bt_one;
    private Button bt_two;
    private Button bt_three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_one = (Button) findViewById(R.id.bt_one);
        bt_two = (Button) findViewById(R.id.bt_two);
        bt_three = (Button) findViewById(R.id.bt_three);

        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionToast();
            }
        });
        bt_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageToast();
            }
        });
        bt_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myToast();
            }
        });
    }

    private void positionToast() {
        Toast positionTosast = Toast.makeText(this, "带位置的Toast", Toast.LENGTH_SHORT);
        positionTosast.setGravity(Gravity.CENTER, 0, 0);
        positionTosast.show();
    }

    private void imageToast() {
        Toast imageToast = Toast.makeText(this, "带位置的Toast", Toast.LENGTH_SHORT);
        LinearLayout view = (LinearLayout) imageToast.getView();
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.ic_launcher);
        view.addView(iv);
        imageToast.show();
    }

    private void myToast() {
        View view = LayoutInflater.from(this).inflate(R.layout.toast, null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_title.setText("这是我的标题");
        tv_content.setText("这是我的内容");
        Toast toast = new Toast(this);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
