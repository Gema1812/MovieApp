package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView2;
    TextView dtl_name, dtl_id, dtl_ov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView2 = findViewById(R.id.imageView2);
        dtl_name = findViewById(R.id.dtl_name);
        dtl_id = findViewById(R.id.dtl_id);
        dtl_ov = findViewById(R.id.dtl_ov);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if (getIntent().hasExtra("detail_id") && getIntent().hasExtra("detail_name")
                && getIntent().hasExtra("detail_image") ){

            //&& getIntent().hasExtra("detail_overview")

            String detail_id = getIntent().getStringExtra("detail_id");
            String detail_name = getIntent().getStringExtra("detail_name");
            String detail_image = getIntent().getStringExtra("detail_image");
            String detail_overview = getIntent().getStringExtra("detail_overview");

            setDataActivity(detail_id, detail_name, detail_image, detail_overview);
        }
    }

    private void setDataActivity(String detail_id, String detail_name, String detail_image, String detail_overview){

        Glide.with(this).load(detail_image).into(imageView2);
        dtl_name.setText(detail_name);
        dtl_id.setText(detail_id);
        dtl_ov.setText(detail_overview);
    }
}