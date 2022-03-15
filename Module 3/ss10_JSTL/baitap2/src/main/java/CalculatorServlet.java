import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Integer foperand = Integer.valueOf(request.getParameter("fname"));
       String operator = request.getParameter("operator");
       Integer soperand = Integer.valueOf(request.getParameter("soperand"));
       Integer result = null;
       switch (operator){
           case "+":
               result = foperand + soperand;
               break;
           case "-":
               result = foperand - soperand;
               break;
           case "x":
               result = foperand * soperand;
               break;
           case "%":
               result = foperand % soperand;
               break;
           default:
               request.setAttribute("error", "Ét o Ét");
       }
       request.setAttribute("result",result);
       request.setAttribute("foperand",foperand);
       request.setAttribute("soperand",soperand);
       request.setAttribute("operator",operator);
       request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
