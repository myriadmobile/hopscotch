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
import android.os.Parcelable;

/**
 * Abstract class to holds information about different ops made onto
 * a {@link com.myriadmobile.serializablepath.SerializablePath} so it can be
 * serialized out and recreated later
 */
abstract class AbstractPathOp implements Parcelable {

    public static final Creator<AbstractPathOp> CREATOR = new Creator<AbstractPathOp>() {

        @Override
        public AbstractPathOp createFromParcel(Parcel parcel) {
            try {
                return (AbstractPathOp) Class.forName(parcel.readString()).getConstructor(Parcel.class).newInstance(parcel);
            } catch (Exception e) {
                throw new RuntimeException("This shouldn't be a thing", e);
            }
        }

        @Override
        public AbstractPathOp[] newArray(int i) {
            return new AbstractPathOp[i];
        }
    };

    protected AbstractPathOp(Parcel parcel) {
        //Here so subclasses are required to implement this constructor
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getCanonicalName());
        writeToParcel(parcel);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    abstract void applyToPath(Path path);
    abstract void writeToParcel(Parcel parcel);
}
