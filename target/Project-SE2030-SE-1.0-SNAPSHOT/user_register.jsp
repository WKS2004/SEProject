<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register Portal</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    input, select { width: 100%; padding: 8px; }
    button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
  </style>
</head>
<body>
<h2>Register Portal</h2>
<form action="${pageContext.request.contextPath}/register" method="POST">
  <input type="hidden" id="action" name="action" value="register">
  <div class="form-group">
    <label for="userName">User Name* : </label>
    <input type="text" id="userName" name="userName" required>
  </div>
  <div class="form-group">
    <label for="password">Password* : </label>
    <input type="password" id="password" name="password" required>
  </div>
  <div class="form-group">
    <label for="email">Email* : </label>
    <input type="email" id="email" name="email" required>
  </div>
  <div class="form-group">
    <label for="firstName">First Name* : </label>
    <input type="text" id="firstName" name="firstName" required>
  </div>
  <div class="form-group">
    <label for="lastName">Last Name* : </label>
    <input type="text" id="lastName" name="lastName" required>
  </div>
  <div class="form-group">
    <label for="phoneNumber">Phone Number : </label>
    <input type="tel" id="phoneNumber" name="phoneNumber" onfocusout="validatePhoneNumber()" required>
  </div>
  <div class="form-group">
    <label for="address">Address* : </label>
    <input type="text" id="address" name="address" required>
  </div>
  <div class="form-group">
    <label for="role">Role* : </label>
    <select id="role" name="role" required>
      <option value="customer">Customer</option>
      <option value="supplier">Supplier</option>
    </select>
  </div>
  <button id="register" type="submit" disabled>Register</button>
</form>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const success = urlParams.get('registrationSuccess');
    if (success === "true") {
      alert("User Registered Successfully!");
    } else if (success === "false") {
      alert("User might be already registered!");
    }
  });

    function validatePhoneNumber() {
      let phoneNumber = document.getElementById("phoneNumber").value;
      let registerButton = document.getElementById("register");

      let validPhoneNumberPattern = /^\d{10,}$/;

      if (validPhoneNumberPattern.test(phoneNumber)) {
        registerButton.disabled = false;
        return true;
      }
      registerButton.disabled = true;
      alert("Invalid phone number!");
      return false;
    }
</script>
</body>
</html>
