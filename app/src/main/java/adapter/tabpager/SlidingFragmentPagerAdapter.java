package adapter.tabpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;

import com.widiasmononttdata.adik.storereward.R;

import merchant.promo.fragment.RecentFragment;

/**
 * Created by Adik Widiasmono on 9/9/2015.
 */
public class SlidingFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT;
    private String tabTitles[];
    private TypedArray imageResId;
    private Context context;

    public SlidingFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = this.context.getResources().getStringArray(R.array.merchant_promo_tab_menu);
        imageResId = this.context.getResources().obtainTypedArray(R.array.merchant_promo_tab_menu_ic);
        PAGE_COUNT = tabTitles.length;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return RecentFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("Image " + position, imageResId.getResourceId(position, -1) + "");
//         Generate title based on item position
        Drawable image = context.getResources().getDrawable(imageResId.getResourceId(position, -1));
        image.setBounds(0, 0, image.getIntrinsicWidth()/2, image.getIntrinsicHeight()/2);
        // Replace blank spaces with image icon
        SpannableString sb = new SpannableString("  " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;

//        int[] imageResId = {
//                R.drawable.ic_camera_white,
//                R.drawable.ic_action_location_found,
//                R.drawable.ic_action_location_found_dark,
//                R.drawable.ic_action_location_found,
//                R.drawable.ic_action_location_found_dark
//        };
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString(" ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
    }
}
