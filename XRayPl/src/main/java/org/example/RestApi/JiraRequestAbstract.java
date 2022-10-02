package org.example.RestApi;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.maven.plugin.logging.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public abstract class JiraRequestAbstract<JiraResponse> {

    protected  Log log =null;

    protected String jiraRequestLink;

    final Class<JiraResponse> typeParameterClass;

    protected JiraRequestAbstract(Log log, Class<JiraResponse> typeParameterClass){
        this.log = log;
        this.typeParameterClass = typeParameterClass;
    }

    protected JiraRequestAbstract( Class<JiraResponse> typeParameterClass){

        this.typeParameterClass = typeParameterClass;
    }

    protected HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        String token = getUserNamePasswordToken();
        headers.add("Authorization", "Basic" + token);

        return headers;

    }

    abstract protected HttpEntity<LinkedMultiValueMap<String, Object>> getHttpEntity();

    public JiraResponse getResponsePost(){
        log.info("Preparing message ");
        try {
            log.info(String.format(" Sent message to %s", jiraRequestLink));
            ResponseEntity<JiraResponse> jiraResponseEntity  = buildRestTemplate().postForEntity(jiraRequestLink, getHttpEntity(), typeParameterClass);
            log.info(String.format(" Response: %s", jiraResponseEntity.toString()));
            return jiraResponseEntity.getBody();
        } catch (HttpServerErrorException e) {
            log.error("Incorrect request"+e.getResponseBodyAsString());
            throw new RuntimeException(e);
        }
        catch (NoSuchAlgorithmException | KeyStoreException| KeyManagementException e) {
            e.printStackTrace();
        }
        return null;

    }

    protected static RestTemplate buildRestTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType)-> true;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    private static String getUserNamePasswordToken() {
        final String userpass = System.getProperty("user")+":" + System.getProperty("password");
        final String token = new String(new Base64().encode(userpass.getBytes()));
        return token;
    }
}
