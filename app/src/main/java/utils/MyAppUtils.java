package utils;

import android.content.res.Resources;

/**
 * Created by Adik Widiasmono on 9/16/2015.
 */
public class MyAppUtils {
    public static float dpToPx(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return  dp * scale + 0.5f;
    }

    public static float spToPx(Resources resources, float sp){
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}
