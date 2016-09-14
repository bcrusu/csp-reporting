package com.bcrusu.cspreporting.core

import com.fasterxml.jackson.annotation.JsonProperty

data class ReportBody(
        @JsonProperty("blocked-uri") val blockedUri: String,
        @JsonProperty("document-uri") val documentUri: String,
        @JsonProperty("effective-directive") val effectiveDirective: String,
        @JsonProperty("original-policy") val originalPolicy: String,
        @JsonProperty("referrer") val referrer: String,
        @JsonProperty("status-code") val statusCode: Int,
        @JsonProperty("violated-directive") val violatedDirective: String,
        @JsonProperty("source-file") val sourceFile: String,
        @JsonProperty("line-number") val lineNumber: String,
        @JsonProperty("column-number") val columnNumber: String
)
