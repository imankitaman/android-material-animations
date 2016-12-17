package ankit.com.animationssample;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {

	Constants.TransitionType type;
	String toolbarTitle;

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition);

		initPage();
		initAnimation();

		// For overlap between Exiting  MainActivity.java and Entering TransitionActivity.java
		getWindow().setAllowEnterTransitionOverlap(false);
	}

	private void initPage() {
		type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
		Button btnExit = (Button) findViewById(R.id.exit_button);
		btnExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	private void initAnimation() {

		switch (type) {

			case ExplodeJava: { // For Explode By Code
				Explode enterTransition = new Explode();
				enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
				getWindow().setEnterTransition(enterTransition);
				break;
			}

			case ExplodeXML: { // For Explode By XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTansition);
                break;
			}

			case SlideJava: { // For Slide By Code
                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.TOP);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
			}

			case SlideXML: { // For Slide by XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(enterTansition);
                break;
			}

			case FadeJava: { // For Fade By Code
                Fade enterTransition = new Fade();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_medium));
                getWindow().setEnterTransition(enterTransition);
                break;
			}

			case FadeXML: { // For Fade by XML
                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(enterTansition);
                break;

			}
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			ActivityCompat.finishAfterTransition(TransitionActivity.this);
		else
			finish();
	}
}
