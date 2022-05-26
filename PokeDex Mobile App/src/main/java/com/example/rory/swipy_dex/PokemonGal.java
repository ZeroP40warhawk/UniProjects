package com.example.rory.swipy_dex;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class PokemonGal extends AppCompatActivity {

    private ProgressBar spinner;

    public int i = 0;
    String pathToFile []= {
            "https://images5.alphacoders.com/481/481904.jpg",
            "https://images2.alphacoders.com/206/206292.jpg","https://images6.alphacoders.com/326/326467.jpg",
            "https://images7.alphacoders.com/381/381583.jpg","https://images4.alphacoders.com/149/149386.jpg",
            "https://images5.alphacoders.com/613/613927.jpg","https://images4.alphacoders.com/119/119638.jpg",
            "https://images3.alphacoders.com/434/43499.jpg","https://images5.alphacoders.com/481/481911.jpg"
    };
    public Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_gal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView bindImage = (ImageView)findViewById(R.id.imageView);
        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(bindImage);
        downloadTask.execute(pathToFile[i]);
    }

    public void back (View view) {
        if (i == 0)
        {
            i = pathToFile.length-1;
            refresh(i);
        }
        else{
            i = i-1;
            refresh(i);
        }
    }

    public void next (View view) {
        if (i == pathToFile.length-1)
        {
            i = 0;
            refresh(i);
        }
        else
        {
            i= i+1;
            refresh(i);
        }
    }

    public void setAs (View view) throws IOException {
        WallpaperManager wallpaperManager =
                WallpaperManager.getInstance(getApplicationContext());
        wallpaperManager.setBitmap(bitmap);
        Toast.makeText(PokemonGal.this, "Wallpaper Changed", Toast.LENGTH_SHORT).show();
    }

    public void refresh(int num)
    {
        ImageView bindImage = (ImageView)findViewById(R.id.imageView);
        DownloadImageWithURLTask downloadTask = new DownloadImageWithURLTask(bindImage);
        downloadTask.execute(pathToFile[i]);
    }

    private class DownloadImageWithURLTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageWithURLTask(ImageView bmImage) {
            this.bmImage = bmImage;

        }
        protected Bitmap doInBackground(String... urls) {
            String pathToFile = urls[0];
             bitmap = null;
            try {
                InputStream in = new java.net.URL(pathToFile).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

            return bitmap;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
            spinner.setVisibility(View.GONE);
        }
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

}
