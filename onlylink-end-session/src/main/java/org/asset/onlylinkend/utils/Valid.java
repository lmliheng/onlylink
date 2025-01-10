package org.asset.onlylinkend.utils;

public class Valid {
    public static boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return email.matches(regex);
    }

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        return phone.matches(regex);
    }

    public static boolean isNickname(String Nickname) {
        if (Nickname.length() > 0 && Nickname.length() < 16) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isPassword(String password) {
        if (password.length() > 0 && password.length() < 20) {
            return true;
        } else {
            return false;
        }

    }

}
