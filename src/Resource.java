public class Resource {
    private String resourceName;
    private String resourceType;

    // Constructor
    public Resource(String resourceName, String resourceType) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
    }

    // Getters
    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    @Override
    public String toString() {
        return "Resource: " + resourceName + ", Type: " + resourceType;
    }
}
