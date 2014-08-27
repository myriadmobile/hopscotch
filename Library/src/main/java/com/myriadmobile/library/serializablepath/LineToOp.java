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
import android.os.Parcel;

/**
 * @see Path#lineTo(float, float)
 */
class LineToOp extends AbstractPathOp {

    private final float x;
    private final float y;
    private final Boolean r;

    public LineToOp(float x, float y) {
        super(null);
        this.x = x;
        this.y = y;
        this.r = null;
    }

    public LineToOp(float dx, float dy, boolean r) {
        super(null);
        this.x = dx;
        this.y = dy;
        this.r = r;
    }

    public LineToOp(Parcel parcel) {
        super(parcel);

        x = parcel.readFloat();
        y = parcel.readFloat();
        r = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.LINE_TO_OP;
    }

    @Override
    void applyToPath(Path path) {
        if(r == null) {
            path.lineTo(x, y);
        }
        else {
            path.rLineTo(x, y);
        }
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeFloat(x);
        parcel.writeFloat(y);
        parcel.writeValue(r);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof LineToOp)) {
            return false;
        }

        LineToOp other = (LineToOp) o;

        boolean rr = (r == null && other.r == null) || (r != null && r.equals(other.r));
        return  rr &&
                x == other.x &&
                y == other.y;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + (r != null && r ? 0 : 1);
        result = 31 * result + Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        return result;
    }
}
