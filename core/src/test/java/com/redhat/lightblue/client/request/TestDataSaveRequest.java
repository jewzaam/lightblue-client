package com.redhat.lightblue.client.request;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.redhat.lightblue.client.Projection;
import com.redhat.lightblue.client.request.data.DataSaveRequest;

public class TestDataSaveRequest {

    @Test
    public void testProjectionsAsList() {
        DataSaveRequest request = new DataSaveRequest("fake");
        request.returns(Arrays.asList(Projection.includeField("*")));
        request.create("");

        assertTrue(request.getBody(), request.getBody().contains(
                "\"projection\":{\"field\":\"*\",\"include\":true,\"recursive\":false}"));
    }

    @Test
    public void testProjectionsAsArray() {
        DataSaveRequest request = new DataSaveRequest("fake");
        request.returns(Projection.includeField("*"));
        request.create("");

        assertTrue(request.getBody(), request.getBody().contains(
                "\"projection\":{\"field\":\"*\",\"include\":true,\"recursive\":false}"));
    }
}
