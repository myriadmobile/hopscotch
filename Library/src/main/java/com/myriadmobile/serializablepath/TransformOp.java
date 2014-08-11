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
 * @see Path#transform(android.graphics.Matrix)
 */
class TransformOp extends AbstractPathOp {

    private SerializableMatrix matrix;

    public TransformOp(Matrix matrix) {
        super(null);
        this.matrix = new SerializableMatrix(matrix);
    }

    public TransformOp(SerializableMatrix matrix) {
        super(null);
        this.matrix = new SerializableMatrix(matrix);
    }

    public TransformOp(Parcel parcel) {
        super(parcel);
        matrix = parcel.readParcelable(SerializableMatrix.class.getClassLoader());
    }

    @Override
    protected int getOpId() {
        return AbstractPathOp.TRANSFORM_OP;
    }

    @Override
    void applyToPath(Path path) {
        path.transform(matrix.getMatrix());
    }

    @Override
    public void writeToParcel(Parcel parcel) {
        parcel.writeParcelable(matrix, 0);
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof TransformOp)) {
            return false;
        }

        TransformOp other = (TransformOp) o;

        return matrix.equals(other.matrix);
    }

    @Override
    public int hashCode() {
        int result = 213;
        result = 31 * result + matrix.hashCode();
        return result;
    }
}
