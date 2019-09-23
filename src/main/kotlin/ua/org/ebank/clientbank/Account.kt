package ua.org.ebank.clientbank

data class Account(
        var id: Long,
        val name: String,
        val iban: IBAN) {

    override fun toString(): String {
        return "$name ($iban)"
    }
}
