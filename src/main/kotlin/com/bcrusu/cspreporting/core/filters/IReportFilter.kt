package com.bcrusu.cspreporting.core.filters

import com.bcrusu.cspreporting.core.Report

interface IReportFilter {
    fun filter(report: Report): Boolean
}
