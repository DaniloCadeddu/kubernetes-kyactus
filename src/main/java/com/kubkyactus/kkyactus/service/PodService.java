package com.kubkyactus.kkyactus.service;


import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            return apiClient.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null)
                    .getItems()
                    .stream()
                    .map(pod -> Optional.ofNullable(pod.getMetadata())
                            .map(V1ObjectMeta::getName)
                            .orElse(""))
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            log.error("Error getting list of pods", e);
            return Collections.emptyList();
        }
    }
}
