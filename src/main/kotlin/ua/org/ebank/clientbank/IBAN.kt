package ua.org.ebank.clientbank

data class IBAN(
        val countryCode: String,
        val checkSun: String,
        val bankCode: String,
        val accountNumber: String) {

    override fun toString(): String {
        return "$countryCode$checkSun$bankCode$accountNumber"
    }
}
