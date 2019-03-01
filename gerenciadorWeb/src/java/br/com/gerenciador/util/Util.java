/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author danieldruszcz
 */
public class Util {

    private static final String HOST = "http://localhost:8080/gerenciadorWs/";

    public static String hash(String algoritmo, String text) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance(algoritmo);    // Gera o hash da String
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            StringBuilder stringBuffer = new StringBuilder();               // Converte o hash para uma string hexadecimal
            for (int i = 0; i < hash.length; i++) {
                stringBuffer.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuffer.toString();                                 // Retorna a string hexadecimal
        } catch (UnsupportedEncodingException ex) {
            throw new NoSuchAlgorithmException("Nao foi possivel gerar o hash da String. Algoritmo inválido!", ex);
        }
    }

    public static String sendPost(String action, String json) throws IOException {

        try {
            // Cria um objeto HttpURLConnection:
            HttpURLConnection request = (HttpURLConnection) new URL(HOST + action).openConnection();

            try {
                // Define que a conexão pode enviar informações e obtê-las de volta:
                request.setDoOutput(true);
                request.setDoInput(true);

                // Define o content-type:
                request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                request.setRequestMethod("POST");

                // Conecta na URL:
                request.connect();

                // Escreve o objeto JSON usando o OutputStream da requisição:
                try (OutputStream outputStream = request.getOutputStream()) {
                    outputStream.write(json.getBytes("UTF-8"));
                }

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
                //int response = request.getResponseCode();
                return readResponse(request);
            } finally {
                request.disconnect();
            }
        } catch (IOException ex) {
            throw ex;
        }
    }

    public static String sendGet(String action) throws IOException {

        try {
            // Cria um objeto HttpURLConnection:
            HttpURLConnection request = (HttpURLConnection) new URL(HOST + action).openConnection();

            try {
                // Define que a conexão pode enviar informações e obtê-las de volta:
                request.setDoOutput(true);
                request.setDoInput(true);

                // Define o content-type:
                request.setRequestProperty("Content-Type", "application/json");

                // Define o método da requisição:
                request.setRequestMethod("GET");

                // Conecta na URL:
                request.connect();

                // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
                //int response = request.getResponseCode();
                return readResponse(request);
            } finally {
                request.disconnect();
            }
        } catch (IOException ex) {
            throw ex;
        }
    }

    private static String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        try (InputStream is = request.getInputStream()) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }

    public static Object jsonToObject(String jsonText, Class classe) throws IOException {

        Gson json = new Gson();
        return json.fromJson(jsonText, classe);

    }

    public static Object readJsonFromUrl(String action, Class classe) throws IOException {
        InputStream is = new URL(HOST + action).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            Gson json = new Gson();
            return json.fromJson(jsonText, classe);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static Long getIdFromRequest(ExternalContext ec) {
        Long id = null;
        if (ec != null && ec.getRequestParameterMap() != null && ec.getRequestParameterMap().get("id") != null) {
            id = Long.parseLong(ec.getRequestParameterMap().get("id"));
            //ec.getRequestParameterMap().clear();
        }
        return id;
    }

    public static <T> List<T> jsonToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }
}
