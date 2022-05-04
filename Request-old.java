import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.OutputStreamWriter;

public class Request {
	private String responseData;
	private Map<String, List<String>> responseHeaders;
	
	public void GET(String URLstring, HashMap<String, String> headers) {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			
			for(Map.Entry<String, String> set: headers.entrySet()) {
				httpConn.setRequestProperty(set.getKey(), set.getValue());
			}
			
			responseHeaders = httpConn.getHeaderFields();
			
			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
			? httpConn.getInputStream()
			: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void GET(String URLstring) {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			
	 		responseHeaders = httpConn.getHeaderFields();
			
			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void POST(String URLstring, HashMap<String, String> headers, String body){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");
			
			for(Map.Entry<String, String> set: headers.entrySet()) {
				httpConn.setRequestProperty(set.getKey(), set.getValue());
			}
			
			httpConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
			writer.write(body);
			writer.flush();
			writer.close();
			httpConn.getOutputStream().close();
			
			responseHeaders = httpConn.getHeaderFields();
			
			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void POST(String URLstring, String body){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");

			httpConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
			writer.write(body);
			writer.flush();
			writer.close();
			httpConn.getOutputStream().close();

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void POST(String URLstring){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PUT(String URLstring, HashMap<String, String> headers, String body){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("PUT");

			for(Map.Entry<String, String> set: headers.entrySet()) {
				httpConn.setRequestProperty(set.getKey(), set.getValue());
			}

			httpConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
			writer.write(body);
			writer.flush();
			writer.close();
			httpConn.getOutputStream().close();

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PUT(String URLstring, String body){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("PUT");

			httpConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
			writer.write(body);
			writer.flush();
			writer.close();
			httpConn.getOutputStream().close();

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void PUT(String URLstring){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("PUT");

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DELETE(String URLstring, HashMap<String, String> headers) {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("DELETE");

			for(Map.Entry<String, String> set: headers.entrySet()) {
				httpConn.setRequestProperty(set.getKey(), set.getValue());
			}

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DELETE(String URLstring) {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("DELETE");

			responseHeaders = httpConn.getHeaderFields();

			InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
			Scanner s = new Scanner(responseStream).useDelimiter("\\A");
			responseData = s.hasNext() ? s.next() : "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getResponseData() {
		return responseData;
	}
	
	public Map getResponseHeaders() {
		return responseHeaders;
	}
} 
