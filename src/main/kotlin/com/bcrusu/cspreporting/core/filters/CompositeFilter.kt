package com.bcrusu.cspreporting.core.filters

import com.bcrusu.cspreporting.core.Report

class CompositeFilter(val filters: List<IReportFilter>) : IReportFilter {
    override fun filter(report: Report): Boolean {
        for (filter in filters) {
            val result = filter.filter(report)

            if (result)
                return true
        }

        return false
    }
}
