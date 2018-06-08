package fund.cyber.api.ethereum.handlers

import fund.cyber.api.common.SingleRepositoryItemRequestHandler
import fund.cyber.api.common.asServerResponse
import fund.cyber.cassandra.ethereum.repository.EthereumUncleRepository
import fund.cyber.common.toSearchHashFormat
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn

@Configuration
@DependsOn("ethereum-search-repositories")
class EthereumUncleHandlersConfiguration {

    @Bean
    fun ethereumUncleItemHandler() = SingleRepositoryItemRequestHandler(
        "/uncle/{hash}",
        EthereumUncleRepository::class.java
    ) { request, repository ->

        val hash = request.pathVariable("hash")
        val uncle = repository.findById(hash.toSearchHashFormat())
        uncle.asServerResponse()
    }

}
