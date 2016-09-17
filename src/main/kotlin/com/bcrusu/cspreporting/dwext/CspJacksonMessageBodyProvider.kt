package com.bcrusu.cspreporting.dwext

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jersey.jackson.JacksonMessageBodyProvider
import javax.ws.rs.core.MediaType

internal class CspJacksonMessageBodyProvider(mapper: ObjectMapper?) : JacksonMessageBodyProvider(mapper) {
    override fun hasMatchingMediaType(mediaType: MediaType?): Boolean {
        return MediaTypeEx.APPLICATION_CSP_REPORT_TYPE == mediaType
    }
}
