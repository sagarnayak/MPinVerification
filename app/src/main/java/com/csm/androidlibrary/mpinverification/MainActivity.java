package com.csm.androidlibrary.mpinverification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.csm.androidlibrary.library.Pin;
import com.csm.androidlibrary.library.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, Pin.class).putExtra(Utils.OPERATION_TYPE, Utils.OPERATION_TYPE_VERIFY_PIN).putExtra(Utils.MAX_NUMBER_OF_TRIES, 3).putExtra(Utils.ICON_ID, R.mipmap.ic_launcher).putExtra(Utils.NUMBER_OF_DIGITS, 4), Utils.PIN_REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Utils.PIN_REQUEST_CODE) {
                Log.i("log", "report : " + data.getStringExtra(Utils.REPORT) + " : " + data.getIntExtra(Utils.REPORT_CODE, 0));
            }

        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("log", "cancelled" + data.getStringExtra(Utils.REPORT));
        }
    }
}
