package adapter.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.widiasmononttdata.adik.storereward.R;

import cus.view.RoundedImageView;

/**
 * Created by Adik Widiasmono on 9/10/2015.
 */
public class StoreViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivStoreBg;
    private FloatingActionButton fabFavorite;
    private RoundedImageView ivStoreIcon;
    private FloatingActionButton fabTakePicture;
    private TextView tvName;
    private TextView tvDescription;
    private Store store;

    public StoreViewHolder(View v, final OnStoreClickListener clickListener) {
        super(v);
        ivStoreBg =  (ImageView) v.findViewById(R.id.store_background);
        fabFavorite = (FloatingActionButton)  v.findViewById(R.id.store_favorite);
        ivStoreIcon = (RoundedImageView)  v.findViewById(R.id.store_icon);
        fabTakePicture = (FloatingActionButton) v.findViewById(R.id.take_picture);
        tvName = (TextView)  v.findViewById(R.id.store_name);
        tvDescription = (TextView) v.findViewById(R.id.store_description);

        fabFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (store.isFavorite()) {
                    fabFavorite.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    store.setIsFavorite(false);
                } else {
                    fabFavorite.setImageResource(R.drawable.ic_favorite_white_24dp);
                    store.setIsFavorite(true);
                }
                clickListener.onFavoriteClick(getAdapterPosition(), v);
            }
        });

        ivStoreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMerchantIconClick(getAdapterPosition(), v, ivStoreBg, fabFavorite, fabTakePicture);
            }
        });

        fabTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCameraClick(getAdapterPosition(), v);
            }
        });
    }

    public void setValue(Store inputStore){
        store = inputStore;
        ivStoreBg.setImageDrawable(store.getBackground());
        if(store.isFavorite()) {
            fabFavorite.setImageResource(R.drawable.ic_favorite_white_24dp);
        } else {
            fabFavorite.setImageResource(R.drawable.ic_favorite_border_white_24dp);
        }
        ivStoreIcon.setImageDrawable(store.getIcon());
        tvName.setText(store.getName());
        tvDescription.setText(store.getDescription());
    }

}
