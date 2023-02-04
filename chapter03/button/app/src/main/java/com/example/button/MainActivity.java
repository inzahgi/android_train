package com.example.button;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MyActivity";

    protected Button btn_one, btn_two, btn_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setText("按钮1已被点击");
            }
        });
        btn_three.setOnClickListener(this);
    }

    public void click(View view) {
        btn_two.setText("按钮2已被点击");
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "onClick: "+view.getId());
        switch(view.getId()) {
            case R.id.btn_three:
                Log.i(TAG, "btn_three onClick: "+view.getId());
                btn_three.setText("按钮3已被点击");
                    break;
        }
    }
}