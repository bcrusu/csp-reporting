package com.bcrusu.cspreporting.config

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ElasticsearchConfiguration() {
    @JsonProperty @field:NotEmpty
    var address: String? = null

    @JsonProperty @field:NotNull
    var port: Int? = null
}
