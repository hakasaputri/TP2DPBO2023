/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5_2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java. sql.Blob;
import java.util.ArrayList;
import java.util.List;
//import javax.imageio.ImageIO;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.table.DefaultTableModel;
/**
 *
 * @DirektorlistDirektor Hp
 */
public class dbConnection {
    public static Connection con;
    public static Statement stm;
    private ArrayList<Film> listFilm;
    private ArrayList<Direktor> listDirektor;
    private ArrayList<User> listUser;
    
    public void connect(){//untuk membuka koneksi ke database
        try {
            String url ="jdbc:mysql://localhost/db_tp5";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    

    
    public ArrayList<Film> getItemListFilm(){
        
        listFilm = new ArrayList<>();
        
        try{
            connect();
            ResultSet rs = stm.executeQuery("SELECT * FROM film");
            
            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("id_film"), rs.getString("nama"), 
                        rs.getString("genre"), rs.getBytes("image"));
                
                listFilm.add(film);
                
            }
            
        }catch (Exception e){
            System.err.println("Read gagal " +e.getMessage());

        }
        
        return listFilm;
    }
    
       
    public ArrayList<Direktor> getItemListDirektor(){
        
        listDirektor = new ArrayList<>();
        try{
            connect();
            ResultSet rs = stm.executeQuery("SELECT * FROM direktor");
            
            Direktor direktor;
            while(rs.next()){
                direktor = new Direktor(rs.getInt("id_direktor"), rs.getString("nama"),
                        rs.getInt("jumlah_film"), rs.getString("email"), rs.getBytes("image"));
                listDirektor.add(direktor);
                
            }
            
            
        }catch (Exception e){
            System.err.println("Read gagal " +e.getMessage());

        }
//        
        return listDirektor;
    }
    
    public ArrayList<User> getItemListUser(){
        
        listUser = new ArrayList<>();
        try{
            connect();
            ResultSet rs = stm.executeQuery("SELECT * FROM user");
            
            User user;
            while(rs.next()){
                user = new User(rs.getInt("id_user"), rs.getString("username"),
                        rs.getString("password"));
                listUser.add(user);
                
            }
            
            
        }catch (Exception e){
            System.err.println("Read gagal " +e.getMessage());

        }
//        
        return listUser;
    }
    
    public void Query(String inputan){
        
        try{
            connect();
            String sql = inputan;
            stm.execute(sql);
            
        }catch(Exception e){
            System.err.println("Read gagal " +e.getMessage());
        }
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
