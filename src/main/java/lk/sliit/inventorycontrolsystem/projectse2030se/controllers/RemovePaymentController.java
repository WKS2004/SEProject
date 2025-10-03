package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.payment.PaymentRequestDeleteDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.PaymentServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/payment/remove")
public class RemovePaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");

        PaymentServices paymentServices = new PaymentServices();
        PaymentRequestDeleteDTO paymentRequestDeleteDTO = new PaymentRequestDeleteDTO(title);

        boolean success = paymentServices.deletePayment(paymentRequestDeleteDTO);
        response.sendRedirect(success ? request.getContextPath() + "/payment/remove?success=true" : request.getContextPath() + "/payment/remove?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/deletePaymentJSP.jsp").forward(request, response);
    }
}
