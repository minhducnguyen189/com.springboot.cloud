package com.application.adapter.utilities;

import com.application.adapter.constants.Constant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil() {}

    public static String getRecentDate() {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern(Constant.DATE_TIME_FORMAT);
        ZoneId zoneId = ZoneId.of(Constant.ZONE_ID);
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        return localDateTime.format(formatter);
    }
}
