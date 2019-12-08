package demo.com.reddit.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="entry" , strict = false)
public class Author {

    @Element(name = "name")
    private String name;

    @Element(name = "uri")
    private String uri;

    public Author(){

    }

    public Author(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
