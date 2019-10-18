package com.stephenott.stix.type.vocab

class LanguageCodes(private val codes: LinkedHashSet<LanguageCode> = linkedSetOf()) :
    Set<LanguageCode> by codes {

    init {
        //@TODO
    }
}

data class LanguageCode(private val code: String) : ClosedVocab, CharSequence by code {

    init {
        require(LanguageCode.vocab.contains(code))
    }

    companion object {
        val vocabName = "iso-639-2-language-codes"

        val vocab: LinkedHashSet<String> = linkedSetOf(
            "en" //@TODO add rest of language codes
        )
    }
}