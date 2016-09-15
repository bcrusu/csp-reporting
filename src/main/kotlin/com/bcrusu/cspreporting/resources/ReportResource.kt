package com.bcrusu.cspreporting.resources

import com.bcrusu.cspreporting.api.RawReport
import com.bcrusu.cspreporting.core.ReportingEngine
import com.codahale.metrics.annotation.Timed
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/report")
@Consumes("application/csp-report")
@Produces(MediaType.APPLICATION_JSON)
class ReportResource {
    @POST
    @Timed
    fun report(rawReport: RawReport) {
        ReportingEngine().report(rawReport)
    }
}
