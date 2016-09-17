package com.bcrusu.cspreporting.core.filters

import javax.inject.Provider

class ReportFilterProvider : Provider<IReportFilter> {
    override fun get(): IReportFilter {
        val orderedFilters = listOf(BlockedHostFilter())
        return CompositeFilter(orderedFilters)
    }
}
