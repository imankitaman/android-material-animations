package ankit.com.animationssample;

import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ankit on 16/12/16.
 */

public class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.DummyViewHolder> {

    private List<String> dummyData;
    private dummyAdapterCallback dummyAdapterCallback;

    public DummyAdapter(List<String> dummy, dummyAdapterCallback dummyAdapterCallback) {
        this.dummyData = dummy;
        this.dummyAdapterCallback = dummyAdapterCallback;
    }

    @Override
    public DummyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dummy, parent, false);
        return new DummyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DummyViewHolder holder, int position) {
        final Pair[] viewStringPair = new Pair[]{Pair.create(holder.view, holder.itemView.getResources().getString(R.string.transit_view)),
                Pair.create((View) holder.txt_title, holder.itemView.getResources().getString(R.string.transit_card_title))};

        holder.txt_title.setText(dummyData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dummyAdapterCallback.onItemClick(dummyData.get(holder.getAdapterPosition()), viewStringPair);
            }
        });
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
