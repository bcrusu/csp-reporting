package com.bcrusu.cspreporting.core.filters

import com.bcrusu.cspreporting.core.Report

class BlockedHostFilter : IReportFilter {
    override fun filter(report: Report): Boolean {
        return when (report.blockedHost) {
            "localhost" -> true
            "127.0.0.1" -> true
            else -> false
        }
    }
}
