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

    private Path.FillType mFillType;
    private ArrayList<AbstractPathOp> mOperations;

    /**
     * Create a new path, copying the contents from the src path.
     *
     * @param path The path to copy from when initializing the new path
     */
    public SerializablePath(SerializablePath path) {
        this();
        set(path);
    }

    /**
     * Create an empty path
     */
    public SerializablePath() {
        mFillType = Path.FillType.WINDING;
        mOperations = new ArrayList<AbstractPathOp>();
    }

    /**
     * Add the specified arc to the path as a new contour.
     *
     * @see android.graphics.Path#addArc(android.graphics.RectF, float, float)
     *
     * @param oval The bounds of oval defining the shape and size of the arc
     * @param startAngle Starting angle (in degrees) where the arc begins
     * @param sweepAngle Sweep angle (in degrees) measured clockwise
     */
    public void addArc(RectF oval, float startAngle, float sweepAngle) {
        mOperations.add(new AddArcOp(oval, startAngle, sweepAngle));
    }

    /**
     * Add a closed circle contour to the path
     *
     * @see android.graphics.Path#addCircle(float, float, float, android.graphics.Path.Direction)
     *
     * @param x   The x-coordinate of the center of a circle to add to the path
     * @param y   The y-coordinate of the center of a circle to add to the path
     * @param radius The radius of a circle to add to the path
     * @param dir    The direction to wind the circle's contour
     */
    public void addCircle(float x, float y, float radius, Path.Direction dir) {
        mOperations.add(new AddCircleOp(x, y, radius, dir));
    }

    /**
     * Add a closed oval contour to the path
     *
     * @see android.graphics.Path#addOval(android.graphics.RectF, android.graphics.Path.Direction)
     *
     * @param oval The bounds of the oval to add as a closed contour to the path
     * @param dir  The direction to wind the oval's contour
     */
    public void addOval(RectF oval, Path.Direction dir) {
        mOperations.add(new AddOvalOp(oval, dir));
    }

    /**
     * Add a copy of src to the path, offset by (dx,dy)
     *
     * @see android.graphics.Path#addPath(android.graphics.Path, float, float)
     *
     * @param src The path to add as a new contour
     * @param dx  The amount to translate the path in X as it is added
     */
    public void addPath(SerializablePath src, float dx, float dy) {
        mOperations.add(new AddPathOp(src, dx, dy));
    }

    /**
     * Add a copy of src to the path
     *
     * @see android.graphics.Path#addPath(android.graphics.Path)
     *
     * @param path The path that is appended to the current path
     */
    public void addPath(SerializablePath path) {
        mOperations.add(new AddPathOp(path));
    }

    private void addPath(SerializablePath path, Matrix matrix) {
        //Matrix isn't Serializable!!! Do we support this method?
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Add a closed rectangle contour to the path
     *
     * @see android.graphics.Path#addRect(float, float, float, float, android.graphics.Path.Direction)
     *
     * @param left   The left side of a rectangle to add to the path
     * @param top    The top of a rectangle to add to the path
     * @param right  The right side of a rectangle to add to the path
     * @param bottom The bottom of a rectangle to add to the path
     * @param dir    The direction to wind the rectangle's contour
     */
    public void addRect(float left, float top, float right, float bottom, Path.Direction dir) {
        mOperations.add(new AddRectOp(left, top, right, bottom, dir));
    }

    /**
     * Add a closed rectangle contour to the path
     *
     * @see android.graphics.Path#addRect(android.graphics.RectF, android.graphics.Path.Direction)
     *
     * @param rect The rectangle to add as a closed contour to the path
     * @param dir  The direction to wind the rectangle's contour
     */
    public void addRect(RectF rect, Path.Direction dir) {
        mOperations.add(new AddRectOp(rect, dir));
    }

    /**
     * Add a closed round-rectangle contour to the path. Each corner receives
     * two radius values [X, Y]. The corners are ordered top-left, top-right,
     * bottom-right, bottom-left
     *
     * @see Path#addRoundRect(android.graphics.RectF, float[], android.graphics.Path.Direction)
     *
     * @param rect The bounds of a round-rectangle to add to the path
     * @param radii Array of 8 values, 4 pairs of [X,Y] radii
     * @param dir  The direction to wind the round-rectangle's contour
     */
    public void addRoundRect(RectF rect, float[] radii, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Add a closed round-rectangle contour to the path
     *
     * @see Path#addRoundRect(android.graphics.RectF, float, float, android.graphics.Path.Direction)
     *
     * @param rect The bounds of a round-rectangle to add to the path
     * @param rx   The x-radius of the rounded corners on the round-rectangle
     * @param ry   The y-radius of the rounded corners on the round-rectangle
     * @param dir  The direction to wind the round-rectangle's contour
     */
    public void addRoundRect(RectF rect, float rx, float ry, Path.Direction dir) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }


    /**
     * Append the specified arc to the path as a new contour. If the start of
     * the path is different from the path's current last point, then an
     * automatic lineTo() is added to connect the current contour to the
     * start of the arc. However, if the path is empty, then we call moveTo()
     * with the first point of the arc.
     *
     * @see android.graphics.Path#arcTo(android.graphics.RectF, float, float)
     *
     * @param oval        The bounds of oval defining shape and size of the arc
     * @param startAngle  Starting angle (in degrees) where the arc begins
     * @param sweepAngle  Sweep angle (in degrees) measured clockwise
     */
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        mOperations.add(new ArcToOp(oval, startAngle, sweepAngle));
    }

    /**
     * Append the specified arc to the path as a new contour. If the start of
     * the path is different from the path's current last point, then an
     * automatic lineTo() is added to connect the current contour to the
     * start of the arc. However, if the path is empty, then we call moveTo()
     * with the first point of the arc. The sweep angle is tread mod 360.
     *
     * @see Path#arcTo(android.graphics.RectF, float, float, boolean)
     *
     * @param oval        The bounds of oval defining shape and size of the arc
     * @param startAngle  Starting angle (in degrees) where the arc begins
     * @param sweepAngle  Sweep angle (in degrees) measured clockwise, treated
     *                    mod 360.
     * @param forceMoveTo If true, always begin a new contour with the arc
     */
    public void arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) {
        mOperations.add(new ArcToOp(oval, startAngle, sweepAngle, forceMoveTo));
    }

    /* TODO Unimplemented methods
    * computeBounds()
    * isRect(RectF)
    */

    /**
     * Close the current contour. If the current point is not equal to the
     * first point of the contour, a line segment is automatically added.
     *
     * @see android.graphics.Path#close()
     */
    public void close() {
        mOperations.add(new CloseOp());
    }

    /**
     * Add a cubic bezier from the last point, approaching control points
     * (x1,y1) and (x2,y2), and ending at (x3,y3). If no moveTo() call has been
     * made for this contour, the first point is automatically set to (0,0).
     *
     * @see Path#cubicTo(float, float, float, float, float, float)
     *
     * @param x1 The x-coordinate of the 1st control point on a cubic curve
     * @param y1 The y-coordinate of the 1st control point on a cubic curve
     * @param x2 The x-coordinate of the 2nd control point on a cubic curve
     * @param y2 The y-coordinate of the 2nd control point on a cubic curve
     * @param x3 The x-coordinate of the end point on a cubic curve
     * @param y3 The y-coordinate of the end point on a cubic curve
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

    /**
     * Add a line from the last point to the specified point (x,y).
     * If no moveTo() call has been made for this contour, the first point is
     * automatically set to (0,0).
     *
     * @see android.graphics.Path#lineTo(float, float)
     *
     * @param x The x-coordinate of the end of a line
     * @param y The y-coordinate of the end of a line
     */
    public void lineTo(float x, float y) {
        mOperations.add(new LineToOp(x, y));
    }

    /**
     * Set the beginning of the next contour to the point (x,y).
     *
     * @see android.graphics.Path#moveTo(float, float)
     *
     * @param x The x-coordinate of the start of a new contour
     * @param y The y-coordinate of the start of a new contour
     */
    public void moveTo(float x, float y) {
        mOperations.add(new MoveToOp(x, y));
    }

    /**
     * Offset the path by (dx,dy), returning true on success
     *
     * @see android.graphics.Path#offset(float, float, android.graphics.Path)
     *
     * @param dx  The amount in the X direction to offset the entire path
     * @param dy  The amount in the Y direction to offset the entire path
     * @param path The translated path is written here. If this is null, then
     *            the original path is modified.
     */
    public void offset(float dx, float dy, SerializablePath path) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }
    /**
     * Offset the path by (dx,dy), returning true on success
     *
     * @see android.graphics.Path#offset(float, float)
     *
     * @param dx The amount in the X direction to offset the entire path
     * @param dy The amount in the Y direction to offset the entire path
     */
    public void offset(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Add a quadratic bezier from the last point, approaching control point
     * (x1,y1), and ending at (x2,y2). If no moveTo() call has been made for
     * this contour, the first point is automatically set to (0,0).
     *
     * @see Path#quadTo(float, float, float, float)
     *
     * @param x1 The x-coordinate of the control point on a quadratic curve
     * @param y1 The y-coordinate of the control point on a quadratic curve
     * @param x2 The x-coordinate of the end point on a quadratic curve
     * @param y2 The y-coordinate of the end point on a quadratic curve
     */
    public void quadTo(float x1, float y1, float x2, float y2) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Same as cubicTo, but the coordinates are considered relative to the
     * current point on this contour. If there is no previous point, then a
     * moveTo(0,0) is inserted automatically.
     */
    public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Same as lineTo, but the coordinates are considered relative to the last
     * point on this contour. If there is no previous point, then a moveTo(0,0)
     * is inserted automatically.
     *
     * @see android.graphics.Path#rLineTo(float, float)
     *
     * @param dx The amount to add to the x-coordinate of the previous point on
     *           this contour, to specify a line
     * @param dy The amount to add to the y-coordinate of the previous point on
     *           this contour, to specify a line
     */
    public void rLineTo(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Set the beginning of the next contour relative to the last point on the
     * previous contour. If there is no previous contour, this is treated the
     * same as moveTo().
     *
     * @see android.graphics.Path#rMoveTo(float, float)
     *
     * @param dx The amount to add to the x-coordinate of the end of the
     *           previous contour, to specify the start of a new contour
     * @param dy The amount to add to the y-coordinate of the end of the
     *           previous contour, to specify the start of a new contour
     */
    public void rMoveTo(float dx, float dy) {
        //TODO needs impl
        throw new UnsupportedOperationException("Needs implementation");
    }

    /**
     * Same as quadTo, but the coordinates are considered relative to the last
     * point on this contour. If there is no previous point, then a moveTo(0,0)
     * is inserted automatically.
     *
     * @see Path#rQuadTo(float, float, float, float)
     *
     * @param dx1 The amount to add to the x-coordinate of the last point on
     *            this contour, for the control point of a quadratic curve
     * @param dy1 The amount to add to the y-coordinate of the last point on
     *            this contour, for the control point of a quadratic curve
     * @param dx2 The amount to add to the x-coordinate of the last point on
     *            this contour, for the end point of a quadratic curve
     * @param dy2 The amount to add to the y-coordinate of the last point on
     *            this contour, for the end point of a quadratic curve
     */
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
    /**
     * Replace the contents of this with the contents of src.
     *
     * @see Path#set(android.graphics.Path)
     */
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

    /**
     * Sets the last point of the path.
     *
     * @see Path#setLastPoint(float, float)
     *
     * @param dx The new X coordinate for the last point
     * @param dy The new Y coordinate for the last point
     */
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
    }

    private void transform(Matrix matrix) {
        //TODO needs impl
        //Uses Matrix, which isn't Serializable!!!
    }

    /**
     * Generate a {@link android.graphics.Path}
     * @return a generated Path
     */
    public Path makePath() {
        Path path = new Path();
        for(AbstractPathOp op : mOperations) {
            op.applyToPath(path);
        }
        return path;
    }

    @Override
    public int compareTo(SerializablePath path) {
        //TODO needs impl
        return 0;
    }


}
