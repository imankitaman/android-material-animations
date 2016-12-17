package ankit.com.animationssample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

/**
 * Created by ankit on 17/12/16.
 */

public class TransitionListActivity extends AppCompatActivity {

    Pair<View, String> pair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_list);
        View my_view = findViewById(R.id.my_view);

        pair = new Pair<>(my_view, getString(R.string.transit_view));//For shared element transition

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void explodeTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);// pair is for shared Elemenent transition
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(i, options.toBundle());

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void explodeTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        i.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(i, options.toBundle());

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void slideTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        i.putExtra(Constants.KEY_TITLE, "Slide By Java Code");
        startActivity(i, options.toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void slideTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        startActivity(i, options.toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fadeTransitionByJava(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
        i.putExtra(Constants.KEY_TITLE, "Fade By Java");
        startActivity(i, options.toBundle());

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fadeTransitionByXML(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(TransitionListActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
        i.putExtra(Constants.KEY_TITLE, "Fade By XML");
        startActivity(i, options.toBundle());

    }

}
