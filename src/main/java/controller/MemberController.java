package controller;

import dao.MemberDAO;
import dto.MemberDTO;
import exceptions.AccountFormatException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.Timestamp;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getRequestURI();
        try {
            if (command.equals("createAccount.member")) {
                String id = request.getParameter("joinId");
                String pw = request.getParameter("joinPw");
                String name = request.getParameter("joinName");
                String phone = request.getParameter("joinPhone");
                String email = request.getParameter("joinEmail");
                String zipcode = request.getParameter("joinZipcode");
                String address1 = request.getParameter("joinAddress1");
                String address2 = request.getParameter("joinAddress2");
                MemberDAO.getInstance().createAccount(new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
            }

        } catch (AccountFormatException e) {
            throw new AccountFormatException("아이디 생성 조건을 다시 확인해주세요.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
