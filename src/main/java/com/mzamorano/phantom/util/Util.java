package com.mzamorano.phantom.util;

// minimally adapted from Apache Commons Lang
public class Util {
    private static boolean charSequenceIsEmpty(final CharSequence cs) {
        return cs == null || cs.isEmpty();
    }

    public static String stringRemoveStart(final String str, final String remove) {
        if (charSequenceIsEmpty(str) || charSequenceIsEmpty(remove)) {
            return str;
        }
        if (str.startsWith(remove)){
            return str.substring(remove.length());
        }
        return str;
    }
}
