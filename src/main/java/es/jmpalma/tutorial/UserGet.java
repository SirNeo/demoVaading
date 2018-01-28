package es.jmpalma.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.web.client.RestTemplate;

public class UserGet {

	public List<User> getUsers() {
		
		return null;
	}
	
	public boolean llamarServicioRest() {
		
		try {
			URL url = new URL("http://localhost:8070/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output;
			System.out.println("Output from Server ... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean llamarServicioRestMapeoNoFuncion(String userId) {
		//Client cliente = ClientBuilder.newClient();
		//		User user = cliente.target("http://localhost:8070/user/" + userId)
		//				.request(MediaType.APPLICATION_JSON_TYPE)
		//				.get(User.class);
		//if (user != null) {
		//System.out.println("ID: " + user.getId());
		///System.out.println("NAME: " + user.getFirstName());
		//}		
		return true;
	}
	
	
	public boolean llamarServicioRestMapeo(String userId) {
		System.out.println("llamarServicioRestMapeo()" + userId);
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8070/user/" + userId);
		Response response = target.request().get();
		//User user = response.readEntity(User.class);
		String valor = response.readEntity(String.class);
		System.out.println(valor);
		response.close();
		
		return true;
	}
	
	public boolean llamarServicioRestMapeoJackson(String userId) {
		RestTemplate rt = new RestTemplate();
		
		User user = rt.getForObject("http://localhost:8070/user/"+userId, User.class);
		
		if (user != null) {
			System.out.println("ID: " + user.getId());
			System.out.println("NAME: " + user.getFirstName());
		}		
			
		return true;
	}
}
