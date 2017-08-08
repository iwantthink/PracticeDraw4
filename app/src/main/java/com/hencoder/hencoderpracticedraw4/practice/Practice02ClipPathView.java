package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(point1.x, point1.x);
        Path path = new Path();
        path.addCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() / 2 : bitmap.getWidth() / 2,
                Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(point2.x, point2.y);
        path.reset();
        path.addCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() / 2 : bitmap.getWidth() / 2,
                Path.Direction.CCW);
        path.close();
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();
    }
}
