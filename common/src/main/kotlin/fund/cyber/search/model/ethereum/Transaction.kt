package fund.cyber.search.model.ethereum

import java.math.BigDecimal
import java.time.Instant


data class EthereumTransaction(
        val hash: String,
        val nonce: Long,           //parsed from hex
        val block_hash: String?,   //null when its pending
        val block_number: Long,   //parsed from hex   //null when its pending
        val block_time: Instant,
        val transaction_index: Long,//parsed from hex
        val from: String,
        val to: String?,           //null when its a contract creation transaction.
        val value: String,         //decimal   //parsed from hex
        val gas_price: BigDecimal, //parsed from hex
        val gas_limit: Long,       //parsed from hex
        val gas_used: Long,        //parsed from hex
        val fee: String,           //decimal //calculated
        val input: String,
        val creates: String?       //creates contract hash
) {
    fun addressesUsedInTransaction() = listOfNotNull(from, to, creates)
}