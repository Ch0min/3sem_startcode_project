package dtos;

public class CombinedJokesDTO {
    private String cnJoke;
    private String cnJokeReference;
    private String dadJoke;
    private String dadJokeReference;
    private String dadStatus;

    public CombinedJokesDTO() {
    }

    public CombinedJokesDTO(ChuckNorrisJokeDTO chuckNorrisJokeDTO, DadJokeDTO dadDTO) {
        this.cnJoke = chuckNorrisJokeDTO.getValue();
        this.cnJokeReference = chuckNorrisJokeDTO.getUrl();
        this.dadJoke = dadDTO.getJoke();
        this.dadJokeReference = dadDTO.getUrl();
        this.dadStatus = dadDTO.getStatus();
    }
}
