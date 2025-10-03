<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remove Course</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input, select { width: 100%; padding: 8px; }
        button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
    </style>
</head>
<body>
<h2>Remove Course</h2>
<form action="${pageContext.request.contextPath}/course/remove" method="POST">
    <input type="hidden" id="action" name="action" value="remove">
    <div class="form-group">
        <label for="name">Name* : </label>
        <input type="text" id="name" name="name" required>
    </div>
    <button id="remove" type="submit">Remove Course</button>
</form>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const urlParams = new URLSearchParams(window.location.search);
        const success = urlParams.get('courseSuccess');
        if (success === "true") {
            alert("Course Added Successfully!");
        } else if (success === "false") {
            alert("Failed to add the Course!");
        }
    });
</script>
</body>
</html>