package ua.org.ebank.clientbank

interface AuthorizationStorage {
    fun login(username: String, password: String)
    fun currentUser(): String
    fun logout()
}

class YouAreLoggedIn : RuntimeException("You are already logged in")
class YouAreNotLoggedIn : RuntimeException("You are not logged in")

class LocalAuthorizationStorage : AuthorizationStorage {
    private var currentUsername = ""

    override fun login(username: String, password: String) {
        if (currentUsername.isNotBlank()) {
            throw YouAreLoggedIn()
        }
        currentUsername = username
    }

    override fun currentUser() = currentUsername

    override fun logout() {
        if (currentUsername.isBlank()) {
            throw YouAreNotLoggedIn()
        }
        currentUsername = ""
    }
}

interface AccountsStorage {
    fun get(id: Long): Account
    fun list(): List<Account>
    fun create(name: String, iban: IBAN)
}

class LocalAccountsStorage : AccountsStorage {
    private var id = 100L
    private val accounts = mutableListOf(
            Account(id++, "Account1", IBAN("UA", "11", "123456", "1234567890123456789")),
            Account(id++, "Account2", IBAN("UA", "22", "654321", "9876543210987654321"))
    )

    override fun list() = accounts

    override fun get(id: Long) = accounts.first { iban -> iban.id == id }

    override fun create(name: String, iban: IBAN) {
        accounts.add(Account(id++, name, iban))
    }
}
