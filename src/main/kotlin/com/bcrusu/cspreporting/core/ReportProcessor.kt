package com.bcrusu.cspreporting.core

import com.bcrusu.cspreporting.api.RawReport
import java.net.URI
import java.net.URISyntaxException

class ReportProcessor {
    fun process(rawReport: RawReport, userAgent: String): Report {
        val blockedUri = normalizeBlockedUri(rawReport.body.blockedUri)
        val documentUri = normalizeUri(rawReport.body.documentUri)

        return Report(
                documentUri?.toString() ?: "",
                documentUri?.host ?: "",
                documentUri?.path ?: "",
                blockedUri?.toString() ?: "",
                blockedUri?.host ?: "",
                rawReport.body.effectiveDirective,
                rawReport.body.originalPolicy,
                rawReport.body.referrer,
                rawReport.body.statusCode,
                rawReport.body.violatedDirective,
                rawReport.body.sourceFile,
                rawReport.body.lineNumber,
                rawReport.body.columnNumber,
                rawReport.body.scriptSample,
                userAgent)
    }

    private fun normalizeBlockedUri(blockedUri: String?): URI? {
        val trimmed = blockedUri?.trim() ?: ""

        // check for inline violation
        if (trimmed.isEmpty() ||
                trimmed.compareTo("self", true) == 0 || // Firefox
                trimmed.compareTo("inline", true) == 0)  // Chrome
            return null

        return normalizeUri(trimmed)
    }

    private fun normalizeUri(uriString: String): URI? {
        try {
            val uri = URI(uriString)
            val host = removeWwwPrefix(uri.host)

            // ignore port, user info
            return URI(uri.scheme, null, host, -1, uri.path, uri.query, uri.fragment)
        } catch (e: URISyntaxException) {
            //TODO: log
            return null
        }
    }

    private fun removeWwwPrefix(host: String): String {
        if (host.startsWith("www.", true))
            return host.substring(4)

        return host
    }
}
