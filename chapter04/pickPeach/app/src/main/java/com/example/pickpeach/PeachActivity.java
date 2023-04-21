package com.example.pickpeach;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class PeachActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_exit, btn_restart;
    private int count = 0;

    private int[] peachResArray = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peach);
        Intent intent = getIntent();
        peachResArray =  intent.getIntArrayExtra("peachResArray");
        Log.i("test", "line = 29 peachResArray:"+ Arrays.toString(peachResArray));

        init();
    }

    private void init() {
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_exit = findViewById(R.id.btn_exit);
        btn_restart = findViewById(R.id.btn_restart);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        btn_restart.setOnClickListener(this);


        initPeach();
    }

    private void initPeach() {
        for (int i = 0; i < 6; i++) {
            if(peachResArray[i] != 0) {
                Log.i("test", "line = 50\t" +i);
                switch (i) {
                    case 0:
                        btn_one.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        btn_two.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        btn_three.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        btn_four.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        btn_five.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        btn_six.setVisibility(View.INVISIBLE);
                        break;
                    default:
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:    //第一个桃子的点击事件
                info(btn_one);
                peachResArray[0] = 1;
                break;
            case R.id.btn_two:    //第二个桃子的点击事件
                info(btn_two);
                peachResArray[1] = 1;
                break;
            case R.id.btn_three:  //第三个桃子的点击事件
                info(btn_three);
                peachResArray[2] = 1;
                break;
            case R.id.btn_four:   //第四个桃子的点击事件
                info(btn_four);
                peachResArray[3] = 1;
                break;
            case R.id.btn_five:   //第五个桃子的点击事件
                info(btn_five);
                peachResArray[4] = 1;
                break;
            case R.id.btn_six:    //第六个桃子的点击事件
                info(btn_six);
                peachResArray[5] = 1;
                break;
            case R.id.btn_exit:   //“退出桃园”按钮的点击事件
                returnData();
                break;
            case R.id.btn_restart:
                peachResArray = new int[6];
                btn_one.setVisibility(View.VISIBLE);
                btn_two.setVisibility(View.VISIBLE);
                btn_three.setVisibility(View.VISIBLE);
                btn_four.setVisibility(View.VISIBLE);
                btn_five.setVisibility(View.VISIBLE);
                btn_six.setVisibility(View.VISIBLE);
        }
    }

    private void info(Button btn) {
        count++;
        btn.setVisibility(View.INVISIBLE);
        Toast.makeText(PeachActivity.this, "摘到" + count + "个桃子",
                Toast.LENGTH_SHORT).show();
    }
    private void returnData() {
        Intent intent = new Intent();
        intent.putExtra("count" ,count);
        intent.putExtra("peachResArray", peachResArray);
        Log.i("test", "returnData: count:"+ count + "peachResArray:"+ Arrays.toString(peachResArray));
        setResult(1, intent);
        PeachActivity.this.finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            returnData();
        }
        return false;

    }

}
