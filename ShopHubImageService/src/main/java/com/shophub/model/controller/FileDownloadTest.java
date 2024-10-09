/*
package com.shophub.model.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class FileDownloadTest {

    public static void main(String[] args) {

        String url = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/1.png";
        FileDownloadTest.crunchifyFileDownloadUsingHttpComponents(url);
    }

    private static void crunchifyFileDownloadUsingHttpComponents(String crunchifyURL) {
        URL crunchifyRobotsURL = null;
        try {
            crunchifyRobotsURL = new URL(crunchifyURL);

            FileUtils.copyURLToFile(crunchifyRobotsURL, new File("C:\\Users\\User\\Downloads\\robots_stream.png"));
            CloseableHttpClient crunchifyHTTPClient = HttpClients.createDefault();

            HttpGet crunchifyHTTPGet = new HttpGet(crunchifyURL);

            CloseableHttpResponse crunchifyHTTPResponse = null;

            crunchifyHTTPResponse = crunchifyHTTPClient.execute(crunchifyHTTPGet);
            HttpEntity crunchifyHttpEntity = crunchifyHTTPResponse.getEntity();

            if (crunchifyHttpEntity != null) {
                crunchifyHttpEntity.getContent()
                FileUtils.copyInputStreamToFile(crunchifyHttpEntity.getContent(), new File("C:\\Users\\User\\Downloads\\robots_stream.png"));
            }
        } catch (IOException e) {
            // IOException: Signals that an I/O exception of some sort has occurred.
            // This class is the general class of exceptions produced by failed or interrupted I/O operations.
            log.error(e.getLocalizedMessage());
        }

        printResult("File Downloaded Successfully with Apache HttpComponents() Operation \n");
    }

    // Simple Crunchify Print Utility
    private static void printResult(String crunchifyResult) {
        System.out.println(crunchifyResult);
    }
}
*/
