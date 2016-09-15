package com.bcrusu.cspreporting.core.filters

object ReportFilterFactory {
    fun build(): IReportFilter {
        val orderedFilters = listOf(DocumentHostFilter())
        return CompositeFilter(orderedFilters)
    }
}
