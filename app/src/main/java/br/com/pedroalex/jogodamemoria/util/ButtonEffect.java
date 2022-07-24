package br.com.pedroalex.jogodamemoria.util;

import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;

public class ButtonEffect {

    public static boolean play(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                v.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                v.getBackground().clearColorFilter();
                v.invalidate();
                break;
            }
        }
        return false;
    }
}
