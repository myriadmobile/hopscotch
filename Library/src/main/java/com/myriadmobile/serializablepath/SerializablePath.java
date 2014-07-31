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

/**
 * A {@link java.io.Serializable} and {@link java.lang.Comparable} implementation of {@link android.graphics.Path}
 */
public class SerializablePath implements Serializable, Comparable<SerializablePath> {

    public SerializablePath(SerializablePath path) {
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

    public Path.FillType getFillType() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void incReserve(int extraPtCount) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public boolean isEmpty() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public boolean isInverseFillType() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
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

    public void reset() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void rewind() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void set(SerializablePath path) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void setFillType(Path.FillType ft) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void setLastPoint(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    public void toggleInverseFillType() {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
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
