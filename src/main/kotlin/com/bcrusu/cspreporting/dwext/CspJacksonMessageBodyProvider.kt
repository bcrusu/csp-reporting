package com.bcrusu.cspreporting.dwext

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider
import javax.ws.rs.core.MediaType

internal class CspJacksonMessageBodyProvider(mapper: ObjectMapper?) : JacksonMessageBodyProvider(mapper) {
    companion object {
        val CspReportMediaType: MediaType = MediaType("application", "csp-report")
    }

    override fun hasMatchingMediaType(mediaType: MediaType?): Boolean {
        return CspReportMediaType == mediaType
    }
}
