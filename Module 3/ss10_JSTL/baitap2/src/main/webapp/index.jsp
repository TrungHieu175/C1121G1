<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/11/2022
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>

<h1>Simple Calculator</h1>

<form method="post" action="/CalculatorServlet">
  <fieldset>
    <legend>Calculator:</legend>
    <label for="fname">First operand:</label>
    <input type="text" id="fname" name="fname"><br><br>
    <label for="operator">Operator:</label>
    <select name="operator" id="operator">
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="x">x</option>
      <option value="%">%</option>
    </select><br><br>
      <label for="soperand">Second oprand:</label>
    <input type="soperand" id="soperand" name="soperand"><br><br>
    <input type="submit" value="Calculate">
  </fieldset>
</form>

</body>
</html>