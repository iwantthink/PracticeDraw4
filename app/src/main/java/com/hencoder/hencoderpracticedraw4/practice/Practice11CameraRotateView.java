package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice11CameraRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice11CameraRotateView(Context context) {
        super(context);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(15);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        camera.restore();
        canvas.restore();

        canvas.save();
        camera = new Camera();
        float y1 = -(point2.y + bitmap.getHeight() / 2);
        float y2 = y1 / 576f;

        float x1 = point2.x + bitmap.getWidth() / 2;
        float x2 = x1 / 576f;

//        Log.d("Practice11CameraRotateV", "x2:" + x2);
//        camera.setLocation(0.6197917f, -0.6197917f, -32);
        camera.setLocation(0, 0, -55);
        camera.rotateY(45);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        camera.restore();
        canvas.restore();
    }
}
