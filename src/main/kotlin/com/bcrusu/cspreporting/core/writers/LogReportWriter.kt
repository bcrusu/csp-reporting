package com.bcrusu.cspreporting.core.writers

import com.bcrusu.cspreporting.core.Report
import org.slf4j.LoggerFactory

class LogReportWriter(val level: String) : IReportWriter {
    private val _logger = LoggerFactory.getLogger(LogReportWriter::class.java)

    override fun write(report: Report) {
        //TODO
        _logger.info(report.toString())
    }

    override fun writeFiltered(report: Report, reason: String) {
        //TODO
        _logger.info(report.toString() + " " + reason)
    }
}
