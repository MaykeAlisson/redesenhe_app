package br.com.redesenhe.redesenhe.infra.util;

import android.text.TextUtils;

public class UtilString {

    /**
     * Checkd is email valid
     * @param target
     * @return true is valid else false
     */
    public static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
