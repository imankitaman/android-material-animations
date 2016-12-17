package ankit.com.animationssample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by ankit on 15/12/16.
 */

public class UiUtil {


    /**
     * View visible and invisible
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void makeCircularRevealAnimation(final View myView) {
        Animator anim;
        int cx = myView.getWidth() / 2;
        int cy = myView.getHeight() / 2;
        float initialRadius = (float) Math.hypot(cx, cy);
        if (myView.getVisibility() == View.GONE || myView.getVisibility() == View.INVISIBLE) {
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, initialRadius);
            myView.setVisibility(View.VISIBLE);
        } else {
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);
            anim.addListener(new AnimatorListenerAdapter() { // onStart onPause onResume onCancel onRepeat onEnd
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            });
        }
        anim.start();
    }

    /**
     * transition for scale animation of view
     * @param myView any view type
     */
    public static void visibleFab(final View myView) {
        if (myView.getScaleX()==0) {
            myView.animate().scaleX(1f).scaleY(1f);
        } else {
            myView.animate().scaleX(0f).scaleY(0f);

        }
    }
}
