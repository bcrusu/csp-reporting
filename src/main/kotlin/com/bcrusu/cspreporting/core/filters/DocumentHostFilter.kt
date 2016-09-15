package com.bcrusu.cspreporting.core.filters

import com.bcrusu.cspreporting.core.Report

class DocumentHostFilter : IReportFilter {
    override fun filter(report: Report): Boolean {
        return when {
            report.documentHost.contains("localhost", true) -> true
            else -> false
        }
    }
}
