package dao;

import dto.MemberDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class MemberDAO {

    private static MemberDAO instance = null;

    public MemberDAO(){}
    public static synchronized MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }

    private Connection getConnection() throws Exception{
        Context iCtx = new InitialContext();
        BasicDataSource dataSource = (BasicDataSource)iCtx.lookup("java:/comp/env/jdbc/mysql");
        return dataSource.getConnection();
    }

    public MemberDTO createAccount(MemberDTO memberDTO) throws Exception {
        String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PW = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1, memberDTO.getId());
            preparedStatement.setString(2, memberDTO.getPw());
            try(ResultSet resultSet = preparedStatement.executeQuery();){
                return getMatchedAccount(resultSet);
            }
        }
    }

    private MemberDTO getMatchedAccount(ResultSet resultSet) throws Exception{
        if (resultSet.next()) {
            String id = resultSet.getString("ID");
            String pw = resultSet.getString("PW");
            String phone = resultSet.getString("PHONE");
            String email = resultSet.getString("EMAIL");
            String zipcode = resultSet.getString("ZIPCODE");
            String address1 = resultSet.getString("ADDRESS_1");
            String address2 = resultSet.getString("ADDRESS_2");
            Timestamp joinDate = resultSet.getTimestamp("JOIN_DATE");
            return new MemberDTO(id, pw, phone, email, zipcode, address1, address2, joinDate);
        } else {
            return new MemberDTO("계정없음", "", "", "", "", "", "", null);
        }
    }
}
