package org.sward.notification;

import android.app.Activity;
import android.os.Bundle;

public class NotificationReceiver extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
	}
}