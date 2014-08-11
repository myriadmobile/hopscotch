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
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;

/**
 * {@link java.io.Serializable} and {@link android.os.Parcelable } version
 * of {@link android.graphics.Matrix}
 */
public class SerializableMatrix implements Serializable, Parcelable {

    private float[] values;

    public SerializableMatrix(Matrix matrix) {
        setMatrix(matrix);
    }

    public SerializableMatrix(Parcel parcel) {
        values = new float[9];
        parcel.readFloatArray(values);
    }

    public SerializableMatrix(SerializableMatrix matrix) {
        setMatrix(matrix);
    }

    private void setMatrix(SerializableMatrix matrix) {
        values = Arrays.copyOf(matrix.values, 9);
    }

    public void setMatrix(Matrix matrix) {
        values = new float[9];
        matrix.getValues(values);
    }

    public Matrix getMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(values);
        return matrix;
    }

    //
    //
    // Parcelable stuff below
    //
    //

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloatArray(values);
    }

    public static final Creator<SerializableMatrix> CREATOR = new Creator<SerializableMatrix>() {

        @Override
        public SerializableMatrix createFromParcel(Parcel parcel) {
            return new SerializableMatrix(parcel);
        }

        @Override
        public SerializableMatrix[] newArray(int i) {
            return new SerializableMatrix[i];
        }
    };

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof SerializableMatrix)) {
            return false;
        }

        return Arrays.equals(values, ((SerializableMatrix) o).values);
    }

    @Override
    public int hashCode() {
        int result = 151;
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
