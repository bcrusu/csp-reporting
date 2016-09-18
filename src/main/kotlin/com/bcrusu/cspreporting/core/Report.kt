package com.bcrusu.cspreporting.core

import com.fasterxml.jackson.annotation.JsonProperty

class Report(
        @JsonProperty("documentUri") val documentUri: String,
        @JsonProperty("documentHost") val documentHost: String,
        @JsonProperty("documentPath") val documentPath: String,

        @JsonProperty("blockedUri") val blockedUri: String,
        @JsonProperty("blockedHost") val blockedHost: String,

        @JsonProperty("effectiveDirective") val effectiveDirective: String?,
        @JsonProperty("originalPolicy") val originalPolicy: String?,
        @JsonProperty("referrer") val referrer: String?,
        @JsonProperty("statusCode") val statusCode: Int?,
        @JsonProperty("violatedDirective") val violatedDirective: String,

        @JsonProperty("sourceFile") val sourceFile: String?,
        @JsonProperty("lineNumber") val lineNumber: Int?,
        @JsonProperty("columnNumber") val columnNumber: Int?,
        @JsonProperty("scriptSample") val scriptSample: String?,

        @JsonProperty("userAgent") val userAgent: String) {
}
