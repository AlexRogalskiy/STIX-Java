package io.digitalstate.stix.domainobjects.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.digitalstate.stix.bundle.BundleObject;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashSet;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonPropertyOrder({"type", "id", "created_by_ref", "created",
        "modified", "revoked", "labels", "external_references",
        "object_marking_refs", "granular_markings", "name", "description",
        "identity_class", "sectors", "contact_information"})
public abstract class IdentityProperties extends CommonProperties{
    protected String name;

    @JsonInclude(NON_NULL)
    protected String description = null;

    @JsonProperty("identity_class")
    protected String identityClass;

    @JsonInclude(NON_NULL)
    protected LinkedHashSet<String> sectors = null;

    @JsonInclude(NON_NULL)
    @JsonProperty("contact_information")
    protected String contactInformation = null;


    //
    // Getters and Setters
    //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNotBlank(name)){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name can't be null or blank");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentityClass() {
        return identityClass;
    }

    public void setIdentityClass(String identityClass) {
        this.identityClass = identityClass;
    }

    public LinkedHashSet<String> getSectors() {
        return sectors;
    }

    public void setSectors(LinkedHashSet<String> sectors) {
        this.sectors = sectors;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }


    //
    // Helpers
    //

    @JsonIgnore
    public LinkedHashSet<BundleObject> getAllObjectSpecificBundleObjects(){
        LinkedHashSet<BundleObject> bundleObjects = new LinkedHashSet<>();
        return bundleObjects;
    }
}
