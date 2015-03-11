package bg.mine.backend.model;

import java.net.URL;

/**
 * Created by leif on 07/03/15.
 */
public abstract class Product {

    // in case I want to call the url, it is perhaps convenient to keep the links as URLs
    private URL url;
    // this member should keep the title of the result
    private String productName;
    // the image of the product as byte stream
    private byte[] img;

    // description as it appears on the page
    private String productDescription;
    private String price;


    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public byte[] getImg() {
        return img;
    }

    public String getImgAscii(){
        // TODO: nice touch would be to convert it to ASCII image
        return img.toString();
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
