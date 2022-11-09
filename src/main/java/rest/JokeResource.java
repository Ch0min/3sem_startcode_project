package rest;

import com.google.gson.Gson;
import dtos.ChuckNorrisJokeDTO;
import dtos.CombinedJokesDTO;
import dtos.DadJokeDTO;
import utils.HttpUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        Gson gson = new Gson();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckNorrisJokeDTO chuckNorrisJokeDTO = gson.fromJson(chuck, ChuckNorrisJokeDTO.class);

        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadJokeDTO dadJokeDTO = gson.fromJson(dad, DadJokeDTO.class);

        CombinedJokesDTO combinedDTO = new CombinedJokesDTO(chuckNorrisJokeDTO, dadJokeDTO);

//This is what your endpoint should return
        return gson.toJson(combinedDTO);

    }
}