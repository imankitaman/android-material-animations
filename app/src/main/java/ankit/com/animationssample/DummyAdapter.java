package ankit.com.animationssample;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ankit on 16/12/16.
 */

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.DummyViewHolder> {

    private List<String> dummyData;
    private dummyAdapterCallback dummyAdapterCallback;
    private int lastPosition = -1;
    private Context mContext;

    public DummyAdapter(List<String> dummy, dummyAdapterCallback dummyAdapterCallback) {
        this.dummyData = dummy;
        this.dummyAdapterCallback = dummyAdapterCallback;
    }

    @Override
    public DummyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dummy, parent, false);
        mContext = parent.getContext();
        return new DummyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DummyViewHolder holder, int position) {
        runEnterAnimation(holder.itemView);
        final Pair[] viewStringPair = new Pair[]{Pair.create(holder.view, holder.itemView.getResources().getString(R.string.transit_view)),
                Pair.create((View) holder.txt_title, holder.itemView.getResources().getString(R.string.transit_card_title))};

        holder.txt_title.setText(dummyData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dummyAdapterCallback.onItemClick(dummyData.get(holder.getAdapterPosition()), viewStringPair);
            }
        });

    /*    if (position > lastPosition) {
            holder.itemView.setTranslationY(getScreenHeight());
            holder.itemView.animate()
                    .translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
            lastPosition = position;

//            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),
//                    R.anim.up_from_bottom);
//            holder.itemView.startAnimation(animation);
        }
        */
    }

    private void runEnterAnimation(View view) {
        view.setTranslationY(getScreenHeight());
        view.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(3.f))
                .setDuration(1000)
                .start();
    }

    private int getScreenHeight() {
        return mContext.getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public int getItemCount() {
        return dummyData.size();
    }

    class DummyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_subtitle, txt_title;
        private View view;

        public DummyViewHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_subtitle = (TextView) itemView.findViewById(R.id.txt_subtitle);
            view = itemView.findViewById(R.id.my_view);
        }
    }

    interface dummyAdapterCallback {
        void onItemClick(String title, Pair<View, String>[] pairs);
    }
}
