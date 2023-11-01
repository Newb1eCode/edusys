/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author VuMinhHa
 */
public class DateHelper {

    static final SimpleDateFormat date_formater = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                date_formater.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            System.out.println(date);
            return date_formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            date_formater.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return date_formater.format(date);
    }

    private static Date now() {
        return new Date();
    }

    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }
}
