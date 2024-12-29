package com.mzamorano.phantom;

import com.mzamorano.phantom.str.StringMapReader;
import com.mzamorano.phantom.str.StringReader;

public class Main {
    public static void main(String[] args) {
        StringReader s = new StringMapReader("strings/all");
        System.out.println(s.read("helloworld"));
    }
}
