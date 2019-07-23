package com.dayuarchi.custom.newbatis.v2;

import com.dayuarchi.custom.newbatis.v1.domain.UserDomain;

import java.sql.*;

public class GPStatementHandler {
    private final GPConfiguration configuration;
    private final GPResultSetHandler resultSetHandler;

    public GPStatementHandler(GPConfiguration configuration) {
        this.configuration = configuration;
        this.resultSetHandler = new GPResultSetHandler(configuration);
    }

    public <E> E query(GPMapperData mapperData,Object parameter) throws Exception{
        //jdbc
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        UserDomain userDomain = null;
        ResultSet resultSet = null;
        String statement = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&charset=utf-8");
            preparedStatement = connection.prepareStatement(String.format(mapperData.getSql(),Integer.parseInt(String.valueOf(parameter))));
            preparedStatement.execute();
            return (E)resultSetHandler.handle(preparedStatement,mapperData);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
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
