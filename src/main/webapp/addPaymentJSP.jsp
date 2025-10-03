<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Payment</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    input, select { width: 100%; padding: 8px; }
    button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
  </style>
</head>
<body>
<h2>Add Payment</h2>
<form action="${pageContext.request.contextPath}/payment/add" method="POST">
  <input type="hidden" id="action" name="action" value="add">
  <div class="form-group">
    <label for="currency">Currency* : </label>
    <select id="currency" name="currency" required>
      <option value="rs">Rs.</option>
      <option value="usd">USD</option>
    </select>
  </div>
  <div class="form-group">
    <label for="amount">Amount* : </label>
    <input type="number" id="amount" name="amount" required>
  </div>
  <div class="form-group">
    <label for="paymentMethod">Payment Method* : </label>
    <select id="paymentMethod" name="paymentMethod" required>
      <option value="cash">Cash</option>
      <option value="card">Card</option>
      <option value="cashOnDelivery">Cash On Delivery</option>
    </select>
  </div>
  <button id="add" type="submit">Add Payment</button>
</form>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const success = urlParams.get('paymentSuccess');
    if (success === "true") {
      alert("Payment Done Successfully!");
    } else if (success === "false") {
      alert("Payment Failed!");
    }
  });
</script>
</body>
</html>