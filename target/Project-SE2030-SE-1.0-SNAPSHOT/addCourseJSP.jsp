<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Course</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    input, select { width: 100%; padding: 8px; }
    button { background-color: #4a90e2; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
  </style>
</head>
<body>
<h2>Add Course</h2>
<form action="${pageContext.request.contextPath}/course/add" method="POST">
  <input type="hidden" id="action" name="action" value="add">
  <div class="form-group">
    <label for="name">Name* : </label>
    <input type="text" id="name" name="name" required>
  </div>
  <div class="form-group">
    <label for="code">Code* : </label>
    <input type="text" id="code" name="code" required>
  </div>
  <div class="form-group">
    <label for="description">Description* : </label>
    <input type="text" id="description" name="description" required>
  </div>
  <div class="form-group">
    <label for="duration">Duration* : </label>
    <input type="text" id="duration" name="duration" required>
  </div>
  <div class="form-group">
    <label for="price">Price* : </label>
    <input type="text" id="price" name="price" value="0" disabled>
  </div>
  <div class="form-group">
    <label for="level">Course Level* : </label>
    <select id="level" name="level" required>
      <option value="beginner">Beginner</option>
      <option value="intermediate">Intermediate</option>
      <option value="advanced">Advanced</option>
    </select>
  </div>
  <button id="add" type="submit">Add Course</button>
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