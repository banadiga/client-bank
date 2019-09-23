package ua.org.ebank.clientbank

class MyBankClient : BankClient(LocalAccountsStorage(), LocalAuthorizationStorage())
