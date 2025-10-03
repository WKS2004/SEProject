package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.PaymentDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.PaymentDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment.PaymentRequestAddDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.PaymentMethod;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.PaymentServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/payment/add")
public class AddPaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currency = request.getParameter("currency");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("PaymentMethod");

        PaymentServices paymentServices = new PaymentServices();
        boolean success = false;
        if (paymentMethod.equals("cash")) {
            PaymentRequestAddDTO paymentRequestAddDTO = new PaymentRequestAddDTO(amount, currency, PaymentMethod.CASH);
            success = paymentServices.addPayment(paymentRequestAddDTO);
        }
        else if (paymentMethod.equals("card")) {
            PaymentRequestAddDTO paymentRequestAddDTO = new PaymentRequestAddDTO(amount, currency, PaymentMethod.CARD);
            success = paymentServices.addPayment(paymentRequestAddDTO);
        }
        else {
            PaymentRequestAddDTO paymentRequestAddDTO = new PaymentRequestAddDTO(amount, currency, PaymentMethod.CASH_ON_DELIVERY);
            success = paymentServices.addPayment(paymentRequestAddDTO);
        }

        response.sendRedirect(success ? request.getContextPath() + "/payment/add?success=true" : request.getContextPath() + "/payment/add?success=false");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/addPaymentJSP.jsp").forward(request, response);
    }
}
