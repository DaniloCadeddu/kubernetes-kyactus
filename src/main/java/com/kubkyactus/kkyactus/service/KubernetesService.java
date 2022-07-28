package com.kubkyactus.kkyactus.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KubernetesService {

    public CoreV1Api getApiClient() {
        try {
            ApiClient client = Config.defaultClient();
            Configuration.setDefaultApiClient(client);
            return new CoreV1Api();
        }
        catch (Exception e) {
            log.error("Error creating k8s api client", e);
        }
        return null;
    }

}
