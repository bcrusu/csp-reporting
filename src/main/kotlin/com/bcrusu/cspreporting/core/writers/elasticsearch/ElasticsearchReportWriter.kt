package com.bcrusu.cspreporting.core.writers.elasticsearch

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import com.bcrusu.cspreporting.core.Report
import com.bcrusu.cspreporting.core.writers.IReportWriter
import com.fasterxml.jackson.databind.ObjectMapper
import org.elasticsearch.client.transport.TransportClient
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Inject

class ElasticsearchReportWriter @Inject constructor(
        val config: ElasticsearchConfiguration,
        val transportClient: TransportClient) : IReportWriter {
    private val _logger = LoggerFactory.getLogger(ElasticsearchReportWriter::class.java)
    private val _objectMapper = ObjectMapper()

    override fun write(report: Report) {
        indexReport(report, "reports")
    }

    override fun writeFiltered(report: Report) {
        indexReport(report, "reports-filtered")
    }

    private fun indexReport(report: Report, type: String) {
        val json = _objectMapper.writeValueAsBytes(report)
        val id = UUID.randomUUID().toString()

        _logger.info("Writing report with ID: $id")

        transportClient.prepareIndex(config.index, type, id)
                .setSource(json)
                .get()
    }
}
