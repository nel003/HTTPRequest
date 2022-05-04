
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
	
	private String URLstring;
	private Map<String, String> headers;
	private String body;
	
	public Request(String URLstring) {
		this.URLstring = URLstring;
	}
	
	public Request(String URLstring, Map<String, String> headers) {
		this.URLstring = URLstring;
		this.headers = headers;
	}
	
	public Request(String URLstring, String body) {
		this.URLstring = URLstring;
		this.body = body;
	}
	
	public Request(String URLstring, Map<String, String> headers, String body) {
		this.URLstring = URLstring;
		this.headers = headers;
		this.body = body;
	}
	
	public void GET() {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			
			if(headers != null) {
				for(Map.Entry<String, String> set: headers.entrySet()) {
					httpConn.setRequestProperty(set.getKey(), set.getValue());
				}
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

	public void POST(){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");

			if(headers != null) {
				for(Map.Entry<String, String> set: headers.entrySet()) {
					httpConn.setRequestProperty(set.getKey(), set.getValue());
				}
			}
			
			if(body != null) {
				httpConn.setDoOutput(true);
				OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
				writer.write(body);
				writer.flush();
				writer.close();
				httpConn.getOutputStream().close();
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

	public void PUT(){
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("PUT");

			if(headers != null) {
				for(Map.Entry<String, String> set: headers.entrySet()) {
					httpConn.setRequestProperty(set.getKey(), set.getValue());
				}
			}
             
			if(body != null) {
				httpConn.setDoOutput(true);
				OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
				writer.write(body);
				writer.flush();
				writer.close();
				httpConn.getOutputStream().close();
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

	public void DELETE() {
		try {
			URL url = new URL(URLstring);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("DELETE");

			if(headers != null) {
				for(Map.Entry<String, String> set: headers.entrySet()) {
					httpConn.setRequestProperty(set.getKey(), set.getValue());
				}
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

	public String getResponseData() {
		return responseData;
	}

	public Map getResponseHeaders() {
		return responseHeaders;
	}
} 

