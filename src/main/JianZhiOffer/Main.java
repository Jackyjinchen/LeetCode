package main.JianZhiOffer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/3
 * @Content: 测试类
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Date date  = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        date = sdf.parse("202109");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int i = 0; i < 36; i++) {
            calendar.add(Calendar.MONTH, -1);
            System.out.println(sdf.format(calendar.getTime()));
        }
//        System.out.println(date);
    }
}
