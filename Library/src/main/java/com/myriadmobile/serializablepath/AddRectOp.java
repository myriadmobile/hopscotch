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
 * @see android.graphics.Path#addRect(android.graphics.RectF, android.graphics.Path.Direction)
 */
class AddRectOp extends AbstractPathOp {

    private final RectF rect;
    private final Path.Direction dir;

    public AddRectOp(RectF rect, Path.Direction dir) {
        super(null);
        this.rect = rect;
        this.dir = dir;
    }

    public AddRectOp(float left, float top, float right, float bottom, Path.Direction dir) {
        super(null);
        this.rect = new RectF(left, top, right, bottom);
        this.dir = dir;
    }

    public AddRectOp(Parcel parcel) {
        super(parcel);

        rect = parcel.readParcelable(RectF.class.getClassLoader());
        dir = Path.Direction.values()[parcel.readInt()];
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_RECT_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.addRect(rect, dir);
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(rect, 0);
        parcel.writeInt(dir.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof AddRectOp)) {
            return false;
        }

        AddRectOp other = (AddRectOp) o;

        return dir.equals(other.dir) && rect.equals(other.rect);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + dir.hashCode();
        result = 31 * result + rect.hashCode();
        return result;
    }
}
