package ankit.com.animationssample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Intent i = new Intent(MainActivity.this, RevealActivity.class);
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
