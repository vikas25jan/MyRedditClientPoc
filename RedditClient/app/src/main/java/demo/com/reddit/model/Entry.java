package demo.com.reddit.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="entry" , strict = false)
public class Entry {

    @Element(name = "title")
    private String title;

    @Element(name = "updated")
    private String updated;

    @Element(name = "content")
    private String content;

    @Element(required = false, name = "author")
    private Author author;

    public Entry(){

    }

    public Entry(String title, String updated, String content, Author author) {
        this.title = title;
        this.updated = updated;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
