package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import javax.validation.Valid
import javax.validation.constraints.NotNull

class AppConfiguration() : Configuration() {
    @JsonProperty @Valid @field:NotNull
    val elasticsearch: ElasticsearchConfiguration? = null
}
