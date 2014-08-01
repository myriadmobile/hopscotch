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
import android.graphics.RectF;
import android.os.Parcel;

/**
 * @see android.graphics.Path#addRoundRect(android.graphics.RectF, float[], android.graphics.Path.Direction)
 */
class AddRoundRectOp extends AbstractPathOp {

    private final RectF rect;
    private float[] radii;
    private final Path.Direction dir;

    public AddRoundRectOp(RectF rect, float[] radii, Path.Direction dir) {
        super(null);
        this.rect = rect;
        this.radii = radii;
        this.dir = dir;
    }

    public AddRoundRectOp(Parcel parcel) {
        super(parcel);

        rect = parcel.readParcelable(RectF.class.getClassLoader());
        dir = Path.Direction.values()[parcel.readInt()];
        parcel.readFloatArray(radii);
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_ROUND_RECT_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addRoundRect(rect, radii, dir);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(rect, 0);
        parcel.writeInt(dir.ordinal());
        parcel.writeFloatArray(radii);
    }
}
