/**
 * 
 */
package com.redhat.lightblue.client.request;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author bvulaj
 *
 */
public class BulkLightblueDataRequest extends AbstractBulkLightblueRequest<AbstractLightblueDataRequest> {

    public BulkLightblueDataRequest() {
        super();
    }

    public BulkLightblueDataRequest(List<AbstractLightblueDataRequest> requests) {
        super(requests);
    }

    @Override
    public JsonNode getBodyJson() {
        ObjectNode root = JsonNodeFactory.instance.objectNode();
        ArrayNode reqs = JsonNodeFactory.instance.arrayNode();
        for (AbstractLightblueDataRequest req : requests) {
            ObjectNode seqNode = JsonNodeFactory.instance.objectNode();
            seqNode.set("seq", JsonNodeFactory.instance.numberNode(reqs.size()));
            seqNode.set("op", JsonNodeFactory.instance.textNode(req.getOperation()));
            ObjectNode request = (ObjectNode) req.getBodyJson();
            request.set("entity", JsonNodeFactory.instance.textNode(req.getEntityName()));
            request.set("entityVersion", JsonNodeFactory.instance.textNode(req.getEntityVersion()));
            seqNode.set("request", request);
            reqs.add(seqNode);
        }
        root.set("requests", reqs);
        return root;
    }
}
