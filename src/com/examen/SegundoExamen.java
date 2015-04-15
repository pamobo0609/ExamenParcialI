package com.examen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SegundoExamen extends Activity {
    private ToggleButton tbReloj;
    private DigitalClock reloj;
    private ImageView img;
    private Button btnDoubleSize;
    private Button btnClear;
    private ImageButton btnShowImage;
    private TextView lblNombre;
    private TextView lblApe1;
    private TextView lblApe2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_examen);

        // controls init
        tbReloj = (ToggleButton) findViewById(R.id.tbReloj);
        reloj = (DigitalClock) findViewById(R.id.dcHora);
        lblNombre = (TextView) findViewById(R.id.lblNombreS);
        lblApe1 = (TextView) findViewById(R.id.lblApe1S);
        lblApe2 = (TextView) findViewById(R.id.lblApe2S);
        btnShowImage = (ImageButton) findViewById(R.id.btnShowImage);
        img = (ImageView) findViewById(R.id.imgS);
        btnDoubleSize = (Button) findViewById(R.id.btnMasGrande);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                if (tbReloj.getVisibility() == View.INVISIBLE)
                    tbReloj.setVisibility(View.VISIBLE);
                else
                    tbReloj.setVisibility(View.INVISIBLE);

                return true;
            case R.id.opcion2:
                if (btnShowImage.getVisibility() == View.INVISIBLE) {
                    btnShowImage.setVisibility(View.VISIBLE);
                }
                else {
                    btnShowImage.setVisibility(View.INVISIBLE);
                    if (img.getVisibility() == View.VISIBLE && btnDoubleSize.getVisibility() == View.VISIBLE) {
                        img.setBackgroundResource(R.drawable.ic_launcher);
                        img.setVisibility(View.INVISIBLE);
                        btnDoubleSize.setVisibility(View.INVISIBLE);
                    }
                }
                return true;
            case R.id.opcion3:
                lblNombre.setText("Jose P.");
                lblApe1.setText("Monge");
                lblApe2.setText("Bonilla");

                lblNombre.setVisibility(View.VISIBLE);
                lblApe1.setVisibility(View.VISIBLE);
                lblApe2.setVisibility(View.VISIBLE);

                btnClear.setVisibility(View.VISIBLE);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Examen
    public void showReloj(View v) {
        if (tbReloj.isChecked()) {
            reloj.setVisibility(View.VISIBLE);
        }
        else {
            reloj.setVisibility(View.INVISIBLE);
        }
    }

    public void showImage(View v) {
        img.setVisibility(View.VISIBLE);
        btnDoubleSize.setVisibility(View.VISIBLE);
    }

    public void doubleSize(View v) {
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
                        }
                    });
            alert.show();
    }

    public void clear(View v) {
        lblNombre.setText("");
        lblApe2.setText("");
        lblApe1.setText("");
    }
}
