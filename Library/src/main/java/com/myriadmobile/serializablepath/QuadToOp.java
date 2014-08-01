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

package com.myriadmobile.serializablepath;

import android.graphics.Path;
import android.os.Parcel;

/**
 * @see android.graphics.Path#quadTo(float, float, float, float)
 */
public class QuadToOp extends AbstractPathOp {

    private final float x1;
    private final float y1;
    private final float x2;
    private final float y2;
    private final Boolean r;

    public QuadToOp(float x1, float y1, float x2, float y2) {
        super(null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = null;
    }

    public QuadToOp(float x1, float y1, float x2, float y2, boolean r) {
        super(null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
    }

    protected QuadToOp(Parcel parcel) {
        super(parcel);

        x1 = parcel.readFloat();
        y1 = parcel.readFloat();
        x2 = parcel.readFloat();
        y2 = parcel.readFloat();
        r = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override
    void applyToPath(Path path) {
        if(r == null) {
            path.quadTo(x1, y1, x2, y2);
        }
        else {
            path.rQuadTo(x1, y1, x2, y2);
        }
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeFloat(x1);
        parcel.writeFloat(y1);
        parcel.writeFloat(x2);
        parcel.writeFloat(y2);
        parcel.writeValue(r);
    }
}
