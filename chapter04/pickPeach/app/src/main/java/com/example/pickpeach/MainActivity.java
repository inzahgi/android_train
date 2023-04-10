package com.example.pickpeach;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_peach;
    private TextView tv_count;
    private int totalCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn_peach = findViewById(R.id.btn_peach);
        tv_count = findViewById(R.id.tv_count);
        btn_peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PeachActivity.class);
                startActivityForResult(intent, 1);

                //todo new method
//                ActivityResultLauncher<Intent> intentActivityResultLauncher = registerForActivityResult(
//                        new ActivityResultContracts.StartActivityForResult(),
//                        new ActivityResultCallback<ActivityResult>() {
//                            @Override
//                            public void onActivityResult(ActivityResult result) {
//                                if(result.getData() != null && result.getResultCode() == Activity.RESULT_OK) {
//                                    //String data = result.getData().getStringExtra("count");
//                                    //Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
//                                    int count = result.getData().getIntExtra("count", 0);
//                                    totalCount = totalCount + count;
//                                    tv_count.setText("摘到" + totalCount + "个");
//                                }
//                            }
//                        }
//                );
//                intentActivityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 1) {
            int count = data.getIntExtra("count", 0);
            totalCount = totalCount + count;
            tv_count.setText("摘到" + totalCount + "个");
        }
    }
}