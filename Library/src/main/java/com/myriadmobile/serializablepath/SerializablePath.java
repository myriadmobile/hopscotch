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
import android.graphics.RectF;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A {@link java.io.Serializable} and {@link java.lang.Comparable} implementation of {@link android.graphics.Path}
 */
public class SerializablePath implements Serializable, Comparable<SerializablePath> {

    private Path.FillType mFillType = Path.FillType.WINDING;
    private ArrayList<AbstractPathOp> mOperations = new ArrayList<AbstractPathOp>();

    public SerializablePath(SerializablePath path) {
        this();
        //TODO do last after all other methods are accounted for
    }

    public SerializablePath() {
    }

    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addCircle(float x, float y, float radius, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addOval(RectF oval, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addPath(SerializablePath src, float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addPath(SerializablePath path) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    private void addPath(SerializablePath path, Matrix matrix) {
        //TODO needs impl
        //Matrix isn't Serializable!!! Do we support this method?
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addRect(float left, float top, float right, float bottom, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addRect(RectF rect, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addRoundRect(RectF rect, float[] radii, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void addRoundRect(RectF rect, float rx, float ry, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /* TODO Unimplemented methods
    * computeBounds()
    * isRect(RectF)
    */

    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Return the path's fill type. This defines how "inside" is
     * computed. The default value is WINDING.
     *
     * @see android.graphics.Path#getFillType()
     *
     * @return the path's fill type
     */
    public Path.FillType getFillType() {
        return mFillType;
    }

    /**
     * Hint to the path to prepare for adding more points. This can allow the
     * path to more efficiently allocate its storage.
     *
     * This implementation increases the size of the backing {@link java.util.ArrayList}
     *
     * @see Path#incReserve(int)
     *
     * @param extraPtCount The number of extra points that may be added to this
     *                     path
     */
    public void incReserve(int extraPtCount) {
        mOperations.ensureCapacity(mOperations.size() + (extraPtCount/2));
    }

    /**
     * Returns true if the path is empty (contains no lines or curves)
     *
     * @see android.graphics.Path#isEmpty()
     *
     * @return true if the path is empty (contains no lines or curves)
     */
    public boolean isEmpty() {
        return mOperations.isEmpty();
    }

    /**
     * Returns true if the filltype is one of the INVERSE variants
     *
     * @see android.graphics.Path#isInverseFillType()
     *
     * @return true if the filltype is one of the INVERSE variants
     */
    public boolean isInverseFillType() {
        return mFillType == Path.FillType.INVERSE_EVEN_ODD || mFillType == Path.FillType.INVERSE_WINDING;
    }

    public void lineTo(float x, float y) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void moveTo(float x, float y) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void offset(float dx, float dy, SerializablePath path) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void quadTo(float x1, float y1, float x2, float y2) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void rLineTo(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void rMoveTo(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void rQuadTo(float dx1, float dy1, float dx2, float dy2) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Clear any lines and curves from the path, making it empty.
     * This does NOT change the fill-type setting.
     *
     * @see android.graphics.Path#reset()
     */
    public void reset() {
        mOperations.clear();
    }

    /**
     * Rewinds the path: clears any lines and curves from the path but
     * keeps the internal data structure for faster reuse.
     *
     * This implementation is the same as {@link #reset()}
     *
     * @see android.graphics.Path#reset()
     */
    public void rewind() {
        mOperations.clear();
    }

    public void set(SerializablePath path) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Set the path's fill type. This defines how "inside" is computed.
     *
     * @see Path#setFillType(android.graphics.Path.FillType)
     *
     * @param ft The new fill type for this path
     */
    public void setFillType(Path.FillType ft) {
        this.mFillType = ft;
    }

    public void setLastPoint(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Toggles the INVERSE state of the filltype
     *
     * @see android.graphics.Path#toggleInverseFillType()
     */
    public void toggleInverseFillType() {
        switch (mFillType) {
            case WINDING: mFillType = Path.FillType.INVERSE_WINDING; break;
            case EVEN_ODD: mFillType = Path.FillType.INVERSE_EVEN_ODD; break;
            case INVERSE_WINDING: mFillType = Path.FillType.WINDING; break;
            case INVERSE_EVEN_ODD: mFillType = Path.FillType.EVEN_ODD; break;
            default: mFillType = Path.FillType.WINDING; break;
        }
    }

    private void transform(Matrix matrix, SerializablePath dst) {
        //TODO needs impl
        //Uses Matrix, which isn't Serializable!!!
        throw new UnsupportedOperationException("Needs implementation");
    }

    private void transform(Matrix matrix) {
        //TODO needs impl
        //Uses Matrix, which isn't Serializable!!!
        throw new UnsupportedOperationException("Needs implementation");
    }

    public Path makePath() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    @Override
    public int compareTo(SerializablePath path) {
        //TODO needs impl
        return 0;
    }


}
