package com.example.display;

import android.app.Presentation;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * œ¬µ•“Ï∆¡œ‘ æ
 * */
public class ViceDisplay{
	private DisplayManager mDisplayManager;
	private ViceDisplayPresentation mPresentation;
	private Display[] displays;
	public ViceDisplay(Context context){
		mDisplayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
		displays = mDisplayManager.getDisplays();
		if (displays.length<2) {
			//µ•∆¡
			mPresentation = new ViceDisplayPresentation(context, displays[0]);
		}else {
			//À´∆¡
			mPresentation = new ViceDisplayPresentation(context, displays[1]);
		}
		mPresentation.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		mPresentation.setOnDismissListener(mOnDismissListener);
	}
	/**ø™∆Ù“Ïœ‘*/
	public void Show(){
		try {
			mPresentation.show();
	} catch (Exception ex) {
			mPresentation = null;
	}
	}
	
	public void Close() {
		try {
			mPresentation.dismiss();
	} catch (Exception ex) {
			mPresentation = null;
	}
	}
	
	private final DialogInterface.OnDismissListener mOnDismissListener = new DialogInterface.OnDismissListener() {
		@Override
		public void onDismiss(DialogInterface dialog) {
			if (dialog == mPresentation) {
				mPresentation.dismiss();
				mPresentation = null;
			}
		}
	};

	private class ViceDisplayPresentation extends Presentation{
		private EditText et;
		public ViceDisplayPresentation(Context outerContext, Display display) {
			super(outerContext, display);
			// TODO Auto-generated constructor stub	
		}
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.vice_display);
			et=(EditText)findViewById(R.id.editText1);
		}
    }	
}