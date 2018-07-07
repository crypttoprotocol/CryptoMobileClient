package com.crypto.mobile.client.utility;

import com.crypto.mobile.client.R;

public class TextUtil {
    private static int ID_MIN_LENGTH = 8;
    private static int PASSWORD_MIN_LENGTH = 8;

    public static int NO_ERROR = 0;
    public static int ERROR_ID_EMPTY = 1;
    public static int ERROR_ID_SIZE = 2;
    public static int ERROR_ID_INCLUDE_OTHER_WORD_EXCEPT_LETTER_AND_NUMBER = 3;
    public static int ERROR_PASS_EMPTY = 4;
    public static int ERROR_PASS_SIZE = 5;
    public static int ERROR_PASSWORD_STRUCTURE_WRONG = 6;
    public static int ERROR_PASSWORD_NOT_SAME_CONFIRMED = 7;

    public static int getErrorStringId(int guideCode) {
        if(guideCode == ERROR_ID_EMPTY) {
            return R.string.error_id_empty;
        } else if(guideCode == ERROR_ID_SIZE) {
            return R.string.error_id_size;
        } else if(guideCode == ERROR_ID_INCLUDE_OTHER_WORD_EXCEPT_LETTER_AND_NUMBER) {
            return R.string.error_id_include_only_letter_and_number;
        } else if(guideCode == ERROR_PASS_EMPTY) {
            return R.string.error_password_empty;
        } else if(guideCode == ERROR_PASS_SIZE) {
            return R.string.error_length_of_password;
        } else if(guideCode == ERROR_PASSWORD_STRUCTURE_WRONG) {
            return R.string.error_password_include_not_letter_or_number_or_special_letter;
        } else if(guideCode == ERROR_PASSWORD_NOT_SAME_CONFIRMED) {
            return R.string.error_password_do_not_match;
        }
        return R.string.blank;
    }

    public static int checkIdAndPassword(String id, String password) {
        if(id == null || id.isEmpty()) {
            return ERROR_ID_EMPTY;
        }if(id.length() < ID_MIN_LENGTH) {
            return ERROR_ID_SIZE;
        } else if(isOtherWordExceptLetterAndNumberIncluded(id)) {
            return ERROR_ID_INCLUDE_OTHER_WORD_EXCEPT_LETTER_AND_NUMBER;
        } else if(password == null || password.isEmpty()) {
            return ERROR_PASS_EMPTY;
        } else if(password.length() < PASSWORD_MIN_LENGTH) {
            return ERROR_PASS_SIZE;
        } else if(!isTextAndNumAndSpecialWordIncluded(password)) {
            return ERROR_PASSWORD_STRUCTURE_WRONG;
        }
        return NO_ERROR;
    }

    public static int checkIdAndPassword(String id, String password, String passwordConfirmed) {
        if(id == null || id.isEmpty()) {
            return ERROR_ID_EMPTY;
        }if(id.length() < ID_MIN_LENGTH) {
            return ERROR_ID_SIZE;
        } else if(isOtherWordExceptLetterAndNumberIncluded(id)) {
            return ERROR_ID_INCLUDE_OTHER_WORD_EXCEPT_LETTER_AND_NUMBER;
        } else if(password == null || password.isEmpty()) {
            return ERROR_PASS_EMPTY;
        } else if(password.length() < PASSWORD_MIN_LENGTH) {
            return ERROR_PASS_SIZE;
        } else if(!isTextAndNumAndSpecialWordIncluded(password)) {
            return ERROR_PASSWORD_STRUCTURE_WRONG;
        } else if(passwordConfirmed == null || !password.equals(passwordConfirmed)) {
            return ERROR_PASSWORD_NOT_SAME_CONFIRMED;
        }
        return NO_ERROR;
    }

    public static boolean isOtherWordExceptLetterAndNumberIncluded(String string) {
        boolean result = false;
        return result;
    }

    public static boolean isIdDuplicated(String id) {
        boolean result = false;
        //it need to check the id if it is duplicated in server.
        return result;
    }

    public static boolean isTextAndNumAndSpecialWordIncluded(String password) {
        boolean result = true;
        return result;
    }
}
