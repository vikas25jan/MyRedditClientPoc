package demo.com.reddit.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name="feed" , strict = false)
public class Feed implements Serializable {


    private String category;

    @Element(name = "title")
    private String title;

    @ElementList(inline = true, name = "entity")
    private List<Entry> entries;

    public Feed(){

    }

    public Feed(String category, String title, List<Entry> entries) {
        this.category = category;
        this.title = title;
        this.entries = entries;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }



}
