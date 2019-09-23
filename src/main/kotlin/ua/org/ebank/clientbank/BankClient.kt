package ua.org.ebank.clientbank

open class BankClient(private val accountsStorage: AccountsStorage, private val userStorage: AuthorizationStorage) {

    fun login(username: String, password: String) = userStorage.login(username, password)
    fun currentUser() = userStorage.currentUser()
    fun logout() = userStorage.logout()

    fun account(id: Long): Account = accountsStorage.get(id)
    fun accounts() = accountsStorage.list()
    fun create(name: String, iban: IBAN) = accountsStorage.create(name, iban)
}
