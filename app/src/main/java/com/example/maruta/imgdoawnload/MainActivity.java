package com.example.maruta.imgdoawnload;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imageView);


    }

    public void download(View v){

        ImgDownload task = new ImgDownload();

        Bitmap bitMap;

        try {
            bitMap = task.execute("https://upload.wikimedia.org/wikipedia/en/7/70/Bart_Simpson_-_Skateboarding.png").get();

            img.setImageBitmap(bitMap);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
