package com.dayuarchi.custom.newbatis.v2;

import com.dayuarchi.custom.newbatis.v1.domain.UserDomain;

import java.sql.*;

public class GPSimpleExecutor implements GPExecutor {

    private final GPConfiguration configuration;

    public GPSimpleExecutor(GPConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(String statement, String parameter) {
        //这里可以直接去执行jdbc即可
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        UserDomain userDomain = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&charset=utf-8");
            statement = String.format(statement,Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userDomain = new UserDomain();
                userDomain.setId(resultSet.getInt(1));
                userDomain.setName(resultSet.getString(2));
                userDomain.setAge(resultSet.getInt(3));
                userDomain.setDesc(resultSet.getString(4));
            }
            return (T)userDomain;
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(resultSet != null){
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

    @Override
    public <T> T query(String statement, String parameter, Class<T> type) {
        //初始化StatementHandler-->ParameterHandler-->ResultSetHandler
        GPStatementHandler statementHandler = new GPStatementHandler(configuration);
        try {
            return statementHandler.query(new GPMapperData(statement,type),parameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
