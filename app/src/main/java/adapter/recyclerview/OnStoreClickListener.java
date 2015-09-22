package adapter.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Adik Widiasmono on 9/12/2015.
 */
public interface OnStoreClickListener {
    public void onFavoriteClick(int position, View v);
    public void onMerchantIconClick(int position, View v, ImageView storeBg, FloatingActionButton favorite, FloatingActionButton takePic);
    public void onCameraClick(int position, View v);
}
