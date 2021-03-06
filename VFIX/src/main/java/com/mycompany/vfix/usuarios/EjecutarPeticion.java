/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vfix.usuarios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author carlo
 */
public class EjecutarPeticion {

    private final String urlBase = "http://localhost:8000/api/recursoshumanos/";
            
    public EjecutarPeticion() {
    }
    
    public void Insertar(HttpEntity httpEntity){
        
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlBase);
            httpPost.setEntity(httpEntity);
            HttpResponse httpResponse;
            
            httpResponse = httpClient.execute(httpPost);
            System.out.println("Codigo: "+httpResponse.getStatusLine().getStatusCode());
        } catch (IOException ex) {
            Logger.getLogger(EjecutarPeticion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(HttpEntity httpEntity){
        
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut httpPut = new HttpPut(urlBase);
            httpPut.setEntity(httpEntity);
            HttpResponse httpResponse;
            
            httpResponse = httpClient.execute(httpPut);
             System.out.println("Codigo: "+httpResponse.getStatusLine().getStatusCode());
        } catch (IOException ex) {
            Logger.getLogger(EjecutarPeticion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<DatosEmpleado> ObtenerDatos(){
        try {
            Gson gson = new Gson();
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(urlBase);
            CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(httpGet);
            JsonReader reader = Json.createReader(new InputStreamReader((response.getEntity().getContent())));
            JsonArray array = reader.readArray();
            
            
            Type tipoDatosEmpleado = new TypeToken<List<DatosEmpleado>>(){}.getType();
            List<DatosEmpleado> datosEmpleados = gson.fromJson(array.toString(), tipoDatosEmpleado);
            response.close();
            return datosEmpleados;
            
        } catch (IOException ex) {
            return null;
        }
        
    }
    
}
