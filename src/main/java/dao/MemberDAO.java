package dao;

import dto.MemberDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {

    private static MemberDAO instance = null;

    public MemberDAO() {
    }

    public static synchronized MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    private Connection getConnection() throws Exception {
        Context iCtx = new InitialContext();
        BasicDataSource dataSource = (BasicDataSource) iCtx.lookup("java:/comp/env/jdbc/mysql");
        return dataSource.getConnection();
    }

    public int createAccount(MemberDTO memberDTO) throws Exception {
        String sql = "INSERT INTO MEMBERS VALUES(0, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            preparedStatement.setString(3, memberDTO.getName());
            preparedStatement.setString(4, memberDTO.getPhone());
            preparedStatement.setString(5, memberDTO.getZipcode());
            preparedStatement.setString(6, memberDTO.getAddress1());
            preparedStatement.setString(7, memberDTO.getAddress2());
            return preparedStatement.executeUpdate();
        }
    }

}
