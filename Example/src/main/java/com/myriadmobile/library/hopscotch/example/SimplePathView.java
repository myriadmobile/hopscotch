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

package com.myriadmobile.library.hopscotch.example;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 */
public class SimplePathView extends View {

    private Path mPath;
    private Paint mPaint;

    public SimplePathView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public SimplePathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }


    private RectF bounds = new RectF();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mPath != null && mPaint != null) {
            canvas.save();
            mPath.computeBounds(bounds, false);
            canvas.translate((getWidth()/2)-(bounds.width()/2), (getHeight()/2)-(bounds.height()/2));
            canvas.drawPath(mPath, mPaint);
            canvas.restore();
        }
    }

    public void setPath(Path path) {
        this.mPath = path;
        postInvalidate();
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
        postInvalidate();
    }
}
