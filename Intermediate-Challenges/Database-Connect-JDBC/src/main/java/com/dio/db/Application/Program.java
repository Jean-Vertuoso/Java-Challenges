package com.dio.db.Application;

import java.sql.Connection;

import com.dio.db.DB;

public class Program {
    
    public static void main(String[] args){
        
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
