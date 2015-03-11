package bg.mine.logic.controller;

import bg.mine.backend.Parser;
import bg.mine.backend.model.Product;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Created by leif on 07/03/15.
 */
public class Crawler {
    public static final String inputURL = "http://www.amazon.de/s/ref=nb_sb_noss_1";
    private Map<String, String> parameters = new HashMap<String, String>();
    private String variableKeyword;

    public Crawler(String keyPhrase){
        parameters.put("__mk_de_DE", "%C3%85M%C3%85%C5%BD%C3%95%C3%91");
        parameters.put("url", "search-alias%3Daps");
        parameters.put("field-keywords", keyPhrase);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public static void main(String[] args){
        try{

            Crawler crwlr = new Crawler("John Newman");

            Parser p = new Parser(inputURL, crwlr.getParameters());
            p.parse();

            // instead of this, the results could be inserted in a DB;
            Iterator i = p.getProductLIst().iterator();
            while(i.hasNext()){
                Product pdct = (Product) i.next();
                System.out.println("Product name: " + pdct.getProductName());
                if(pdct.getProductDescription() != null){
                    System.out.println("Product description" + pdct.getProductDescription());
                }
                System.out.println("Product price: " + pdct.getPrice());
                System.out.println("##############################");
            }

        } catch (MalformedURLException mue){
          System.err.println("URL is malformed. Please, do something! " + mue.getStackTrace());
        } catch (IOException ioe){
            System.err.println("Error getting document from URL. Please, do something! " + ioe.getStackTrace());
        }
    }
}
