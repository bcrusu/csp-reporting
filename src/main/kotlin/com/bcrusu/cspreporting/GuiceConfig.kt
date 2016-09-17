package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import com.bcrusu.cspreporting.core.filters.IReportFilter
import com.bcrusu.cspreporting.core.filters.ReportFilterProvider
import com.bcrusu.cspreporting.core.writers.ElasticsearchReportWriter
import com.bcrusu.cspreporting.core.writers.IReportWriter
import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector

object GuiceConfig {
    fun createInjector(config: AppConfiguration): Injector {
        return Guice.createInjector(object : AbstractModule() {
            override fun configure() {
                bind(ElasticsearchConfiguration::class.java).to(config.elasticsearch)
                bind(IReportWriter::class.java).to(ElasticsearchReportWriter::class.java)
                bind(IReportFilter::class.java).toProvider(ReportFilterProvider::class.java)
            }
        })
    }
}
