package com.example.homework2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imImage;
    TextView tvMeaning;
    Button btnOpenToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imImage = findViewById(R.id.main_image);
        tvMeaning = findViewById(R.id.tv_meaning);
        btnOpenToSecondActivity = findViewById(R.id.btn_open_second_activity);


        btnOpenToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String getData = intent.getStringExtra("Key");
        String image = intent.getStringExtra("image");
        tvMeaning.setText(getData);
        if(image != null){
            imImage.setImageURI(Uri.parse(image));
        }
    }
}

