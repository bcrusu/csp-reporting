package com.bcrusu.cspreporting.core.writers

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import com.bcrusu.cspreporting.core.Report
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.slf4j.LoggerFactory
import java.net.InetAddress
import javax.inject.Inject

class ElasticsearchReportWriter @Inject constructor(val config: ElasticsearchConfiguration) : IReportWriter {
    private val _logger = LoggerFactory.getLogger(ElasticsearchReportWriter::class.java)

    override fun write(report: Report) {
        //TODO: val client = TransportClient.builder().build().addTransportAddress(InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300))
    }

    override fun writeFiltered(report: Report) {
        //TODO
        //_logger.info(report.toString() + " " + reason)
    }
}
