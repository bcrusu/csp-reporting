package com.bcrusu.cspreporting.core

import com.bcrusu.cspreporting.api.RawReport

class ReportProcessor {
    fun process(rawReport: RawReport): Report {
        //TODO
        return Report(rawReport.body.documentUri)
    }
}
