package models;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private Author author;
    private String title;
    private List<Theme> listThemes;

    public Book(){}

    public Book(Author author, String title, List<Theme> listThemes){
        this.author = author;
        this.title = title;
        this.listThemes = listThemes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Theme> getListThemes() {
        return listThemes;
    }

    public void setListThemes(List<Theme> listThemes) {
        this.listThemes = listThemes;
    }
}
