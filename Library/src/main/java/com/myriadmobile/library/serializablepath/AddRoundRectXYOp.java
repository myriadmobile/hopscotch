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

package com.myriadmobile.library.serializablepath;

import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;

/**
 * @see android.graphics.Path#addRoundRect(android.graphics.RectF, float, float, android.graphics.Path.Direction)
 */
class AddRoundRectXYOp extends AbstractPathOp {

    private final RectF rect;
    private final float rx;
    private final float ry;
    private final Path.Direction dir;

    public AddRoundRectXYOp(RectF rect, float rx, float ry, Path.Direction dir) {
        super(null);
        this.rect = rect;
        this.rx = rx;
        this.ry = ry;
        this.dir = dir;
    }

    public AddRoundRectXYOp(Parcel parcel) {
        super(parcel);

        rect = parcel.readParcelable(RectF.class.getClassLoader());
        dir = Path.Direction.values()[parcel.readInt()];
        rx = parcel.readFloat();
        ry = parcel.readFloat();
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_ROUND_RECT_XY_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addRoundRect(rect, rx, ry, dir);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(rect, 0);
        parcel.writeInt(dir.ordinal());
        parcel.writeFloat(rx);
        parcel.writeFloat(ry);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof AddRoundRectXYOp)) {
            return false;
        }

        AddRoundRectXYOp other = (AddRoundRectXYOp) o;

        return rect.equals(other.rect) &&
                rx == other.rx &&
                ry == other.ry &&
                dir == other.dir;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + dir.hashCode();
        result = 31 * result + Float.floatToIntBits(rx);
        result = 31 * result + Float.floatToIntBits(ry);
        result = 31 * result + rect.hashCode();
        return result;
    }
}
