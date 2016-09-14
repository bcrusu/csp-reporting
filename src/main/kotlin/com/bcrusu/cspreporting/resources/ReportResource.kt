package com.bcrusu.cspreporting.resources

import com.bcrusu.cspreporting.core.Report
import com.codahale.metrics.annotation.Timed
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Consumes
import javax.ws.rs.core.MediaType

@Path("/report")
@Consumes(MediaType.APPLICATION_JSON)
class ReportResource {
    @POST
    @Timed
    fun report(report: Report) {
        //TODO:
    }
}
