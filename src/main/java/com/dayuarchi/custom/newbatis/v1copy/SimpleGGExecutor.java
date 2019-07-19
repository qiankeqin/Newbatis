package com.dayuarchi.custom.newbatis.v1copy;

import com.dayuarchi.custom.newbatis.v1copy.domain.UserDomain;

import java.sql.*;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2019-07-19 11:43
 */
public class SimpleGGExecutor implements GGExecutor {
    @Override
    public <T> T query(String statement, String parameter) {
        //调用jdbc操作数据库
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&charset=utf-8");
            statement = String.format(statement,Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                UserDomain userDomain = new UserDomain();
                userDomain.setId(resultSet.getInt(1));
                userDomain.setName(resultSet.getString(2));
                return (T)userDomain;
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}