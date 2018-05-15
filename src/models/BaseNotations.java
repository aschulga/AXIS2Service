package models;

import java.util.ArrayList;
import java.util.List;

public class BaseNotations {

    private List<Book> listBooks = new ArrayList<Book>();

    public List<Book> getList() {
        return listBooks;
    }

    public void setList(List<Book> list) {
        listBooks = list;
    }

}
