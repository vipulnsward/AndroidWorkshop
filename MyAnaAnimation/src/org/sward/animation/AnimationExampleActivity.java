package org.sward.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationExampleActivity extends Activity {
public float x=0;
	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView aniTextView = (TextView) findViewById(R.id.textView1);
		x=aniTextView.getX();
	}

	public void startAnimation(View view) {
		float dest = 0;
		ImageView aniView = (ImageView) findViewById(R.id.imageView1);
		switch (view.getId()) {

		case R.id.Button01:
			dest = 360;
			if (aniView.getRotation() == 360) {
				System.out.println(aniView.getAlpha());
				dest = 0;
			}
			ObjectAnimator animation1 = ObjectAnimator.ofFloat(aniView,
					"rotation", dest);
			animation1.setDuration(2000);
			animation1.start();
			// Show how to load an animation from XML
			// Animation animation1 = AnimationUtils.loadAnimation(this,
			// R.anim.myanimation);
			// animation1.setAnimationListener(this);
			// animatedView1.startAnimation(animation1);
			break;

		case R.id.Button02:
			// Shows how to define a animation via code
			// Also use an Interpolator (BounceInterpolator)
			Paint paint = new Paint();
			TextView aniTextView = (TextView) findViewById(R.id.textView1);
			float measureTextCenter = paint.measureText(aniTextView.getText()
					.toString());
			dest = 0 - measureTextCenter;
			if (aniTextView.getX() < 0) {
				dest = 0;
			}
			ObjectAnimator animation2 = ObjectAnimator.ofFloat(aniTextView,
					"x", dest);
			animation2.setDuration(2000);
			animation2.start();
			break;

		case R.id.Button03:
			// Demonstrate fading and adding an AnimationListener

			dest = 1;
			if (aniView.getAlpha() > 0) {
				dest = 0;
			}
			ObjectAnimator animation3 = ObjectAnimator.ofFloat(aniView,
					"alpha", dest);
			animation3.setDuration(2000);
			animation3.start();
			break;

		case R.id.Button04:
			//Perform Animation Operations in Group
			ObjectAnimator fadeOut = ObjectAnimator.ofFloat(aniView, "alpha",
					0f);
			fadeOut.setDuration(2000);
			ObjectAnimator mover = ObjectAnimator.ofFloat(aniView,
					"translationX", -500f, 0f);
			mover.setDuration(2000);
			ObjectAnimator fadeIn = ObjectAnimator.ofFloat(aniView, "alpha",
					0f, 1f);
			fadeIn.setDuration(2000);
			AnimatorSet animatorSet = new AnimatorSet();

			animatorSet.play(mover).with(fadeIn).after(fadeOut);
			animatorSet.start();
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, HitActivity.class);
		//startActivity(intent);
		return true;
	}
	
}