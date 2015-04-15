package com.examen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView lblNombre;
	private TextView lblApe1;
	private TextView lblApe2;
	private AnalogClock ac;
	private ImageView img;

	private int cont = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lblNombre = (TextView) findViewById(R.id.lblNombre);
		lblApe1 = (TextView) findViewById(R.id.lblApellido1);
		lblApe2 = (TextView) findViewById(R.id.lblApellido2);
		ac = (AnalogClock) findViewById(R.id.reloj);
		img = (ImageView) findViewById(R.id.img);
	}

	public void mostrarData(View v) {
		lblNombre.setText("JP");
		lblApe1.setText("Monge");
		lblApe2.setText("Bonilla");
	}

	public void cleanData(View v) {
		lblNombre.setText("");
		lblApe1.setText("");
		lblApe2.setText("");
	}

	public void showReloj(View v) {
		ac.setVisibility(View.VISIBLE);
	}

	public void showImage(View v) {
		if (cont == 0) {
			img.setVisibility(View.VISIBLE);
			cont++;

		} else if (cont == 1) {
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle("Tamaño doble!");

			ImageView img = new ImageView(this);
			img.setBackgroundResource(R.drawable.ic_launcher);

			alert.setView(img);
			alert.setNegativeButton("Cerrar",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
							cont++;
						}
					});
			alert.show();
		} else if (cont == 2) {
			img.setVisibility(View.INVISIBLE);
			cont = 0;
		}
	}

	// parcial II
	public void goParcialII(View v) {
		Intent i = new Intent(this, SegundoExamen.class);
		startActivity(i);
	}
}
