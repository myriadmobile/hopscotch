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
 * @see android.graphics.Path#cubicTo(float, float, float, float, float, float)
 */
class CubicToOp extends AbstractPathOp {

    private final float x1;
    private final float y1;
    private final float x2;
    private final float y2;
    private final float x3;
    private final float y3;
    private final Boolean r;

    public CubicToOp(float x1, float y1, float x2, float y2, float x3, float y3) {
        super(null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.r = null;
    }

    public CubicToOp(float x1, float y1, float x2, float y2, float x3, float y3, boolean r) {
        super(null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.r = r;
    }

    public CubicToOp(Parcel parcel) {
        super(parcel);

        x1 = parcel.readFloat();
        y1 = parcel.readFloat();
        x2 = parcel.readFloat();
        y2 = parcel.readFloat();
        x3 = parcel.readFloat();
        y3 = parcel.readFloat();
        r = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.CUBIC_TO_OP;
    }

    @Override
    void applyToPath(Path path) {
        if(r == null) {
            path.cubicTo(x1, y1, x2, y2, x3, y3);
        }
        else {
            path.rCubicTo(x1, y1, x2, y2, x3, y3);
        }
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeFloat(x1);
        parcel.writeFloat(y1);
        parcel.writeFloat(x2);
        parcel.writeFloat(y2);
        parcel.writeFloat(x3);
        parcel.writeFloat(y3);
        parcel.writeValue(r);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof CubicToOp)) {
            return false;
        }

        CubicToOp other = (CubicToOp) o;

        boolean rr = (r == null && other.r == null) || (r != null && r.equals(other.r));
        return rr &&
                x1 == other.x1 &&
                y1 == other.y1 &&
                x2 == other.x2 &&
                y2 == other.y2 &&
                x3 == other.x3 &&
                y3 == other.y3;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + (r != null && r ? 0 : 1);
        result = 31 * result + Float.floatToIntBits(x1);
        result = 31 * result + Float.floatToIntBits(y1);
        result = 31 * result + Float.floatToIntBits(x2);
        result = 31 * result + Float.floatToIntBits(y2);
        result = 31 * result + Float.floatToIntBits(x3);
        result = 31 * result + Float.floatToIntBits(y3);
        return result;
    }
}
