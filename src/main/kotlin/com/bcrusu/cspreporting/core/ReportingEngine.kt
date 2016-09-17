package com.bcrusu.cspreporting.core

import com.bcrusu.cspreporting.api.RawReport
import com.bcrusu.cspreporting.core.filters.IReportFilter
import com.bcrusu.cspreporting.core.filters.ReportFilterFactory
import com.bcrusu.cspreporting.core.writers.ElasticsearchReportWriter
import com.bcrusu.cspreporting.core.writers.IReportWriter
import org.slf4j.LoggerFactory

class ReportingEngine {
    private val _logger = LoggerFactory.getLogger(ReportingEngine::class.java)
    private val _reportProcessor: ReportProcessor
    private val _reportFilter: IReportFilter
    private val _reportWriter: IReportWriter

    init {
        _reportProcessor = ReportProcessor()
        _reportFilter = ReportFilterFactory.build()
        _reportWriter = ElasticsearchReportWriter("INFO")
    }

    fun report(rawReport: RawReport, userAgent: String) {
        val report = _reportProcessor.process(rawReport, userAgent)

        val isFiltered = _reportFilter.filter(report)
        if (isFiltered)
            _reportWriter.writeFiltered(report)
        else
            _reportWriter.write(report)
    }
}
