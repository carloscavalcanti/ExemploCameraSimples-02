package com.example.exemplocamera01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button botao;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		botao = (Button) findViewById(R.id.botao);
		botao.setOnClickListener(this);

		image = (ImageView) findViewById(R.id.image);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivityForResult(intent, 19);
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null ) {
			if (requestCode == 19) { 
				String result = data.toURI();
				System.out.println("result: " + result);
				Bundle bundle = data.getExtras();
				if (bundle != null) {
					Bitmap bitmap = (Bitmap) bundle.get("data");
					image.setImageBitmap(bitmap);
				}
			}

		}
	}

}