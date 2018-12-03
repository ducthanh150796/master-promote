package e.com.lib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImage extends AsyncTask<Void, Void, Bitmap> {
    private String link;
    private ImageView imageView;

    public LoadImage(String link, ImageView imageView) {
        this.link = link;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        URL url = null;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap mBitmap) {
        super.onPostExecute(mBitmap);
        if (mBitmap != null) {
            imageView.setImageBitmap(mBitmap);
        }
    }
}
