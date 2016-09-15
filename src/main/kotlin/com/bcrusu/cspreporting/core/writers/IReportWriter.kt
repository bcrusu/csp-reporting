package com.bcrusu.cspreporting.core.writers

import com.bcrusu.cspreporting.core.Report

interface IReportWriter {
    fun write(report: Report)
    fun writeFiltered(report: Report, reason: String)
}
