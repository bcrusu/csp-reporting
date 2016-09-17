package com.bcrusu.cspreporting.core.writers

import com.bcrusu.cspreporting.core.Report
import org.slf4j.LoggerFactory

class ElasticsearchReportWriter(val level: String) : IReportWriter {
    private val _logger = LoggerFactory.getLogger(ElasticsearchReportWriter::class.java)

    override fun write(report: Report) {
        //TODO
        //_logger.info(report.toString())
    }

    override fun writeFiltered(report: Report) {
        //TODO
        //_logger.info(report.toString() + " " + reason)
    }
}
