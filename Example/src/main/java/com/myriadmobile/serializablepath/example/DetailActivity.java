/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Myriad Mobile
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.myriadmobile.serializablepath.example;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import com.myriadmobile.serializablepath.SerializablePath;

/**
 * Receiver for sent {@link com.myriadmobile.serializablepath.SerializablePath}s
 */
public class DetailActivity extends Activity {

    public static final String TAG = DetailActivity.class.getSimpleName();

    public static final String EXTRA_PATH_PARCELABLE = "com.myriadmobile.serializablepath.example.EXTRA_PATH_PARCELABLE";
    public static final String EXTRA_PATH_SERIALIZABLE = "com.myriadmobile.serializablepath.example.EXTRA_PATH_SERIALIZABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SerializablePath path = getIntent().getParcelableExtra(EXTRA_PATH_PARCELABLE);
        SerializablePath path2 = (SerializablePath) getIntent().getSerializableExtra(EXTRA_PATH_SERIALIZABLE);

        Log.d(TAG, "Hash: " + path.hashCode() + " Hash2: " + path2.hashCode());
        Log.d(TAG, "Equals: " + path.equals(path2));

        Matrix matrix = new Matrix();
        matrix.postRotate(45f, 100, 100);
        path.transform(matrix);

        SimplePathView image1 = (SimplePathView) findViewById(R.id.image_path1);
        image1.setPath(path.makePath());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4fbfb4"));
        image1.setPaint(paint);

        matrix = new Matrix();
        matrix.postScale(1.25f, 1.25f);
        matrix.postSkew(0.2f, 0);
        path2.transform(matrix);

        SimplePathView image2 = (SimplePathView) findViewById(R.id.image_path2);
        image2.setPath(path2.makePath());
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#198a92"));
        image2.setPaint(paint2);

        Log.d(TAG, "Hash: " + path.hashCode() + " Hash2: " + path2.hashCode());
        Log.d(TAG, "Equals: " + path.equals(path2));
    }
}
