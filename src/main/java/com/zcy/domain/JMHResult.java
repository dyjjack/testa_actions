package com.zcy.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;  

@Data
public class JMHResult {  
    private String jmhVersion;  
    private String benchmark;  
    private String mode;  
    private int threads;  
    private int forks;  
    private String jvm;  
    private List<String> jvmArgs;  
    private String jdkVersion;  
    private String vmName;  
    private String vmVersion;  
    private int warmupIterations;  
    private String warmupTime;  
    private int warmupBatchSize;  
    private int measurementIterations;  
    private String measurementTime;  
    private int measurementBatchSize;  
    private PrimaryMetric primaryMetric;  
    private Map<String, Object> secondaryMetrics;
    private Map<String, String> params;
  
    // Getters and setters are omitted for brevity  

    @Data
    public static class PrimaryMetric {
        private Double score;
        private String scoreError;  
        private List<String> scoreConfidence;  
        private Map<String, Double> scorePercentiles;  
        private String scoreUnit;  
        private List<List<Double>> rawData;  
  
        // Getters and setters are omitted for brevity  
    }  
}