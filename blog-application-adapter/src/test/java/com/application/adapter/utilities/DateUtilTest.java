package com.application.adapter.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class DateUtilTest {

    @Test
    void getRecentDate() {
        Assertions.assertNotNull(DateUtil.getRecentDate());
    }
}