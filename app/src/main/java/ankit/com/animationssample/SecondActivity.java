package ankit.com.animationssample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ankit on 15/12/16.
 */

public class SecondActivity extends AppCompatActivity {

    private ImageView img_big;
    View my_view_big;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
        }

        slideAnimation();

        img_big = (ImageView) findViewById(R.id.img_big);
        TextView toolbar_title = (TextView) findViewById(R.id.title);

        my_view_big = findViewById(R.id.my_view_big);
        String toolbarTitle = getIntent().getStringExtra("toolbarTitle");
        toolbar_title.setText(toolbarTitle);
    }


    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    private void slideAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide enterTransition = new Slide();
            enterTransition.setSlideEdge(Gravity.BOTTOM);//RIGHT, LEFT, BOTTOM, CENTER
            enterTransition.setDuration(400);
            enterTransition.setInterpolator(new AccelerateDecelerateInterpolator());// entering view like - BounceInterpolator, AccelerateDecelerateInterpolator etc..
            getWindow().setEnterTransition(enterTransition);
            getWindow().setExitTransition(enterTransition);

        }
    }

    private void explodeAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode enterTransition = new Explode();
            enterTransition.setDuration(500);
            getWindow().setEnterTransition(enterTransition);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            ActivityCompat.finishAfterTransition(SecondActivity.this);
        else
            finish();
    }
}
