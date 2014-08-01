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

package com.myriadmobile.serializablepath.example;

import android.content.Context;
import android.graphics.PointF;

import com.myriadmobile.serializablepath.SerializablePath;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 */
public class SvgDataParser {

    public static SerializablePath getPath(Context context) throws Exception {
        InputStream in = context.getAssets().open("myriad.svg");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;

        SerializablePath path = new SerializablePath();
        while((line = br.readLine()) != null) {
            char first = line.charAt(0);
            switch (first) {
                case 'Z':
                case 'z': {
                    path.close();
                } break;
                case 'M': {
                    String[] points = line.substring(2).split(" ");
                    PointF pt = parsePoint(points[0]);
                    path.moveTo(pt.x, pt.y);
                    for (int i = 1; i < points.length; i++) {
                        pt = parsePoint(points[i]);
                        path.lineTo(pt.x, pt.y);
                    }
                } break;
                case 'm': {
                    String[] points = line.substring(2).split(" ");
                    PointF pt = parsePoint(points[0]);
                    path.rMoveTo(pt.x, pt.y);
                    for (int i = 1; i < points.length; i++) {
                        pt = parsePoint(points[i]);
                        path.rLineTo(pt.x, pt.y);
                    }
                } break;
                case 'L': {
                    String[] points = line.substring(2).split(" ");
                    for(String point : points) {
                        PointF pt = parsePoint(point);
                        path.lineTo(pt.x, pt.y);
                    }
                } break;
                case 'l': {
                    String[] points = line.substring(2).split(" ");
                    for(String point : points) {
                        PointF pt = parsePoint(point);
                        path.rLineTo(pt.x, pt.y);
                    }
                } break;
                case 'C': {
                    String[] points = line.substring(2).split(" ");
                    for (int i = 0; i < points.length; i+=3) {
                        PointF pt1 = parsePoint(points[i]);
                        PointF pt2 = parsePoint(points[i+1]);
                        PointF pt3 = parsePoint(points[i+2]);
                        path.cubicTo(pt1.x, pt1.y, pt2.x, pt2.y, pt3.x, pt3.y);
                    }
                } break;
                case 'c': {
                    String[] points = line.substring(2).split(" ");
                    for (int i = 0; i < points.length; i+=3) {
                        PointF pt1 = parsePoint(points[i]);
                        PointF pt2 = parsePoint(points[i+1]);
                        PointF pt3 = parsePoint(points[i+2]);
                        path.rCubicTo(pt1.x, pt1.y, pt2.x, pt2.y, pt3.x, pt3.y);
                    }
                } break;
            }
        }

        return path;
    }

    private static PointF parsePoint(String pointStr) {
        String[] pt = pointStr.split(",");
        float x = Float.parseFloat(pt[0]);
        float y = Float.parseFloat(pt[1]);
        return new PointF(x, y);
    }
}
