package com.course.example.fancytext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FancyTextActivity extends Activity {
    /** Called when the activity is first created. */
	
	private LinearLayout layoutToAnimate1, layoutToAnimate2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageView imView =(ImageView)findViewById(R.id.image);
        imView.setImageResource(R.drawable.android);
          
        layoutToAnimate1 = (LinearLayout)findViewById(R.id.layout01);
        layoutToAnimate2 = (LinearLayout)findViewById(R.id.layout02);
        layoutToAnimate2.setVisibility(View.INVISIBLE);
        
     // Load the appropriate animation and set listener
        Animation an1 =  AnimationUtils.loadAnimation(this, R.anim.snazzyintro);
        an1.setAnimationListener(new MyAnimationListener());
        
        // Start the animation
        layoutToAnimate1.startAnimation(an1);

    }
    
    public class MyAnimationListener implements Animation.AnimationListener {

		public void onAnimationEnd(Animation animation) {
			
			// Hide our ImageView	
			layoutToAnimate1.setVisibility(View.INVISIBLE);
			layoutToAnimate2.setVisibility(View.VISIBLE);
			
			// Load the appropriate animation and set listener to repeat animation
	        Animation an2 =  AnimationUtils.loadAnimation(FancyTextActivity.this, R.anim.snazzyintro);

	       // an2.setAnimationListener(new MyAnimationListener());
	        
	        // Start the animation
	        layoutToAnimate2.startAnimation(an2);

	    }
		

		public void onAnimationRepeat(Animation animation) {
			// what to do when animation loops 
		}

		public void onAnimationStart(Animation animation) {			
			//what to do when animation starts
		}
		
	}
}