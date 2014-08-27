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
import android.graphics.RectF;
import android.os.Parcel;

/**
 * @see Path#addOval(android.graphics.RectF, android.graphics.Path.Direction)
 */
class AddOvalOp extends AbstractPathOp {

    private final RectF oval;
    private final Path.Direction dir;

    public AddOvalOp(RectF oval, Path.Direction dir) {
        super(null);
        this.oval = oval;
        this.dir = dir;
    }

    public AddOvalOp(Parcel parcel) {
        super(parcel);

        oval = parcel.readParcelable(RectF.class.getClassLoader());
        dir = Path.Direction.values()[parcel.readInt()];
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_OVAL_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addOval(oval, dir);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(oval, 0);
        parcel.writeInt(dir.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof AddOvalOp)) {
            return false;
        }

        AddOvalOp other = (AddOvalOp) o;

        return oval.equals(other.oval) &&
                dir == other.dir;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + dir.hashCode();
        result = 31 * result + oval.hashCode();
        return result;
    }
}
