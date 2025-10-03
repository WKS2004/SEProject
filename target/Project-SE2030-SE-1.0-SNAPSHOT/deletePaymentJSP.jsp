<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remove Payment</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input, select { width: 100%; padding: 8px; }
        button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>
<h2>Remove Payment</h2>
<form action="${pageContext.request.contextPath}/payment/remove" method="POST">
    <input type="hidden" id="action" name="action" value="remove">
    <div class="form-group">
        <label for="id">Payment ID* : </label>
        <input type="text" id="id" name="id" required>
    </div>
    <button id="remove" type="submit" disabled>Remove Payment</button>
</form>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const urlParams = new URLSearchParams(window.location.search);
        const success = urlParams.get('paymentSuccess');
        if (success === "true") {
            alert("Payment Removed Successfully!");
        } else if (success === "false") {
            alert("Failed to remove the Payment!");
        }
    });
</script>
</body>
</html>