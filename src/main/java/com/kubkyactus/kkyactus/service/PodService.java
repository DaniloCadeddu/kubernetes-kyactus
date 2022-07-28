package com.kubkyactus.kkyactus.service;


import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PodService {

    private final KubernetesService k8sService;

    @Autowired
    public PodService(KubernetesService k8sService) {
        this.k8sService = k8sService;
    }

    public List<String> getAllPodsName() {
        CoreV1Api apiClient = k8sService.getApiClient();
        if (apiClient == null) {
            return Collections.emptyList();
        }
        try {
            List<V1Pod> pods = apiClient.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null)
                    .getItems();
            List<String> podsNames = new ArrayList<>();

            pods.forEach(pod -> {
                if (pod.getMetadata() != null) {
                    podsNames.add(pod.getMetadata().getName());
                }
            });
            return podsNames;
        }
        catch (Exception e) {
            log.error("Error getting list of pods", e);
            return Collections.emptyList();
        }
    }
}
