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
import android.graphics.Path;
import android.os.Bundle;

import com.myriadmobile.serializablepath.SerializablePath;

/**
 *
 */
public class DetailActivity extends Activity {

    public static final String EXTRA_PATH_PARCELABLE = "com.myriadmobile.serializablepath.example.EXTRA_PATH_PARCELABLE";
    public static final String EXTRA_PATH_SERIALIZABLE = "com.myriadmobile.serializablepath.example.EXTRA_PATH_SERIALIZABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SerializablePath path = getIntent().getParcelableExtra(EXTRA_PATH_PARCELABLE);
        Path realPath = path.makePath();

        SerializablePath path2 = (SerializablePath) getIntent().getSerializableExtra(EXTRA_PATH_SERIALIZABLE);
        Path realPath2 = path2.makePath();
    }
}
