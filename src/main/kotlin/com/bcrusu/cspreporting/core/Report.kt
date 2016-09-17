package com.bcrusu.cspreporting.core

class Report(
        val documentUri: String,
        val documentHost: String,
        val documentPath: String,

        val blockedUri: String,
        val blockedHost: String,

        val effectiveDirective: String?,
        val originalPolicy: String?,
        val referrer: String?,
        val statusCode: Int?,
        val violatedDirective: String,

        val sourceFile: String?,
        val lineNumber: Int?,
        val columnNumber: Int?,
        val scriptSample: String?,

        val userAgent: String) {
}
