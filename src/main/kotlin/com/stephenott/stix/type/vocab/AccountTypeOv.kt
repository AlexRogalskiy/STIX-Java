package com.stephenott.stix.type.vocab

class AccountType(private val type: String) : OpenVocab, CharSequence by type {

    companion object {

        val vocabName = "account-type-ov"

        var vocab: LinkedHashSet<String> = linkedSetOf(
            "facebook", "ldap", "nis",
            "openid", "radius", "skype",
            "tacacs", "twitter", "unix",
            "windows-local", "windows-domain"
        )
            set(value) {
                require(value.isNotEmpty())
                field = value
            }
    }

    init {
        require(this.type in vocab)
    }
}