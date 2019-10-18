package com.stephenott.stix.objects.core.sco.objects

import com.stephenott.stix.common.*
import com.stephenott.stix.objects.core.sco.StixCyberObservableObject
import com.stephenott.stix.objects.core.sco.extension.ScoExtension
import com.stephenott.stix.objects.core.sro.objects.AllowedRelationship
import com.stephenott.stix.type.*
import com.stephenott.stix.type.StixSpecVersion.Companion.StixVersions
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1

interface EmailAddressSco : StixCyberObservableObject {

    val value: String //@TODO add validation
    val displayName: String? //@TODO add validation
    val belongsToRef: StixIdentifier?

    companion object:
        CompanionStixType,
        BusinessRulesValidator<EmailAddressSco>,
        CompanionIdContributingProperties<EmailAddressSco>,
        CompanionAllowedRelationships,
        CompanionAllowedExtensions {

        override val allowedExtensions: List<KClass<out ScoExtension>> = listOf()

        override val stixType = StixType("email-addr")

        override val idContributingProperties: List<KProperty1<EmailAddressSco, Any?>> = listOf(
            EmailAddressSco::value
        )

        override val allowedRelationships: List<AllowedRelationship> = listOf(

        )

        override fun objectValidationRules(obj: EmailAddressSco) {
            require(obj.belongsToRef?.type == UserAccountSco.stixType, lazyMessage = {"belongs_to_ref must reference a user-account SCO."})
        }

    }
}

data class EmailAddress(
    override val value: String,
    override val displayName: String? = null,
    override val belongsToRef: StixIdentifier? = null,
    override val type: StixType = StixType(EmailAddressSco.stixType),
    override val id: StixIdentifier = StixIdentifier(type),
    override val objectMarkingsRefs: String? = null,
    override val granularMarkings: String? = null,
    override val specVersion: StixSpecVersion = StixSpecVersion(StixVersions.TWO_DOT_ONE, false),
    override val extensions: Extensions? = null,
    override val defanged: StixBoolean = StixBoolean()
) : EmailAddressSco {

    init {
        EmailAddressSco.objectValidationRules(this)
    }

    override fun allowedRelationships(): List<AllowedRelationship> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}