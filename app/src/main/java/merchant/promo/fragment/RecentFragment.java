package merchant.promo.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.widiasmononttdata.adik.storereward.DetailStoreActivity;
import com.widiasmononttdata.adik.storereward.R;

import java.util.LinkedList;
import java.util.List;

import adapter.recyclerview.OnStoreClickListener;
import adapter.recyclerview.Store;
import adapter.recyclerview.StoreRecyclerViewAdapter;

/**
 * Created by Adik Widiasmono on 9/9/2015.
 */
public class RecentFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView recyclerViewList;
    private StaggeredGridLayoutManager staggeredLayoutManager;
    final Integer CAMERA_REQUEST = 1337;

    public static RecentFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RecentFragment fragment = new RecentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_title);
        textView.setText("Fragment #" + mPage);

        recyclerViewList = (RecyclerView) view.findViewById(R.id.my_recycler_view);
//        recyclerViewList.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerViewList.setLayoutManager(llm);

        staggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewList.setLayoutManager(staggeredLayoutManager);

        setData();

        return view;
    }

    private void setData() {
        final List<Store> listStore = new LinkedList<>();
        Store store;

        store = new Store("Bengawan Solo Cafe", getResources().getDrawable(R.drawable.mer_bengawansolo), getResources().getDrawable(R.drawable.bg_bengawansolo),
                "Bengawan Solo Coffee is a truly home grown coffee chain, initiated for a simple reason based on our years of experience in selecting high quality Indonesian Arabica and Robusta coffee beans.",
                true);
        listStore.add(store);
        store = new Store("Burger King", getResources().getDrawable(R.drawable.mer_burgerking), getResources().getDrawable(R.drawable.bg_burgerking),
                "Every day, more than 11 million guests visit BURGER KING® restaurants around the world. And they do so because our restaurants are known for serving high-quality, great-tasting, and affordable food. Founded in 1954, BURGER KING® is the second largest fast food hamburger chain in the world.",
                false);
        listStore.add(store);
        store = new Store("Excelso", getResources().getDrawable(R.drawable.mer_excelso), getResources().getDrawable(R.drawable.bg_excelso),
                "EXCELSO is an original coffee shop from Indonesia and a part of Kapal Api Group, the largest coffee producer in Indonesia. The first EXCELSO Café was opened in September 1991 in Plaza Indonesia, Jakarta.",
                false);
        listStore.add(store);
        store = new Store("Holycow Steak", getResources().getDrawable(R.drawable.mer_holycow), getResources().getDrawable(R.drawable.bg_holycow),
                "Chef Afit previously worked for a well-known TV station. One day after enjoying a plate of juicy wagyu steak at a very fancy restaurant, he had an epiphany. More people should be able to enjoy this heavenly piece of meat at a very affordable price. But how? Obviously, he chose not to compromise when it came to quality.",
                true);
        listStore.add(store);
        store = new Store("Starbucks Cafe", getResources().getDrawable(R.drawable.mer_starbuck), getResources().getDrawable(R.drawable.bg_starbuck),
                "It happens millions of times each week – a customer receives a drink from a Starbucks barista – but each interaction is unique.",
                false);
        listStore.add(store);

        OnStoreClickListener onStoreClickListener = new OnStoreClickListener() {
            @Override
            public void onFavoriteClick(int position, View v) {
                Snackbar.make(getView(), "Add to favorite " + position, Snackbar.LENGTH_SHORT)
//                        .setAction("Action", myOnClickListener)
                        .show();
            }

            @SuppressLint("NewApi")
            @Override
            public void onMerchantIconClick(int position, View v, ImageView storeBg, FloatingActionButton favorite, FloatingActionButton takePic) {
                //                Snackbar.make(getView(), "Merchant clicked " + position, Snackbar.LENGTH_SHORT)
//                        .setAction("Action", myOnClickListener)
//                        .show();

                Intent myIntent = new Intent(getActivity(), DetailStoreActivity.class);
                myIntent.putExtra("STORE_NAME", listStore.get(position).getName());
                Pair<View, String> p1 = Pair.create((View) storeBg, "trans_store_background");
                Pair<View, String> p2 = Pair.create((View) favorite, "trans_store_favorite");
                Pair<View, String> p3 = Pair.create((View) takePic, "trans_take_picture");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), p1, p2, p3);
                getActivity().startActivity(myIntent, options.toBundle());
            }

            @Override
            public void onCameraClick(int position, View v) {
//                Snackbar.make(getView(), "Camera clicked " + position, Snackbar.LENGTH_SHORT)
//                        .setAction("Action", myOnClickListener)
//                        .show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        };
        recyclerViewList.setAdapter(new StoreRecyclerViewAdapter(listStore, onStoreClickListener));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
        }
    }
}
