package com.bcrusu.cspreporting.core

import com.bcrusu.cspreporting.api.RawReport
import com.bcrusu.cspreporting.core.filters.IReportFilter
import com.bcrusu.cspreporting.core.writers.IReportWriter
import org.slf4j.LoggerFactory
import javax.inject.Inject

class ReportingEngine @Inject constructor(val reportWriter: IReportWriter,
                                          val reportFilter: IReportFilter) {
    private val _logger = LoggerFactory.getLogger(ReportingEngine::class.java)
    private val _reportProcessor: ReportProcessor

    init {
        _reportProcessor = ReportProcessor()
    }

    fun report(rawReport: RawReport, userAgent: String) {
        val report = _reportProcessor.process(rawReport, userAgent)

        val isFiltered = reportFilter.filter(report)
        if (isFiltered)
            reportWriter.writeFiltered(report)
        else
            reportWriter.write(report)
    }
}
