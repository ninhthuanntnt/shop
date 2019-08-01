/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.DBUtil;
import Model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ShopDao {
    public ShopDao() {
    }
    
    public List<UserModel> findAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        String sql = "select * from user_info";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            ResultSet rs = pstmt.executeQuery();
            List<UserModel> list = new ArrayList<>();
            while(rs.next()){
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("address"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("password"));
                
                list.add(user);
            }
            return list;
        }
    }
    public boolean checkLogin(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            String sql = "select username,password from user_info where username = ? and password = ?";
            try(
                    Connection con = DBUtil.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    ){
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                ResultSet rs = pstmt.executeQuery();
                return rs.next();
            }
        }
    public boolean checkLoginForAdmin(String username, String password) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
            String sql = "select username,password from user_info where id = 1 and username = ? and password = ?";
            try(
                    Connection con = DBUtil.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    ){
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                ResultSet rs = pstmt.executeQuery();
                return rs.next();
            }
    }   
    public UserModel findByUsername(String username) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        String sql = "select * from user_info where username = ?";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAddress(rs.getString("address"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        }
    }   
        
    public void insertUserInfo(UserModel user) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String sql = "insert into user_info values (default, ?, ?, ?, ?)";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1,user.getFullname());
            pstmt.setString(2,user.getAddress());
            pstmt.setString(3,user.getUsername());
            pstmt.setString(4,user.getPassword());
            
            pstmt.executeUpdate();
        }
    }
    
    public void updateUserInfo(UserModel user) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        String sql = "update user_info set fullname = ?, address = ?, password = ? where username = ?";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, user.getFullname());
            pstmt.setString(2, user.getAddress());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getUsername());
            
            pstmt.executeUpdate();
        }
    }
    
    public void updatePassword(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String sql = "update user_info set password = ? where username = ?";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, password);
            pstmt.setString(2, username);
            
            pstmt.executeUpdate();
        }
    }
    
    public void deleteUserInfo(String username) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        String sql = "delete from user_info where username = ?";
        try(
                Connection con = DBUtil.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            UserModel user = this.findByUsername(username);
            
            pstmt.setString(1, user.getUsername());
            pstmt.executeUpdate();

        }
    }
}
