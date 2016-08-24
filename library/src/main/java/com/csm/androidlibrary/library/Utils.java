package com.csm.androidlibrary.library;

/**
 * Created by sagar on 8/17/2016.
 */
public class Utils {

    public static final String OPERATION_TYPE = "operation_type";
    public static final String ICON_ID = "icon_id";
    public static final String MAX_NUMBER_OF_TRIES = "max_tries_number";
    public static final String NUMBER_OF_DIGITS = "number_of_digits";
    public static final String REPORT = "report";
    public static final String REPORT_CODE = "report_code";
    public static final String SAVED_TEXT = "saved_text";
    public static final String SAVED_ICON = "saved_icon";
    public static final String SAVED_NO_OF_TRIES = "saved_no_of_tries";
    public static final String SAVED_NO_OF_TRIES_FOR_ORIEANTION_CHANGE = "saved_no_of_tries_for_orieantion_change";
    public static final String SAVED_INFINITY_TRIES_FOR_ORIEANTION_CHANGE = "saved_if_infibity_try_for_orieantion_change";
    public static final int PIN_REQUEST_CODE = 101;

    public static final int OPERATION_TYPE_SET_NEW_PIN = 1;
    public static final int OPERATION_TYPE_VERIFY_PIN = 2;
    public static final int FINISH_TYPE_CANCELLED = 5;
    public static final int FINISH_TYPE_SUCCESS = 6;

    public static final int CURRENT_OPERATION_CODE_SETTING_INITIAL_PIN = 7;
    public static final int CURRENT_OPERATION_CODE_CONFIRMING_PIN = 8;
    public static final int CURRENT_OPERATION_CODE_VERIFY_PIN = 9;

    //report codes
    public static final int REPORT_CODE_SUCCESS_PIN_SET = 10;
    public static final int REPORT_CODE_SUCCESS_PIN_VERIFY = 15;
    public static final int REPORT_CODE_WRONG_OPERATION_TYPE = 11;
    public static final int REPORT_CODE_ACTIVITY_CANCELLED_BY_USER = 14;
    public static final int REPORT_CODE_MAX_NUMBER_OF_TRIES_REACHED = 15;
    public static final int REPORT_CODE_KILLED_BY_SYSTEM = 16;
    public static final int REPORT_CODE_BACK_PRESSED_BY_USER = 17;

    public static final String SHAREDPREFRENCE_PIN_STATUS = "shared_prefrence_status";
    public static final int SHAREDPREFRENCE_PIN_STATUS_SET = 12;
    public static final int SHAREDPREFRENCE_PIN_STATUS_NOT_SET = 13;
    public static final String SHAREDPREFRENCE_PIN = "pin";
}
