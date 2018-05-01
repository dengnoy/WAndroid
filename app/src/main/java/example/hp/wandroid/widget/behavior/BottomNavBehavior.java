package example.hp.wandroid.widget.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public class BottomNavBehavior<View> extends CoordinatorLayout.Behavior {
    private ObjectAnimator mAnimator;
    private boolean isUp;


    public BottomNavBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull android.view.View child, @NonNull android.view.View directTargetChild, @NonNull android.view.View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull android.view.View child, @NonNull android.view.View target, int dx, int dy, @NonNull int[] consumed, int type) {
        //上滑
        if (dy > 5) {
            if (mAnimator == null || !isUp)
                mAnimator = ObjectAnimator.ofFloat(child, "translationY", 0, child.getHeight());
            if (!mAnimator.isRunning() && child.getTranslationY() <=0) {
                mAnimator.start();
                isUp = true;
            }

        }
        //下滑
        if (dy < -15) {
            if (mAnimator == null || isUp)
                mAnimator = ObjectAnimator.ofFloat(child, "translationY", child.getHeight(), 0);
            if (!mAnimator.isRunning() && child.getTranslationY() >=child.getHeight()) {
                mAnimator.start();
                isUp = false;
            }

        }
    }
}
