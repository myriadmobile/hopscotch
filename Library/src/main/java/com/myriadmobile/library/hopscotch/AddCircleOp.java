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

package com.myriadmobile.library.hopscotch;

import android.graphics.Path;
import android.os.Parcel;

/**
 * @see Path#addCircle(float, float, float, android.graphics.Path.Direction)
 */
class AddCircleOp extends AbstractPathOp {

    private final float x;
    private final float y;
    private final float radius;
    private final Path.Direction dir;

    public AddCircleOp(float x, float y, float radius, Path.Direction dir) {
        super(null);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dir = dir;
    }

    public AddCircleOp(Parcel parcel) {
        super(parcel);
        x = parcel.readFloat();
        y = parcel.readFloat();
        radius = parcel.readFloat();
        dir = Path.Direction.values()[parcel.readInt()];
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_CIRCLE_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addCircle(x, y, radius, dir);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeFloat(x);
        parcel.writeFloat(y);
        parcel.writeFloat(radius);
        parcel.writeInt(dir.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof AddCircleOp)) {
            return false;
        }

        AddCircleOp other = (AddCircleOp) o;

        return x == other.x &&
                y == other.y &&
                radius == other.radius &&
                dir == other.dir;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(radius);
        result = 31 * result + dir.hashCode();
        return result;
    }
}
