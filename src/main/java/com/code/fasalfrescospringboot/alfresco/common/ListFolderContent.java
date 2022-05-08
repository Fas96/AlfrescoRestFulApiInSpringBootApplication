package com.code.fasalfrescospringboot.alfresco.common;

import org.alfresco.core.handler.NodesApi;
import org.alfresco.core.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ListFolderContent {
    static final Logger LOGGER = LoggerFactory.getLogger(ListFolderContent.class);

    @Autowired
    NodesApi nodesApi;

    public void execute() throws IOException {
        NodeChildAssociationPagingList nodes = listWhereFolderContentCondition("-root-", null);
        NodeChildAssociationPagingList nodes2 = listWhereFolderContentCondition("-root-", "/Data Dictionary");
    }

    /**
     * List contents (i.e. folders and files) of a folder.
     *
     * @param rootNodeId         the id of the folder node that is the root. If relativeFolderPath is null, then content in this folder will be listed. Besides node ID the aliases -my-, -root- and -shared- are also supported.
     * @param relativeFolderPath path relative rootNodeId, if this is not null, then the content of this folder will be listed
     * @return a list of child node objects contained in the folder, or null if not found
     */
    private NodeChildAssociationPagingList listFolderContent(String rootNodeId, String relativeFolderPath) {
        Integer skipCount = 0;
        Integer maxItems = 100;
        List<String> include = null;
        List<String> fields = null;
        List<String> orderBy = null;
        String where = null;
        Boolean includeSource = false;

        LOGGER.info("Listing folder {}{}", rootNodeId, relativeFolderPath);
        NodeChildAssociationPagingList result = nodesApi.listNodeChildren(rootNodeId, skipCount, maxItems, orderBy, where, include,
                relativeFolderPath, includeSource, fields).getBody().getList();
        for (NodeChildAssociationEntry childNodeAssoc: result.getEntries()) {
            LOGGER.info("Found node [name=" + childNodeAssoc.getEntry().getName() + "]");
        }

        return result;
    }

    /**
     * List sub-folders of a folder.
     *
     * @param rootNodeId         the id of the folder node that is the root. If relativeFolderPath is null, then content in this folder will be listed. Besides node ID the aliases -my-, -root- and -shared- are also supported.
     * @param relativeFolderPath path relative rootNodeId, if this is not null, then the content of this folder will be listed
     * @return a list of child folder node objects contained in the folder, or null if not found
     */
    private NodeChildAssociationPagingList listWhereFolderContentCondition(String rootNodeId, String relativeFolderPath) {
        Integer skipCount = 0;
        Integer maxItems = 100;
        List<String> include = null;
        List<String> fields = null;
        List<String> orderBy = null;
        String where = "(isFolder=true)";
        Boolean includeSource = false;

        LOGGER.info("Listing folder {}{} with filter {}", rootNodeId, relativeFolderPath, where);
        NodeChildAssociationPagingList result = nodesApi.listNodeChildren(rootNodeId, skipCount, maxItems, orderBy, where, include,
                relativeFolderPath, includeSource, fields).getBody().getList();
        for (NodeChildAssociationEntry childNodeAssoc: result.getEntries()) {
            LOGGER.info("Found folder node [name=" + childNodeAssoc.getEntry().getName() + "]");
        }

        return result;
    }
}
