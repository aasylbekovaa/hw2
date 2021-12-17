package com.example.homework2;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    ImageView imImage;
    EditText etComment;
    Button btnSendDataToMainActivity;
    String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        listener();

    }


    private void initView() {
        imImage = findViewById(R.id.im_image);
        etComment = findViewById(R.id.et_comment);
        btnSendDataToMainActivity = findViewById(R.id.btn_send_data_to_main_activity);
    }


    private void listener() {
        imImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultLauncher.launch("image/*");

            }
        });
        btnSendDataToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etComment.getText().toString();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("Key" , data);
                intent.putExtra("image", image);
                startActivity(intent);

            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    image = uri.toString();
                    imImage.setImageURI(uri);
                }
            });
}

