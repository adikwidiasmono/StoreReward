package adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.widiasmononttdata.adik.storereward.R;

import java.util.List;

/**
 * Created by Adik Widiasmono on 9/10/2015.
 */
public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreViewHolder> {

    private List<Store> listStore;
    private OnStoreClickListener onStoreClickListener;

    public StoreRecyclerViewAdapter(List<Store> listStore, OnStoreClickListener onStoreClickListener) {
        this.listStore = listStore;
        this.onStoreClickListener = onStoreClickListener;
    }

    @Override
    public int getItemCount() {
        return listStore.size();
    }

    @Override
    public void onBindViewHolder(final StoreViewHolder holder, int i) {
        Store store = listStore.get(i);
        holder.setValue(store);
    }

    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.r_cardviews_2, viewGroup, false);

        return new StoreViewHolder(itemView, onStoreClickListener);
    }

}
