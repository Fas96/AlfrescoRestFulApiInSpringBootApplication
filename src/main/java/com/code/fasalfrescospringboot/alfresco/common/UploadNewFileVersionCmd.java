package com.code.fasalfrescospringboot.alfresco.common;

import org.alfresco.core.handler.NodesApi;
import org.alfresco.core.model.Node;
import org.alfresco.core.model.NodeBodyCreate;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UploadNewFileVersionCmd {
    static final Logger LOGGER = LoggerFactory.getLogger(UploadNewFileVersionCmd.class);

    private Boolean majorVersion = true;
    private String updateComment = null;
    private String updatedName = null;
    private List<String> include = null;
    private List<String> fields = null;

    @Autowired
    NodesApi nodesApi;

    public void execute(String textFileNodeId, String binFileNodeId) throws IOException {
        // Update text content for a file
        Node newTextFile = updateTextFileContent(textFileNodeId,"Some UPDATED text for the file");

        // Upload a file as new content
        Node newFile = uploadNewFileVersion(binFileNodeId, "src/main/webapp/img/testFile.png");
    }

    /**
     * Upload a file from disk as a new version
     */
    private Node uploadNewFileVersion(String fileNodeId, String filePath) {
        // Get the file bytes
        File someFile = new File(filePath);
        byte[] fileData = null;
        try {
            fileData = FileUtils.readFileToByteArray(someFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the file node content
        Node updatedFileNode = nodesApi.updateNodeContent(fileNodeId,
                fileData, majorVersion, updateComment, updatedName, include, fields).getBody().getEntry();

        LOGGER.info("Uploaded new content for file: {}", updatedFileNode.toString());

        return updatedFileNode;
    }

    /**
     * Update text content for a file
     */
    private Node updateTextFileContent(String fileNodeId, String textContent) {
        // Update the file node content
        Node updatedFileNode = nodesApi.updateNodeContent(fileNodeId,
                textContent.getBytes(), majorVersion, updateComment, updatedName, include, fields).getBody().getEntry();

        LOGGER.info("Updated text content for file: {}", updatedFileNode.toString());

        return updatedFileNode;
    }
}
