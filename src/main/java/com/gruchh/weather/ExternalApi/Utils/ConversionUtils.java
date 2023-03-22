package com.gruchh.weather.ExternalApi.Utils;

public class ConversionUtils {

    public static Double convertStringToDouble(String string) {
        if (string == null) {
            return 0.0;
        } else {
            try {
                return Double.parseDouble(string);
            } catch (Exception ex) {
                return 0.0;
            }
        }
    }

    public static Long convertStringToLong(String string) {
        if (string == null) {
            return Long.parseLong("0", 10) ;
        } else {
            try {
                return Long.parseLong(string, 10) ;
            } catch (Exception ex) {
                return Long.parseLong("0", 10) ;
            }
        }
    }

}
