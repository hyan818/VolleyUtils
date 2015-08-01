package com.beyond.volleyutils.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.beyond.volleyutils.BaseVolley;
import com.beyond.volleyutils.RequestImage;
import com.beyond.volleyutils.RequestInfo;
import com.beyond.volleyutils.extra.SimpleResponseListener;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.image);
        requestData();
    }

    private void requestData() {
        RequestInfo requestInfo = new RequestInfo.Builder().requestUrl("http://i.imgur.com/7spzG.png").build();
        RequestImage requestImage = new RequestImage(this, requestInfo);
        requestImage.get(TAG, new SimpleResponseListener<Bitmap>() {
            @Override
            public void onSuccess(Bitmap response) {
                mImageView.setImageBitmap(response);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseVolley.getInstance(this).stop(TAG);
    }
}
