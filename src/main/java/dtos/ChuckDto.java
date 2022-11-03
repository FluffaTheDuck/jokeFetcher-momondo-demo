package dtos;

public class ChuckDto {
    private String value;
    private String url;

    public ChuckDto(String joke, String reference) {
        this.value = joke;
        this.url = reference;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}