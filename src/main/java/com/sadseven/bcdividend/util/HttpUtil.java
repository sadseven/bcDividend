package com.sadseven.bcdividend.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Base64.Encoder;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import net.sf.json.JSONObject;

public class HttpUtil {

	public static void doHttpPost(String URL, JSONObject jsonObj) {
		BufferedReader in = null;
		try {
			System.out.println("发起的数据:" + jsonObj.toString());
			HttpClient client = new DefaultHttpClient();    
			// 实例化HTTP方法    
			HttpPost request = new HttpPost(URL);    
			
			request.setHeader("Connection", "keep-alive");
			request.setHeader("Content-Type", "application/json; charset=utf-8");
			//设置参数  
			 StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
		        entity.setContentEncoding("UTF-8");
		        // 发送Json格式的数据请求
		        request.setEntity(entity);  
          
			HttpResponse response = client.execute(request);    
			int code = response.getStatusLine().getStatusCode();  
			if(code == 200){    //请求成功  
				in = new BufferedReader(new InputStreamReader(response.getEntity()    
						.getContent(),"utf-8"));  
				StringBuffer sb = new StringBuffer("");    
				String line = "";    
				String NL = System.getProperty("line.separator");    
				while ((line = in.readLine()) != null) {    
					sb.append(line + NL);    
				}  
				in.close();    
				System.out.println("返回的数据:" + sb.toString());
			} else {
				System.out.println("状态码：" + code);  
			}
        } catch (Exception e) {
        	 e.printStackTrace();  
        } finally {
        	try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

	public static JSONObject doHttpGet(String url) {
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			String string = sb.toString();
			JSONObject fromObject = JSONObject.fromObject(string);
			return fromObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("finally")
	public static InputStream doHttpPatch(String URL, String dataInfo) {

		System.out.println("发起的数据:" + dataInfo);
		byte[] xmlData = dataInfo.getBytes();
		InputStream instr = null;
		try {
			URL url = new URL(URL);
			URLConnection urlCon = url.openConnection();
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setUseCaches(false);

			Encoder encoder = Base64.getEncoder();
			String text = "admin:password";
			byte[] textByte = text.getBytes("UTF-8");
			String encodedText = encoder.encodeToString(textByte);
			urlCon.setRequestProperty("Authorization", "Basic " + encodedText);

			urlCon.setRequestProperty("content-Type", "application/json");
			urlCon.setRequestProperty("charset", "utf-8");
			urlCon.setRequestProperty("Content-length", String.valueOf(xmlData.length));
			urlCon.setRequestProperty("x-http-method-override", "PATCH");

			DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
			printout.write(xmlData);
			printout.flush();
			printout.close();
			instr = urlCon.getInputStream();
			System.out.println("返回的数据:" + instr);

		} catch (Exception e) {
			e.printStackTrace();
			return instr;
		} finally {
			return instr;
		}
	}
	
	 public static String sendPost(String url, String param) {  
	        PrintWriter out = null;  
	        BufferedReader in = null;  
	        String result = "";  
	        try {  
	            URL realUrl = new URL(url);  
	            // 打开和URL之间的连接  
	            URLConnection conn = realUrl.openConnection();  
	            // 设置通用的请求属性  
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setRequestProperty("connection", "Keep-Alive");  
	            // 发送POST请求必须设置如下两行  
	            conn.setDoOutput(true);  
	            conn.setDoInput(true);  
	            //1.获取URLConnection对象对应的输出流  
	            //out = new PrintWriter(conn.getOutputStream());  
	            //2.中文有乱码的需要将PrintWriter改为如下  
	            //out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")  
	            // 发送请求参数  
	            //out.print(param);  
	            // flush输出流的缓冲  
	            //out.flush();  
	            // 定义BufferedReader输入流来读取URL的响应  
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
	            String line;  
	            while ((line = in.readLine()) != null) {  
	                result += line;  
	            }  
	        } catch (Exception e) {  
	            System.out.println("发送 POST 请求出现异常！"+e);  
	            e.printStackTrace();  
	        }  
	        //使用finally块来关闭输出流、输入流  
	        finally{  
	            try{  
	                if(out!=null){  
	                    out.close();  
	                }  
	                if(in!=null){  
	                    in.close();  
	                }  
	            }  
	            catch(IOException ex){  
	                ex.printStackTrace();  
	            }  
	        }  
	        System.out.println("post推送结果："+result);  
	        return result;  
	    }  

}
