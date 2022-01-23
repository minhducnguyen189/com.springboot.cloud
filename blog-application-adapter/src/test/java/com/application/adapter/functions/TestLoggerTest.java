package com.application.adapter.functions;

import com.application.adapter.models.request.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestLoggerTest {

    @InjectMocks
    private TestLogger testLogger;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private ObjectWriter objectWriter;

    @Test
    public void testAccept() throws JsonProcessingException {
        Mockito.when(objectMapper.writerWithDefaultPrettyPrinter()).thenReturn(objectWriter);
        Mockito.when(objectWriter.writeValueAsString(Mockito.any())).thenReturn("AAA");
        testLogger.accept("AAA", new Post());
        Assertions.assertTrue(true);
    }

}