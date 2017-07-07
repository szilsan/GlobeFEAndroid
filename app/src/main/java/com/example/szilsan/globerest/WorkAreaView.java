package com.example.szilsan.globerest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.szilsan.globerest.dto.GlobeDTO;
import com.example.szilsan.globerest.dto.PositionsDTO;

/**
 * Created by szilsan on 07/07/2017.
 */

public class WorkAreaView extends ViewGroup {

    private Paint mPaint;
    private PositionsDTO positionsDTO;

    public WorkAreaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (positionsDTO != null && positionsDTO.getPositions().size() > 0) {
            for (GlobeDTO gdto : positionsDTO.getPositions()) {
                canvas.drawCircle(gdto.getX() * 40, gdto.getY() * 40, gdto.getSize(), mPaint);
            }
        }
    }

    public PositionsDTO getPositionsDTO() {
        return positionsDTO;
    }

    public void setPositionsDTO(PositionsDTO positionsDTO) {
        this.positionsDTO = positionsDTO;
    }
}
