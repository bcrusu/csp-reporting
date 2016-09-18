package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import com.bcrusu.cspreporting.core.filters.IReportFilter
import com.bcrusu.cspreporting.core.filters.ReportFilterProvider
import com.bcrusu.cspreporting.core.writers.elasticsearch.ElasticsearchReportWriter
import com.bcrusu.cspreporting.core.writers.IReportWriter
import com.bcrusu.cspreporting.core.writers.elasticsearch.TransportClientProvider
import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import org.elasticsearch.client.transport.TransportClient
import javax.inject.Singleton

object GuiceConfig {
    fun createInjector(config: AppConfiguration): Injector {
        return Guice.createInjector(object : AbstractModule() {
            override fun configure() {
                bind(ElasticsearchConfiguration::class.java).toInstance(config.elasticsearch)
                bind(IReportWriter::class.java).to(ElasticsearchReportWriter::class.java)
                bind(IReportFilter::class.java).toProvider(ReportFilterProvider::class.java)

                bind(TransportClient::class.java).toProvider(TransportClientProvider::class.java).`in`(Singleton::class.java)
            }
        })
    }
}
