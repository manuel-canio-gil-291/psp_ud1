package es.mcg;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Transparencia18 {
    public static void main(String[] args) throws IOException {
        Transparencia18 transparencia18 = new Transparencia18();
        try {
            System.out.println(transparencia18.returnContentString(new URL("https://iesjandula.es/drupal")));
            transparencia18.returnContentFile(new URL("https://www.iesjandula.es/drupal"));
            transparencia18.descargaDatos(new URL("https://www.iesjandula.es/drupal"));
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        
    }

    public String returnContentString(URL url) throws IOException
    {
        String inputText = "";
        String inputLine = "";
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader in = new BufferedReader(inputStreamReader);
        try
        {
            inputLine = in.readLine();
            while(inputLine != null)
            {
                inputText = inputText + inputLine + "\n";
                inputLine = in.readLine();
            }
            return inputText;
        }
        catch(IOException ioException) 
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                if(in != null)
                {
                    in.close();
                }
                if(inputStreamReader != null) {
                    inputStreamReader.close();
                }
            }
            catch(IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return inputText;
    }

    public void returnContentFile(URL url) throws IOException
    {
        File file = new File("index.html");
        PrintWriter printWriter = null;
        String inputText = "";
        String inputLine = "";
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader in = new BufferedReader(inputStreamReader);
        try
        {
            printWriter = new PrintWriter(file);
            inputLine = in.readLine();
            while(inputLine != null)
            {
                printWriter.println(inputLine);
                inputLine = in.readLine();
            }
        }
        catch(IOException ioException) 
        {
            ioException.printStackTrace();
        }
        finally
        {
            try
            {
                if(in != null)
                {
                    in.close();
                }
                if(inputStreamReader != null) 
                {
                    inputStreamReader.close();
                }
                if(printWriter != null)
                {
                    printWriter.close();
                }
            }
            catch(IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void descargaDatos(URL url) 
    {
        try
        {
            URLConnection urlCon = url.openConnection();
            InputStream stream = urlCon.getInputStream();
            int i;
            while((i=stream.read()) != -1)
            {
                System.out.print((char)i);
            }
        }
        catch(Exception e) {System.err.println(e.getMessage());}
        
        
    }
}
