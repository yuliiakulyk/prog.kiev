package main.com.yuliiakulyk.app.i.network.task;

/**
 * Created by Yuliia Kulyk on 15.02.2018.
 */
public class Link {
    private String url;
    private int responseCode;
    private String responseMessage;

    public Link(String url, int responseCode, String responseMessage) {
        this.url = url;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public Link() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return url != null ? url.equals(link.url) : link.url == null;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }
}
