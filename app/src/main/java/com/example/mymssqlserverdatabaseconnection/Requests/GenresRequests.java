package com.example.mymssqlserverdatabaseconnection.Requests;

public class GenresRequests extends Requests {
    // Поле запроса для поиска по таблице по всем полям всех типов
    public static final String SEARCH =
            "select * from genres where concat(id_genre, name_genre) like "; // дописать это - '%search_string%;'

    //public static final ResultSet Search(String searchText) {
        //ResultSet resultSet = statement.executeQuery();

    //}
}
