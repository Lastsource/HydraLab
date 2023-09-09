// Copyright (c) Microsoft Corporation.
// Licensed under the MIT License.
package com.microsoft.hydralab.performance.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.microsoft.hydralab.performance.IBaselineMetrics;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;

@Data
public class AndroidMemoryInfo implements Serializable, IBaselineMetrics {
    private String appPackageName;
    private long timeStamp;
    private String description;
    /**
     * Index mapping is shown as below:
     * <p>
     * 0:  Java Heap PSS;       1. Java Heap RSS;
     * 2.  Native Heap PSS;     3. Native Heap RSS;
     * 4.  Code PSS;            5. Code RSS;
     * 6.  Stack PSS;           7. Stack RSS;
     * 8.  Graphics PSS;        9. Graphics RSS;
     * 10. Private Other PSS;   11. Private Other RSS;
     * 12. System PSS;          13. System RSS;
     * 14. Unknown PSS;         15. Unknown RSS;
     * 16. TOTAL PSS;           17. TOTAL RSS;          18. TOTAL SWAP PSS;
     * <p>
     * Since blanks exist in memory summary, some data may not be fetched, default value 0 is then applied.
     */
    private long javaHeapPss;
    private long javaHeapRss;
    private long nativeHeapPss;
    private long nativeHeapRss;
    private long codePss;
    private long codeRss;
    private long stackPss;
    private long stackRss;
    private long graphicsPss;
    private long graphicsRss;
    private long privateOtherPss;
    private long privateOtherRss;
    private long systemPss;
    private long systemRss;
    private long unknownPss;
    private long unknownRss;
    private long totalPss;
    private long totalRss;
    private long totalSwapPss;

    @Override
    @JSONField(serialize = false)
    public LinkedHashMap<String, Double> getBaselineMetricsKeyValue() {
        LinkedHashMap<String, Double> baselineMap = new LinkedHashMap<>();
        baselineMap.put("totalPss", (double) totalPss);
        baselineMap.put("javaHeapPss", (double) javaHeapPss);
        baselineMap.put("nativeHeapPss", (double) nativeHeapPss);
        baselineMap.put("graphicsPss", (double) graphicsPss);
        baselineMap.put("codePss", (double) codePss);
        return baselineMap;
    }

    @Override
    @JSONField(serialize = false)
    public SummaryType getSummaryType() {
        return SummaryType.AVERAGE;
    }
}
