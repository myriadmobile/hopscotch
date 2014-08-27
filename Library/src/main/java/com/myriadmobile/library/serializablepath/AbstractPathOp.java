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
import android.os.Parcelable;

/**
 * Abstract class to holds information about different ops made onto
 * a {@link com.myriadmobile.library.serializablepath.SerializablePath} so it can be
 * serialized out and recreated later
 */
abstract class AbstractPathOp implements Parcelable {

    static final int ADD_ARC_OP = 2;
    static final int ADD_CIRCLE_OP = 3;
    static final int ADD_OVAL_OP = 4;
    static final int ADD_PATH_OP = 5;
    static final int ADD_RECT_OP = 6;
    static final int ADD_ROUND_RECT_OP = 7;
    static final int ADD_ROUND_RECT_XY_OP = 8;
    static final int ARC_TO_OP = 9;
    static final int CLOSE_OP = 10;
    static final int CUBIC_TO_OP = 11;
    static final int LINE_TO_OP = 12;
    static final int MOVE_TO_OP = 13;
    static final int OFFSET_OP = 14;
    static final int QUAD_TO_OP = 15;
    static final int SET_LAST_POINT_OP = 16;
    static final int TRANSFORM_OP = 17;

    public static final Creator<AbstractPathOp> CREATOR = new Creator<AbstractPathOp>() {

        @Override
        public AbstractPathOp createFromParcel(Parcel parcel) {
            int opId = parcel.readInt();
            return makeInstance(opId, parcel);
        }

        @Override
        public AbstractPathOp[] newArray(int i) {
            return new AbstractPathOp[i];
        }
    };

    /**
     * Constructor used to make an instance from unmarshalling
     * @param parcel the Parcel storing data to restore from
     */
    protected AbstractPathOp(Parcel parcel) {
        //nothing to see here, move along
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getOpId());
        writeToParcel(parcel);
    }

    /**
     * Get the type id as defined by the *_OP constants in {@link com.myriadmobile.library.serializablepath.AbstractPathOp}
     * @return
     */
    protected abstract int getOpId();

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Apply the operation to an actual {@link android.graphics.Path}
     * @param path the Path to apply the operation to
     */
    abstract void applyToPath(Path path);

    /**
     * subclasses write data to the parcel in this method, not {@link #writeToParcel(android.os.Parcel, int)}
     * @param parcel
     */
    abstract void writeToParcel(Parcel parcel);

    /**
     * Make a new concrete class instance of {@link com.myriadmobile.library.serializablepath.AbstractPathOp}
     * @param id the Op type id
     * @param parcel the data
     * @return an concrete instance of {@link com.myriadmobile.library.serializablepath.AbstractPathOp}
     */
    private static AbstractPathOp makeInstance(int id, Parcel parcel) {
        switch (id) {
            case ADD_ARC_OP: return new AddArcOp(parcel);
            case ADD_CIRCLE_OP: return new AddCircleOp(parcel);
            case ADD_OVAL_OP: return new AddOvalOp(parcel);
            case ADD_PATH_OP: return new AddPathOp(parcel);
            case ADD_RECT_OP: return new AddRectOp(parcel);
            case ADD_ROUND_RECT_OP: return new AddRoundRectOp(parcel);
            case ADD_ROUND_RECT_XY_OP: return new AddRoundRectXYOp(parcel);
            case ARC_TO_OP: return new ArcToOp(parcel);
            case CLOSE_OP: return new CloseOp(parcel);
            case CUBIC_TO_OP: return new CubicToOp(parcel);
            case LINE_TO_OP: return new LineToOp(parcel);
            case MOVE_TO_OP: return new MoveToOp(parcel);
            case OFFSET_OP: return new OffsetOp(parcel);
            case QUAD_TO_OP: return new QuadToOp(parcel);
            case SET_LAST_POINT_OP: return new SetLastPointOp(parcel);
            case TRANSFORM_OP: return new TransformOp(parcel);
        }
        return null;
    }
}
