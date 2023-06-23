package gov.iti.jets.clinify.utils;

public class GeneralSearchRequest {
    private String sortDirection;
    private String sortBy;

    public GeneralSearchRequest(String sortDirection, String sortBy) {
        this.sortDirection = sortDirection;
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
