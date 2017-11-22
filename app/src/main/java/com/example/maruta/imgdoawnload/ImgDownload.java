package com.example.maruta.imgdoawnload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImgDownload extends AsyncTask<String, Void, Bitmap>{

    Bitmap image;

    @Override
    protected Bitmap doInBackground(String... strings) {


        try {
            URL url = new URL(strings[0]);

            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            con.connect();

            InputStream in = con.getInputStream();

            image = BitmapFactory.decodeStream(in);

            return image;

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }
}
