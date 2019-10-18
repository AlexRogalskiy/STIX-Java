package com.stephenott.stix.type.vocab

class WindowsServiceTypeEnum(private val type: String) : ClosedVocab, CharSequence by type {

    companion object {
        val vocabName = "windows-service-type-enum"

        val vocab: LinkedHashSet<String> = linkedSetOf(
            "SERVICE_KERNEL_DRIVER", "SERVICE_FILE_SYSTEM_DRIVER", "SERVICE_WIN32_OWN_PROCESS",
            "SERVICE_WIN32_SHARE_PROCESS"

        )
    }

    init {
        require(this.type in vocab)
    }
}