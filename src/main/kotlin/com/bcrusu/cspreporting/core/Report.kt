package com.bcrusu.cspreporting.core

import com.fasterxml.jackson.annotation.JsonProperty

data class Report(@JsonProperty("csp-report") val body: ReportBody)