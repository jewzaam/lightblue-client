package com.redhat.lightblue.client.request;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.redhat.lightblue.client.Projection;
import com.redhat.lightblue.client.Update;
import com.redhat.lightblue.client.request.data.DataUpdateRequest;

public class TestDataUpdateRequest {

    @Test
    public void testUpdatesAsList() {
        DataUpdateRequest request = new DataUpdateRequest("fake");
        request.updates(Arrays.asList(Update.set("fakeField1", true)));

        assertTrue(request.getBody(), request.getBody().contains("\"fakeField1\":true"));
    }

    @Test
    public void testUpdatesAsArray() {
        DataUpdateRequest request = new DataUpdateRequest("fake");
        request.updates(Update.set("fakeField1", true));

        assertTrue(request.getBody(), request.getBody().contains("\"fakeField1\":true"));
    }

    @Test
    public void testProjectionsAsList(){
        DataUpdateRequest request = new DataUpdateRequest("fake");
        request.returns(Arrays.asList(Projection.includeField("*")));

        assertTrue(request.getBody(), request.getBody().contains(
                "\"projection\":{\"field\":\"*\",\"include\":true,\"recursive\":false}"));
    }

    @Test
    public void testProjectionsAsArray() {
        DataUpdateRequest request = new DataUpdateRequest("fake");
        request.returns(Projection.includeField("*"));

        assertTrue(request.getBody(), request.getBody().contains(
                "\"projection\":{\"field\":\"*\",\"include\":true,\"recursive\":false}"));
    }

}
