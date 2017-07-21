package br.com.gmit.customviewindrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AndroidATCView extends View {
    private int mSquareCol, mLabelCol;
    private String mSquareText;
    private Paint mSquarePaint;

    public AndroidATCView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSquarePaint = new Paint();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AndroidATCView, 0, 0);
        try {
            mSquareText = typedArray.getString(R.styleable.AndroidATCView_squareLabel);
            mSquareCol = typedArray.getInteger(R.styleable.AndroidATCView_squareColor, 0);
            mLabelCol = typedArray.getInteger(R.styleable.AndroidATCView_labelColor, 0);
        } finally {
            typedArray.recycle();
        }
    }

    public String getSquareText() {
        return mSquareText;
    }

    public int getLabelCol() {
        return mLabelCol;
    }

    public int getSquareCol() {
        return mSquareCol;
    }

    public void setSquareColor(int newColor) {
        mSquareCol = newColor;
        invalidate();
        requestLayout();
    }

    public void setLabelColor(int newColor) {
        mLabelCol = newColor;
        invalidate();
        requestLayout();
    }

    public void setLabelText(String newLabel) {
        mSquareText = newLabel;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            mSquarePaint.setStyle(Paint.Style.FILL);
            mSquarePaint.setAntiAlias(true);
            mSquarePaint.setColor(mSquareCol);
            canvas.drawRect(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), mSquarePaint);
            mSquarePaint.setColor(mLabelCol);
            mSquarePaint.setTextAlign(Paint.Align.CENTER);
            mSquarePaint.setTextSize(50);
            canvas.drawText(mSquareText, this.getMeasuredWidth() / 2, this.getMeasuredHeight() / 2, mSquarePaint);
        }
    }
}
