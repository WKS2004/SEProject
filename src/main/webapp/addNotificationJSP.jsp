<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Notification</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input, select { width: 100%; padding: 8px; }
        button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>
<h2>Add Notification</h2>
<form action="${pageContext.request.contextPath}/notification/add" method="POST">
    <input type="hidden" id="action" name="action" value="add">
    <div class="form-group">
        <label for="title">Title* : </label>
        <input type="text" id="title" name="title" required>
    </div>
    <div class="form-group">
        <label for="message">Message* : </label>
        <input type="text" id="message" name="message" required>
    </div>
    <div class="form-group">
        <label for="message">Type* : </label>
        <input type="text" id="message" name="message" required>
    </div>
    <div class="form-group">
        <label for="targetGroup">Target Group* : </label>
        <select id="targetGroup" name="targetGroup" required>
            <option value="owner">Business Owner</option>
            <option value="customer">Customer</option>
            <option value="inventoryManager">Inventory Manager</option>
            <option value="salesManager">Sales Manager</option>
            <option value="supplier">Supplier</option>
            <option value="systemAdmin">System Admin</option>
            <option value="warehouseManager">Warehouse Manager</option>
        </select>
    </div>
    <button id="add" type="submit">Add Notification</button>
</form>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const urlParams = new URLSearchParams(window.location.search);
        const success = urlParams.get('notificationSuccess');
        if (success === "true") {
            alert("Notification Added Successfully!");
        } else if (success === "false") {
            alert("Failed to add Notification!");
        }
    });
</script>
</body>
</html>