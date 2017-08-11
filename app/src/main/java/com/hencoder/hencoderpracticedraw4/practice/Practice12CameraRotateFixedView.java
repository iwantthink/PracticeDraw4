package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera mCamera = new Camera();
    Path mPath = new Path();

    private float mGap = 0;
    float p = 50;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mGap >= 500) {
                    p = -50;
                } else if (mGap < 0) {
                    p = 50;
                }
                mGap += p;
                invalidate();
            }
        });
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        setLayerType(LAYER_TYPE_NONE, null);
    }


    Matrix mMatrix = new Matrix();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.lineTo(0, getHeight());
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(getWidth(), 0);
        mPath.close();
        paint.setStyle(Paint.Style.STROKE);


//        paint.setColor(Color.RED);
//        canvas.drawLine(0, 0, 100, 0, paint);
//        canvas.save();
//        canvas.translate(100, 0);
//        canvas.rotate(45, 0, 0);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.drawPath(mPath, paint);
//        canvas.restore();


//        paint.setColor(Color.GREEN);
//        canvas.save();
//        canvas.rotate(45, 0, 0);
//        canvas.translate(100, 0);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.drawPath(mPath, paint);
//        canvas.restore();

//        float wX = 200 + bitmap.getWidth() / 2;
//        float wY = 200 + bitmap.getHeight() / 2;
//        paint.setColor(Color.BLACK);
//        canvas.save();
//        mCamera.save();
//        mCamera.getMatrix(mMatrix);
//        Log.d("Practice12CameraRotateF", "mGap:" + mGap);
//        mMatrix.postTranslate(0, mGap);
//        mCamera.translate(0, 0, mGap);
//        mCamera.rotateX(45);
//        mCamera.applyToCanvas(canvas);
//
//
////        paint.setColor(Color.BLUE);
////        canvas.drawPath(mPath, paint);
//
//
//        mCamera.restore();
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//        canvas.restore();
//
//
//        Matrix nM = new Matrix();
//        canvas.save();
//        paint.setStrokeWidth(20);
//        canvas.drawPoint(600, 200, paint);
//
//
//        nM.preTranslate(100, 100);
//        canvas.setMatrix(nM);
//        paint.setColor(Color.RED);
//        canvas.drawPoint(600, 200, paint);
//
//        nM.postScale(0.5f, 0.5f, 600, 200);
//        canvas.setMatrix(nM);
//        paint.setColor(Color.YELLOW);
//        canvas.drawPoint(600, 200, paint);
//
//
//        nM.postTranslate(100, 100);
//        paint.setColor(Color.BLUE);
//        canvas.setMatrix(nM);
//        canvas.drawPoint(600, 200, paint);
//        canvas.restore();
//        canvas.drawBitmap(bitmap, 216 - bitmap.getWidth() / 2, 216 - bitmap.getHeight() / 2, paint);
        mMatrix.reset();
        int bWidth = bitmap.getWidth();
        int bHeight = bitmap.getHeight();

        canvas.save();
        mCamera.save();
        canvas.translate(bWidth / 2 + 200, bHeight / 2 + 200);
        mCamera.rotateX(45);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-bWidth / 2 - 200, -bHeight / 2 - 200);
        mCamera.restore();
        canvas.drawBitmap(bitmap, 200, 200, paint);
        canvas.restore();

        canvas.save();
        mCamera.save();
        mCamera.rotateY(45);
        canvas.translate(bWidth / 2 + 500, bHeight / 2 + 200);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-bWidth / 2 - 500, -bHeight / 2 - 200);
        mCamera.restore();
        paint.setAlpha(255);
        canvas.drawBitmap(bitmap, 500, 200, paint);
        canvas.restore();


    }


}
