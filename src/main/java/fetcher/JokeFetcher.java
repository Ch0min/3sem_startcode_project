package fetcher;

import utils.HttpUtils;

import java.io.IOException;


public class JokeFetcher {
    public static void main(String[] args) throws IOException {


        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");

        System.out.println("JSON fetched from Chuck Norris Jokes:");
        System.out.println(chuck);
        System.out.println("JSON fetched from Dad Jokes:");
        System.out.println(dad);


    }
}
