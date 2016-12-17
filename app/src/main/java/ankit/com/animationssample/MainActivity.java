package ankit.com.animationssample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView ripple = (TextView) findViewById(R.id.txt_ripple);
//        TextView rv_shared_transition = (TextView) findViewById(R.id.txt_rv_shared_transition);
//        TextView shared_circular_reveal = (TextView) findViewById(R.id.txt_shared_circular_reveal);

//        UiUtil.visibleFab(myView);


    }


    public void openRippleAnimation(View view) {
        Intent i = new Intent(MainActivity.this, RippleActivity.class);
        startActivity(i);
    }

    public void openRecyclerAdapter(View v){
        Intent i = new Intent(MainActivity.this, RecycleAdapterActivity.class);
        startActivity(i);
    }

    public void openCircularReveal(View v){
        Intent i = new Intent(MainActivity.this, RecycleAdapterActivity.class);
        startActivity(i);
    }

    public void openTransition(View v){
        Intent i = new Intent(MainActivity.this, TransitionListActivity.class);
        startActivity(i);
    }


    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

    }

}
