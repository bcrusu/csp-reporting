package com.bcrusu.cspreporting.resources

import com.bcrusu.cspreporting.api.RawReport
import com.bcrusu.cspreporting.core.ReportingEngine
import com.bcrusu.cspreporting.dwext.MediaTypeEx
import com.codahale.metrics.annotation.Timed
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/report")
@Consumes(MediaTypeEx.APPLICATION_CSP_REPORT)
@Produces(MediaType.APPLICATION_JSON)
class ReportResource {
    @POST
    @Timed
    fun report(rawReport: RawReport, @HeaderParam("user-agent") userAgent: String) {
        ReportingEngine().report(rawReport, userAgent)
    }
}
