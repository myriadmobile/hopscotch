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

import android.graphics.Matrix;
import android.graphics.Path;
import android.os.Parcel;

/**
 * @see android.graphics.Path#addPath(android.graphics.Path, float, float)
 *
 * @see android.graphics.Path#addPath(android.graphics.Path)
 */
class AddPathOp extends AbstractPathOp {

    private final SerializablePath sPath;
    private final Float dx;
    private final Float dy;

    public AddPathOp(SerializablePath path, float dx, float dy) {
        super(null);
        this.sPath = path;
        this.dx = dx;
        this.dy = dy;
    }

    public AddPathOp(SerializablePath path) {
        super(null);
        this.sPath = path;
        this.dx = null;
        this.dy = null;
    }

    public AddPathOp(SerializablePath path, Matrix matrix) {
        super(null);
        this.sPath = new SerializablePath(path);
        sPath.transform(matrix);
        this.dx = null;
        this.dy = null;
    }

    public AddPathOp(SerializablePath path, SerializableMatrix matrix) {
        super(null);
        this.sPath = new SerializablePath(path);
        sPath.transform(matrix);
        this.dx = null;
        this.dy = null;
    }

    public AddPathOp(Parcel parcel) {
        super(parcel);

        sPath = parcel.readParcelable(SerializablePath.class.getClassLoader());
        dx = (Float) parcel.readValue(Float.class.getClassLoader());
        dy = (Float) parcel.readValue(Float.class.getClassLoader());
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.ADD_PATH_OP;
    }

    @Override
    void applyToPath(Path path) {
        if(dx != null && dy != null) {
            path.addPath(sPath.makePath(), dx, dy);
        }
        else {
            path.addPath(sPath.makePath());
        }
    }

    @Override
    void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(sPath, 0);
        parcel.writeValue(dx);
        parcel.writeValue(dy);
    }
}
