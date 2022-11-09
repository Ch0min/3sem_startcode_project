package dtos;

public class DadJokeDTO {
    private String id;
    private String url = "https://icanhazdadjoke.com/";
    private String joke;
    private String status;

    public DadJokeDTO() {
    }

    public DadJokeDTO(String id, String url, String joke, String status) {
        this.id = id;
        this.url = url;
        this.joke = joke;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
