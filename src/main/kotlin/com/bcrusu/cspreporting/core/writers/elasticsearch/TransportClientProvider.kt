package com.bcrusu.cspreporting.core.writers.elasticsearch

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.slf4j.LoggerFactory
import java.net.InetAddress
import javax.inject.Inject
import javax.inject.Provider

class TransportClientProvider @Inject constructor(val config: ElasticsearchConfiguration) : Provider<TransportClient> {
    private val DEFAULT_ADDRESS = "localhost"
    private val DEFAULT_PORT = 9300

    private val _logger = LoggerFactory.getLogger(TransportClientProvider::class.java)

    override fun get(): TransportClient {
        val settingsBuilder = Settings.settingsBuilder()
                .put("client.transport.sniff", true)

        if (config.clusterName != null)
            settingsBuilder.put("cluster.name", config.clusterName)

        val settings = settingsBuilder.build()
        val address = config.address ?: DEFAULT_ADDRESS
        val port = config.port ?: DEFAULT_PORT

        val client = TransportClient.builder()
                .settings(settings)
                .build()
                .addTransportAddress(InetSocketTransportAddress(InetAddress.getByName(address), port))

        ensureIndexExists(client, config.index!!)

        return client
    }

    private fun ensureIndexExists(client: TransportClient, index: String) {
        val exists = client.admin().indices()
                .exists(IndicesExistsRequest(index))
                .get().isExists

        if (exists) {
            _logger.info("Index '$index' exists.")
            return
        }

        _logger.info("Creating index '$index'...")
        val isAcknowledged = client.admin().indices().create(CreateIndexRequest(index)).get().isAcknowledged

        if (!isAcknowledged){
            throw Exception("Failed to create index.")
        }
    }
}
