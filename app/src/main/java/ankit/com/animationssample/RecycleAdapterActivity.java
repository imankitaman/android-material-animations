package ankit.com.animationssample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Fade;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit on 17/12/16.
 */

public class RecycleAdapterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_adapter);
        final RecyclerView rvw_dummy = (RecyclerView) findViewById(R.id.rvw_dummy);

        List<String> dummyData = new ArrayList<>();
        dummyData.add("Zelo 1001 ");
        dummyData.add("Zelo 1002 ");
        dummyData.add("Zelo 1003 ");
        dummyData.add("Zelo 1004 ");
        dummyData.add("Zelo 1005 ");
        dummyData.add("Zelo 1006 ");
        dummyData.add("Zelo 1007 ");

        DummyAdapter dummyAdapter = new DummyAdapter(dummyData, new DummyAdapter.dummyAdapterCallback() {
            @Override
            public void onItemClick(String title, Pair<View, String>[] pairs) {
                Intent intent = new Intent(RecycleAdapterActivity.this, SecondActivity.class);
                intent.putExtra("toolbarTitle", title);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RecycleAdapterActivity.this, pairs);
                    ActivityCompat.startActivity(RecycleAdapterActivity.this, intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
        rvw_dummy.setAdapter(dummyAdapter);
        rvw_dummy.setLayoutManager(new LinearLayoutManager(this));
        rvw_dummy.addItemDecoration(new SpaceItemDecoration(8));
    }

}
