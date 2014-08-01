package com.myriadmobile.serializablepath.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.myriadmobile.serializablepath.SerializablePath;

import java.io.Serializable;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SerializablePath path = getPath();

        Button button = (Button) findViewById(R.id.button_test_serialization);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PATH_PARCELABLE, (Parcelable) path);
                intent.putExtra(DetailActivity.EXTRA_PATH_SERIALIZABLE, (Serializable) path);
                startActivity(intent);
            }
        });

        SimplePathView image = (SimplePathView) findViewById(R.id.image_path);
        image.setPath(path.makePath());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        paint.setColor(Color.RED);
        image.setPaint(paint);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_view_github) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/myriadmobile/serializable-path"));
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static SerializablePath getPath() {

        SerializablePath path = new SerializablePath();
        path.rMoveTo(10, 10);
        path.lineTo(90, 10);
        path.quadTo(90, 90, 10, 90);
        path.close();

        return path;
    }
}
