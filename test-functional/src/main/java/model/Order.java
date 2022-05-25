package model;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.dslplatform.json.processor.MinifiedNaming;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.longdt.dsljson.SnakeCaseNaming;

@CompiledJson(namingStrategy = SnakeCaseNaming.class)
public class Order {
    private Long id;
    @JsonAttribute(name = "sc")
    private String serviceCode;
    private String serviceName;
    @JsonProperty("desc")
    private String description;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public Order setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Order setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", serviceCode='" + serviceCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
