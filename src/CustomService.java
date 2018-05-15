import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomService {

    private final static String FILE_NAME = "D:\\aipos\\Laba 2-3\\fileWithData\\data.json";
    private BaseNotations base = new BaseNotations();

    public List<Book> getAllBooks(){
        base.getList().clear();

        Gson gson = new Gson();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            BaseNotations baseNotations = gson.fromJson(reader, BaseNotations.class);

            if(baseNotations != null){
                int i = 0;
                for(Book book: baseNotations.getList()){
                    book.setId(++i);
                    base.getList().add(book);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return base.getList();
    }

    public void addBook(Book book){
        book.setListThemes(new ArrayList<>());
        base.getList().add(book);
        saveChanging();
    }

    public void deleteBook(int index){
        base.getList().remove(index);
        saveChanging();
    }

    public void changeBook(int index, Book book){
        List<Theme> listThemes = base.getList().get(index).getListThemes();
        base.getList().remove(index);
        book.setListThemes(listThemes);
        base.getList().add(index, book);
        saveChanging();
    }

    public List<Theme> getAllThemes(int index){
        for(int i = 0; i < base.getList().get(index).getListThemes().size(); i++){
            base.getList().get(index).getListThemes().get(i).setId(i+1);
        }
        return base.getList().get(index).getListThemes();
    }

    public void addTheme(int indexInListBooks, Theme theme){
        base.getList().get(indexInListBooks).getListThemes().add(theme);
        saveChanging();
    }

    public void deleteTheme(int indexInListBooks, int index){
        base.getList().get(indexInListBooks).getListThemes().remove(index);
        saveChanging();
    }

    public void changeTheme(int indexInListBooks, int index, Theme theme){
        base.getList().get(indexInListBooks).getListThemes().remove(index);
        base.getList().get(indexInListBooks).getListThemes().add(index, theme);
        saveChanging();
    }

    public void saveChanging(){

        BaseNotations baseNotations = new BaseNotations();
        baseNotations.setList(base.getList());

        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        String json = gs.toJson(baseNotations);

        FileWriter writer = null;

        try {
            writer = new FileWriter(FILE_NAME);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
