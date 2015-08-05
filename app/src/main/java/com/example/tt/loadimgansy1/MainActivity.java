package com.example.tt.loadimgansy1;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class MainActivity extends ActionBarActivity {
    private final String imgUrl = "http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView img = (ImageView) findViewById(R.id.image);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplication()).build();
        ImageLoader.getInstance().init(configuration);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.loadImage(imgUrl, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                String rea = failReason.toString();
                //Toast.makeText(this, rea ,Toast.LENGTH_LONG).show();
                Log.d("TAG",  rea);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    img.setImageBitmap(loadedImage);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }




}
