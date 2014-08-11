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
 * @see Path#addArc(android.graphics.RectF, float, float)
 */
class AddArcOp extends AbstractPathOp {
    private final RectF oval;
    private final float startAngle;
    private final float sweepAngle;

    public AddArcOp(RectF oval, float startAngle, float sweepAngle) {
        super(null);
        this.oval = oval;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
    }

    public AddArcOp(Parcel parcel) {
        super(parcel);
        this.oval = parcel.readParcelable(RectF.class.getClassLoader());
        this.startAngle = parcel.readFloat();
        this.sweepAngle = parcel.readFloat();
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_ARC_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addArc(oval, startAngle, sweepAngle);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(oval, 0);
        parcel.writeFloat(startAngle);
        parcel.writeFloat(sweepAngle);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof AddArcOp)) {
            return false;
        }

        AddArcOp other = (AddArcOp) o;

        return oval.equals(other.oval) &&
                startAngle == other.startAngle &&
                sweepAngle == other.sweepAngle;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + Float.floatToIntBits(startAngle);
        result = 31 * result + Float.floatToIntBits(sweepAngle);
        result = 31 * result + oval.hashCode();
        return result;
    }
}
