package com.csm.androidlibrary.library;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Pin extends AppCompatActivity {

    RelativeLayout relKeyboardContainer;
    TextView txtNoOfTriesLeft;
    EditText edtPin;
    ImageView imgIcon;
    RelativeLayout relNumber1Container, relNumber2Container, relNumber3Container, relNumber4Container, relNumber5Container, relNumber0Container,
            relNumber6Container, relNumber7Container, relNumber8Container, relNumber9Container, relCancelContainer, relBackContainer;

    Intent intent;
    SharedPreferences sharedPreferences;
    TextWatcher textWatcher;

    int intNoOfDigits;
    int intCurrentOperationType;
    String temp = "";
    int intMaxNoOfTries;
    boolean boolInfinityTries = false;
    boolean boolOrieantionChangeDataSaving = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.content_pin);

        getSupportActionBar().hide();

        intent = getIntent();
        sharedPreferences = getSharedPreferences("MPin_Data", MODE_PRIVATE);

        initialiseParameters();
        performDynamicLayoutChanges();
        setListeners();
        performAppropriateAction();

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

    private void performDynamicLayoutChanges() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Log.i("log", "screen width :" + width + " height :" + height);

        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relKeyboardContainer.getLayoutParams();
            if (width < height) {
                //portrait
                int assignparam = (int) (width * .55);
                layoutParams.height = assignparam;
                relKeyboardContainer.setLayoutParams(layoutParams);
            } else {
                //landscape not applied
            }
        } catch (Exception e) {
            Log.i("log", "problem in getting layout params");
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relKeyboardContainer.getLayoutParams();
            if (width < height) {
                //portrait not applied
            } else {
                //landscape
                int assignparam = (int) (((int) (width * .50)) * .60);
                layoutParams.height = assignparam;
                relKeyboardContainer.setLayoutParams(layoutParams);
            }
        }
    }

    private void performVibrate() {
        Vibrator v = (Vibrator) Pin.this.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(40);
    }

    private void initialiseParameters() {

        Log.i("log", "going to initialise parameters in mpin");

        imgIcon = (ImageView) findViewById(R.id.appiconImageview);
        edtPin = (EditText) findViewById(R.id.edittext_pin);
        txtNoOfTriesLeft = (TextView) findViewById(R.id.textview_no_of_tries_left);
        relKeyboardContainer = (RelativeLayout) findViewById(R.id.relativelayout_keyboard_container);
        relNumber1Container = (RelativeLayout) findViewById(R.id.relative_number_1_container);
        relNumber2Container = (RelativeLayout) findViewById(R.id.relative_number_2_container);
        relNumber3Container = (RelativeLayout) findViewById(R.id.relative_number_3_container);
        relNumber4Container = (RelativeLayout) findViewById(R.id.relative_number_4_container);
        relNumber5Container = (RelativeLayout) findViewById(R.id.relative_number_5_container);
        relNumber6Container = (RelativeLayout) findViewById(R.id.relative_number_6_container);
        relNumber7Container = (RelativeLayout) findViewById(R.id.relative_number_7_container);
        relNumber8Container = (RelativeLayout) findViewById(R.id.relative_number_8_container);
        relNumber9Container = (RelativeLayout) findViewById(R.id.relative_number_9_container);
        relNumber0Container = (RelativeLayout) findViewById(R.id.relative_number_0_container);
        relBackContainer = (RelativeLayout) findViewById(R.id.relative_back_container);
        relCancelContainer = (RelativeLayout) findViewById(R.id.relative_cancel_container);

        txtNoOfTriesLeft.setVisibility(View.GONE);
    }

    private void setListeners() {

        Log.i("log", "going to set the listenrs for the layout elements.");

        relNumber0Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 0);
            }
        });

        relNumber1Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 1);
            }
        });

        relNumber2Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 2);
            }
        });

        relNumber3Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 3);
            }
        });

        relNumber4Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 4);
            }
        });

        relNumber5Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 5);
            }
        });

        relNumber6Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 6);
            }
        });

        relNumber7Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 7);
            }
        });

        relNumber8Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 8);
            }
        });

        relNumber9Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                setTextToPin("" + 9);
            }
        });

        relBackContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                finishWithResult(Utils.FINISH_TYPE_CANCELLED, "cancelled by user", Utils.REPORT_CODE_BACK_PRESSED_BY_USER);
            }
        });

        relCancelContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performVibrate();
                clearTextOfPin();
            }
        });

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Log.i("log", "the count value is : " + i + " " + i1 + " " + i2);

                if (boolOrieantionChangeDataSaving) {
                    sharedPreferences.edit().putString(Utils.SAVED_TEXT, charSequence.toString()).commit();

                    Log.i("log", "saved value to sharedprefrence : " + sharedPreferences.getString(Utils.SAVED_TEXT, ""));
                }

                switch (intCurrentOperationType) {
                    case Utils.CURRENT_OPERATION_CODE_SETTING_INITIAL_PIN:
                        if (i2 == intNoOfDigits) {
                            //reached the number of digits;
                            temp = edtPin.getText().toString();
                            edtPin.setText("");
                            edtPin.setHint("enter again to confirm");
                            intCurrentOperationType = Utils.CURRENT_OPERATION_CODE_CONFIRMING_PIN;
                        }
                        break;
                    case Utils.CURRENT_OPERATION_CODE_CONFIRMING_PIN:
                        if (i2 == intNoOfDigits) {
                            if (temp.equals("" + edtPin.getText().toString())) {
                                //pin are equal. set the pin.
                                sharedPreferences.edit().putInt(Utils.SHAREDPREFRENCE_PIN_STATUS, Utils.SHAREDPREFRENCE_PIN_STATUS_SET).commit();
                                sharedPreferences.edit().putString(Utils.SHAREDPREFRENCE_PIN, edtPin.getText().toString()).commit();
                                finishWithResult(Utils.FINISH_TYPE_SUCCESS, "the pin is set successfully.", Utils.REPORT_CODE_SUCCESS_PIN_SET);
                            } else {
                                //show a dialog asking do you want to set the pin again
                                new AlertDialog.Builder(Pin.this)
                                        .setTitle("Wrong Pin")
                                        .setCancelable(false)
                                        .setMessage("The pin you have entered is wrong. do you want to go again ?")
                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                setNewPin();
                                            }
                                        })
                                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                finishWithResult(Utils.FINISH_TYPE_CANCELLED, "user has cancelled the set new pin dialog.", Utils.REPORT_CODE_ACTIVITY_CANCELLED_BY_USER);
                                            }
                                        })
                                        .setIcon(android.R.drawable.ic_media_play)
                                        .show();
                            }
                        }
                        break;
                    case Utils.CURRENT_OPERATION_CODE_VERIFY_PIN:
                        if (i2 == intNoOfDigits) {
                            if (edtPin.getText().toString().equals(sharedPreferences.getString(Utils.SHAREDPREFRENCE_PIN, ""))) {
                                Log.i("log", "the pin matched");
                                finishWithResult(Utils.FINISH_TYPE_SUCCESS, "the pin matched", Utils.REPORT_CODE_SUCCESS_PIN_VERIFY);
                            } else {
                                if (boolInfinityTries) {
                                    //infinity
                                } else {
                                    //count
                                    Log.i("log", "reducing the max number of tries.");
                                    intMaxNoOfTries--;
                                    sharedPreferences.edit().putInt(Utils.SAVED_NO_OF_TRIES_FOR_ORIEANTION_CHANGE, intMaxNoOfTries).commit();
                                    txtNoOfTriesLeft.setText("Number of tries left : " + intMaxNoOfTries);
                                    if (intMaxNoOfTries == 0) {
                                        Log.i("log", "max number if tries is reached.");
                                        finishWithResult(Utils.FINISH_TYPE_CANCELLED, "the max number of tries is reached.", Utils.REPORT_CODE_MAX_NUMBER_OF_TRIES_REACHED);
                                    }

                                }
                                edtPin.setText("");
                                Toast.makeText(Pin.this, "wrong pin", Toast.LENGTH_LONG).show();
                            }
                        }
                        break;
                    default:
                        Log.i("log", "the current operation type has a invalid type.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        edtPin.addTextChangedListener(textWatcher);
    }

    private void setTextToPin(String s) {
        edtPin.setText(edtPin.getText() + s);
    }

    private void clearTextOfPin() {
        edtPin.setText("");
    }

    private void performAppropriateAction() {

        Log.i("log", "going to select a appropriate action.");

        int operationType = intent.getIntExtra(Utils.OPERATION_TYPE, 0);
        switch (operationType) {
            case Utils.OPERATION_TYPE_SET_NEW_PIN:
                Log.i("log", "set new pin is selected.");
                setNewPin();
                break;
            case Utils.OPERATION_TYPE_VERIFY_PIN:
                Log.i("log", "verify pin is selected.");
                verifyPin();
                break;
            default:
                Log.i("log", "no valid operation type is selected. the program will return now.");
                finishWithResult(Utils.FINISH_TYPE_CANCELLED, "the operation type is not valid.", Utils.REPORT_CODE_WRONG_OPERATION_TYPE);
        }
    }

    private void setNewPin() {
        //check if number of digits is given.
        if (intent.getIntExtra(Utils.NUMBER_OF_DIGITS, 0) == 0) {
            //0 or no value is given
            Log.i("log", "no value is given or 0 value is given for number of digits. the default value is 15.");
            intNoOfDigits = 15;
        } else {
            Log.i("log", "the number of digits is passed and it is valid. value is : " + intent.getIntExtra(Utils.NUMBER_OF_DIGITS, 0));
            intNoOfDigits = intent.getIntExtra(Utils.NUMBER_OF_DIGITS, 0);
        }

        //set icon and save for future user
        if (intent.getIntExtra(Utils.ICON_ID, 0) != 0) {
            //okay
            imgIcon.setVisibility(View.VISIBLE);
            imgIcon.setImageDrawable(getResources().getDrawable(intent.getIntExtra(Utils.ICON_ID, 0)));
            sharedPreferences.edit().putInt(Utils.SAVED_ICON, intent.getIntExtra(Utils.ICON_ID, 0)).commit();
        } else {
            //no icon id is given
            imgIcon.setVisibility(View.GONE);
        }

        if (intent.getIntExtra(Utils.MAX_NUMBER_OF_TRIES, 0) != 0) {
            //save no of tries
            sharedPreferences.edit().putInt(Utils.SAVED_NO_OF_TRIES, intent.getIntExtra(Utils.MAX_NUMBER_OF_TRIES, 0)).commit();
        }

        //set hint to the edittext
        edtPin.setHint("" + intNoOfDigits + " digits to pin to set");
        edtPin.setText("");

        //set current operation type as set initial pin
        intCurrentOperationType = Utils.CURRENT_OPERATION_CODE_SETTING_INITIAL_PIN;

        //set the sharedprefrence
        sharedPreferences.edit().putInt(Utils.SHAREDPREFRENCE_PIN_STATUS, Utils.SHAREDPREFRENCE_PIN_STATUS_NOT_SET).commit();
    }

    private void verifyPin() {
        //check if pin is present previously
        if (sharedPreferences.getInt(Utils.SHAREDPREFRENCE_PIN_STATUS, Utils.SHAREDPREFRENCE_PIN_STATUS_NOT_SET) == Utils.SHAREDPREFRENCE_PIN_STATUS_NOT_SET) {
            //pin is not set. go to setting pin
            Log.i("log", "pin is not found. going to set a pin.");
            setNewPin();
        } else {

            if (intent.getIntExtra(Utils.ICON_ID, 0) != 0) {
                //icon id passed
                imgIcon.setImageDrawable(getResources().getDrawable(intent.getIntExtra(Utils.ICON_ID, 0)));
            } else {
                if (sharedPreferences.getInt(Utils.SAVED_ICON, 0) != 0) {
                    //icon is present
                    imgIcon.setImageDrawable(getResources().getDrawable(sharedPreferences.getInt(Utils.SAVED_ICON, 0)));
                }
            }

            Log.i("log", "pin is found. going to verify the pin.");
            intCurrentOperationType = Utils.CURRENT_OPERATION_CODE_VERIFY_PIN;
            String originalPin = sharedPreferences.getString(Utils.SHAREDPREFRENCE_PIN, "");
            intNoOfDigits = originalPin.length();
            intMaxNoOfTries = intent.getIntExtra(Utils.MAX_NUMBER_OF_TRIES, -1);
            if (boolOrieantionChangeDataSaving) {
                sharedPreferences.edit().putInt(Utils.SAVED_NO_OF_TRIES_FOR_ORIEANTION_CHANGE, intMaxNoOfTries).commit();
            }
            if (intMaxNoOfTries == 0) {
                Log.i("log", "the max number of tries is infinity.");
                boolInfinityTries = true;
                if (boolOrieantionChangeDataSaving) {
                    sharedPreferences.edit().putBoolean(Utils.SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE, true).commit();
                }
            } else if (intMaxNoOfTries == -1) {
                Log.i("log", "max no of tries is not given. checking for shared prefrence");
                int temptries = sharedPreferences.getInt(Utils.SAVED_NO_OF_TRIES, 0);
                if (temptries == 0) {
                    Log.i("log", "value from prefrence is : " + temptries);
                    boolInfinityTries = true;
                    if (boolOrieantionChangeDataSaving) {
                        sharedPreferences.edit().putBoolean(Utils.SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE, true).commit();
                    }
                } else {
                    Log.i("log", "the no of tries is : " + temptries);
                    boolInfinityTries = false;
                    if (boolOrieantionChangeDataSaving) {
                        sharedPreferences.edit().putBoolean(Utils.SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE, false).commit();
                    }
                    intMaxNoOfTries = sharedPreferences.getInt(Utils.SAVED_NO_OF_TRIES, 0);
                    if (boolOrieantionChangeDataSaving) {
                        sharedPreferences.edit().putInt(Utils.SAVED_NO_OF_TRIES_FOR_ORIEANTION_CHANGE, intMaxNoOfTries).commit();
                    }
                }
            } else {
                Log.i("log", "the max number of tries is : " + intMaxNoOfTries);
                boolInfinityTries = false;
                if (boolOrieantionChangeDataSaving) {
                    sharedPreferences.edit().putBoolean(Utils.SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE, false).commit();
                }
                txtNoOfTriesLeft.setVisibility(View.VISIBLE);
                txtNoOfTriesLeft.setText("Number of tries left : " + intMaxNoOfTries);
            }
            edtPin.setHint("enter " + intNoOfDigits + " digit pin");
        }
    }

    private void finishWithResult(int finish_type, String report, int report_code) {
        Intent return_intent = new Intent();
        return_intent.putExtra(Utils.REPORT, report);
        return_intent.putExtra(Utils.REPORT_CODE, report_code);
        if (finish_type == Utils.FINISH_TYPE_CANCELLED) {
            setResult(Activity.RESULT_CANCELED, return_intent);
        } else if (finish_type == Utils.FINISH_TYPE_SUCCESS) {
            setResult(Activity.RESULT_OK, return_intent);
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishWithResult(Utils.FINISH_TYPE_CANCELLED, "the pin verify activity is killed by system", Utils.REPORT_CODE_KILLED_BY_SYSTEM);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishWithResult(Utils.FINISH_TYPE_CANCELLED, "back pressed", Utils.REPORT_CODE_BACK_PRESSED_BY_USER);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        boolOrieantionChangeDataSaving = false;

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("log", "landscape mode");
            setContentView(R.layout.content_pin);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("log", "portrait mode");
            setContentView(R.layout.content_pin);
        }
        initialiseParameters();
        performDynamicLayoutChanges();
        setListeners();
        performAppropriateAction();
        edtPin.removeTextChangedListener(textWatcher);
        Log.i("log", "value : " + sharedPreferences.getString(Utils.SAVED_TEXT, ""));
        edtPin.setText("" + sharedPreferences.getString(Utils.SAVED_TEXT, ""));
        edtPin.addTextChangedListener(textWatcher);
        intMaxNoOfTries = sharedPreferences.getInt(Utils.SAVED_NO_OF_TRIES_FOR_ORIEANTION_CHANGE, 0);
        txtNoOfTriesLeft.setText("Number of tries left : " + intMaxNoOfTries);
        boolInfinityTries = sharedPreferences.getBoolean(Utils.SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE, false);

        boolOrieantionChangeDataSaving = true;
    }
}
