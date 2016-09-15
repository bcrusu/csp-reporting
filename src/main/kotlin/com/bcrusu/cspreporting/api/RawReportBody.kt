package com.bcrusu.cspreporting.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.Min

data class RawReportBody(
        @JsonProperty("blocked-uri") @NotEmpty val blockedUri: String,
        @JsonProperty("document-uri") @NotEmpty val documentUri: String,
        @JsonProperty("effective-directive") val effectiveDirective: String,
        @JsonProperty("original-policy") val originalPolicy: String,
        @JsonProperty("referrer") val referrer: String,
        @JsonProperty("status-code") @Min(0) val statusCode: Int,
        @JsonProperty("violated-directive") val violatedDirective: String,
        @JsonProperty("source-file") val sourceFile: String,
        @JsonProperty("line-number") val lineNumber: String,
        @JsonProperty("column-number") val columnNumber: String
)
