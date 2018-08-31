package teste;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Main {
	
	// Interface de acesso aos end points
	interface Myinterface {
		@SuppressWarnings("rawtypes")
		@GET("api/v2/pokemon/1/")
		Call<ResponseBody> Myinterface();
	}

	public static void main(String[] args) {
		
		// Instanciando retrofit
		final String BASE_URL = "https://pokeapi.co/";
		@SuppressWarnings("unused")
		Retrofit retrofit = new Retrofit.Builder()
		    .baseUrl(BASE_URL)
		    .addConverterFactory(GsonConverterFactory.create())
		    .build();
		
		// Chamando interface de acesso
		Myinterface myinterface = retrofit.create(Myinterface.class);
		
		try {
			@SuppressWarnings({ "rawtypes", "unused" })
			Response<ResponseBody> response = myinterface.Myinterface().execute();
			System.out.println("Request done");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
