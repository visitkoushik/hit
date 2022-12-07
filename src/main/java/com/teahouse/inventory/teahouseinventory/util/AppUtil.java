package com.teahouse.inventory.teahouseinventory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtil {

    private AppUtil(){}


    public static Date StringToDate(String strDate) throws ParseException{
      return  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(strDate);

    }



    public static String DateToString(Date strDate) throws ParseException{
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(strDate);
  
      }


}
