package com.bcrusu.cspreporting.config

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ElasticsearchConfiguration() {
    @JsonProperty @field:NotEmpty
    val address: String? = null

    @JsonProperty @field:NotNull
    val port: Int? = null

    @JsonProperty
    val clusterName: String? = null

    @JsonProperty @field:NotEmpty
    val index: String? = null
}
