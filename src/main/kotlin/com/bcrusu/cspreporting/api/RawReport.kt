package com.bcrusu.cspreporting.api

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class RawReport(@JsonProperty("csp-report") @Valid @NotNull val body: RawReportBody)