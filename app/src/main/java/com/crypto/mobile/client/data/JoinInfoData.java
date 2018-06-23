package com.crypto.mobile.client.data;

import com.crypto.mobile.client.R;

public class JoinInfoData {
    public static int ID_MIN_LENGTH = 8;
    public static int PASSWORD_MIN_LENGTH = 8;

    public static int NO_ERROR = 0;
    public static int ERROR_ID_SIZE = 1;
    public static int ERROR_ID_DUPLICATED = 2;
    public static int ERROR_ID_NO_INCLUDE_SPECIFIC_WORDS = 3;
    public static int ERROR_PASSWORD_SIZE = 4;
    public static int ERROR_PASSWORD_NO_INCLUDE_SPECIFIC_WORD = 5;

    public static int getErrorStringId(int guideCode) {
        if(guideCode == ERROR_ID_SIZE) {
            return R.string.error_length_of_id;
        } else if(guideCode == ERROR_ID_DUPLICATED) {
            return R.string.error_already_registered_id;
        } else if(guideCode == ERROR_ID_NO_INCLUDE_SPECIFIC_WORDS) {
            return R.string.error_id_include_only_letter_and_number;
        } else if(guideCode == ERROR_PASSWORD_SIZE) {
            return R.string.error_length_of_password;
        } else if(guideCode == ERROR_PASSWORD_NO_INCLUDE_SPECIFIC_WORD) {
            return R.string.error_password_include_not_letter_or_number_or_special_letter;
        }
        return -1;
    }
}
