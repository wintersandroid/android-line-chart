/*
 * 	   Created by Daniel Nadeau
 * 	   daniel.nadeau01@gmail.com
 * 	   danielnadeau.blogspot.com
 * 
 * 	   Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package nz.org.winters.android.androidlinechart;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;

import java.text.DecimalFormat;

public class LinePoint<XT, YT>
{
  private XT xValue;
  private YT yValue;
  private float x = 0;
  private float y = 0;
  private Path   path;
  private Region region;
  private String xAxisLabel = "";
  private String yAxisLabel = "";

  private float pointX;
  private float pointY;
  private float xAxisLabelWidth;
  private float yAxisLabelWidth;
  private float xAxisLabelHeight;
  private float yAxisLabelHeight;

  private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");

  public LinePoint(XT xValue, YT yValue)
  {
    this.xValue = xValue;
    this.yValue = yValue;
  }


  public float getX()
  {
    return x;
  }

  @Override
  public String toString()
  {
    return "LinePoint{" +
            "xValue=" + xValue +
            ", yValue=" + yValue +
            ", xAxisLabel='" + xAxisLabel + '\'' +
            ", yAxisLabel='" + yAxisLabel + '\'' +
            ", x=" + x +
            ", y=" + y +
            ", pointX=" + pointX +
            ", pointY=" + pointY +
            '}';
  }

  public void setX(float x)
  {
    this.x = x;
    this.xAxisLabel = decimalFormat.format(x);
  }

  public float getY()
  {
    return y;
  }

  public void setY(float y)
  {
    this.y = y;
  }

  public Region getRegion()
  {
    return region;
  }

  public void setRegion(Region region)
  {
    this.region = region;
  }

  public Path getPath()
  {
    return path;
  }

  public void setPath(Path path)
  {
    this.path = path;
  }

  public String getXAxisLabel()
  {
    return xAxisLabel;
  }

  public void setXAxisLabel(String label)
  {
    xAxisLabel = label;
  }

  public float getPointX()
  {
    return pointX;
  }

  public void setPointX(float pointX)
  {
    this.pointX = pointX;
  }

  public float getPointY()
  {
    return pointY;
  }

  public void setPointY(float pointY)
  {
    this.pointY = pointY;
  }

  public void setPoints(float lastXPixels, float lastYPixels)
  {
    this.pointX = lastXPixels;
    this.pointY = lastYPixels;
  }

  public float getXAxisLabelWidth()
  {
    return xAxisLabelWidth;
  }


  public float getYAxisLabelWidth()
  {
    return yAxisLabelWidth;
  }

  public float getXAxisLabelHeight()
  {
    return xAxisLabelHeight;
  }


  public float getYAxisLabelHeight()
  {
    return yAxisLabelWidth;
  }

  public String getYAxisHeight()
  {
    return yAxisLabel;
  }

  public XT getXValue()
  {
    return xValue;
  }


  public YT getYValue()
  {
    return yValue;
  }

  public void format(XAxisFormatter<XT> xAxisFormatter, YAxisFormatter<YT> yAxisFormatter, Paint labelPaint)
  {
    x = xAxisFormatter.toFloat(xValue);
    y = yAxisFormatter.toFloat(yValue);
    xAxisLabel = xAxisFormatter.format(xValue);
    yAxisLabel = yAxisFormatter.format(yValue);

    Rect rect = new Rect();

    labelPaint.getTextBounds(xAxisLabel, 0, xAxisLabel.length(), rect);
    xAxisLabelWidth = rect.width();
    xAxisLabelHeight = rect.height();

    labelPaint.getTextBounds(yAxisLabel, 0, yAxisLabel.length(), rect);
    yAxisLabelWidth = rect.width();
    yAxisLabelHeight = rect.height();
  }
}
