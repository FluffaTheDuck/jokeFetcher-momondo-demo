package jokefetcher;

import com.google.gson.Gson;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import dtos.ChuckDto;
import dtos.CombinedDto;
import dtos.DadDto;
import utils.HttpUtils;


public class JokeFetcher {

    public String fetchJokes() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random%22");
                ChuckDto chuckDTO = gson.fromJson(chuck, ChuckDto.class);

        String dadUrl = "https://icanhazdadjoke.com/";
        String dad = HttpUtils.fetchData(dadUrl);
        DadDto dadDTO = gson.fromJson(dad, DadDto.class);
        dadDTO.setReference(dadUrl);

        CombinedDto combinedDto = new CombinedDto(chuckDTO.getValue(), chuckDTO.getUrl(), dadDTO.getJoke(), dadDTO.getReference());
        return gson.toJson(combinedDto);
    }

    public static void main(String[] args) throws IOException {


        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");

        System.out.println("JSON fetched from chucknorris:");
        System.out.println(chuck);
        System.out.println("JSON fetched from dadjokes:");
        System.out.println(dad);


    }
}
