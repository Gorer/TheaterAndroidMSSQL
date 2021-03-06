package com.example.mymssqlserverdatabaseconnection.Requests;

import com.example.mymssqlserverdatabaseconnection.ConnectionHelper;
import com.example.mymssqlserverdatabaseconnection.Models.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Requests {
    //private ConnectionHelper connectionHelper;
    //Connection connection;
    //String connectionResult = "";

    public static String SEARCH(String tableName, String text) {
        switch (tableName) {
            case "theater_production":
                return "select * from theater_production where concat(id_theater_production, " +
                        "id_genre, id_age_category, name, theater_name, description," +
                        "rating, duration, start_time, director) like " + "\'%" + text + "%\';";
            case "genres":
                return "select * from genres where concat(id_genre, name_genre) like " + "\'%" + text + "%\';";
            case "age_categories":
                return "select * from age_categories where concat(id_age_category, " +
                        "name_age_category) like \" + \"\\'%\" + text + \"%\\';";
            case "feedbacks":
                return "select * from feedbacks where concat(id_feedback, id_theater_production, " +
                        "feedback, rating_feedback) like \" + \"\\'%\" + text + \"%\\';";
            case "comments":
                return "select * from comments where concat(id_comment, id_feedback, " +
                        "comment) like \" + \"\\'%\" + text + \"%\\';";
            case "adress_theater_production":
                return "select * from adress_theater_production where concat(id_adress_theater_production, " +
                        "id_theater_production, theater_name, hall, adress) like \" + \"\\'%\" + text + \"%\\';";
            case "tickets":
                return "select * from tickets where concat(id_ticket, id_theater_production, " +
                        "id_adress_theater_production, place, price) like \" + \"\\'%\" + text + \"%\\';";
            default:
                return null;
        }
    }

    public static String UPDATE(String tableName, String field, String value, int id) {
        switch (tableName) {
            case "theater_production":
                // UPDATE goods SET price = 150 WHERE num = 2
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_theater_production = " + id + ";";
            case "genres":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_genre = " + id+ ";";
            case "age_categories":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_age_category = " + id+ ";";
            case "feedbacks":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_feedback = " + id+ ";";
            case "comments":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_comment = " + id+ ";";
            case "adress_theater_production":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_adress_theater_production = " + id+ ";";
            case "tickets":
                return "UPDATE " + tableName + " SET " + field + " = " + "'" +
                        value + "'" + " WHERE id_ticket = " + id+ ";";
            default:
                return null;
        }
    }

    public static String UPDATE(String tableName, String field, int value, int id) {
        switch (tableName) {
            case "theater_production":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_theater_production = " + id + ";";
            case "genres":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_genre = " + id + ";";
            case "age_categories":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_age_category = " + id + ";";
            case "feedbacks":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_feedback = " + id + ";";
            case "comments":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_comment = " + id + ";";
            case "adress_theater_production":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_adress_theater_production = " + id + ";";
            case "tickets":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_ticket = " + id + ";";
            default:
                return null;
        }
    }

    public static String UPDATE(String tableName, String field, float value, int id) {
        switch (tableName) {
            case "theater_production":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_theater_production = " + id + ";";
            case "genres":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_genre = " + id + ";";
            case "age_categories":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_age_category = " + id + ";";
            case "feedbacks":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_feedback = " + id + ";";
            case "comments":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_comment = " + id + ";";
            case "adress_theater_production":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_adress_theater_production = " + id + ";";
            case "tickets":
                return "UPDATE " + tableName + " SET " + field + " = " +
                        value + " WHERE id_ticket = " + id + ";";
            default:
                return null;
        }
    }
}



















