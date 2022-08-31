<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <title>USers Table</title>
  </head>

  <body>

    <form>
      <div class="block">

        <!-- first_name, dob, height -->
        <label for="first_name">First Name
          <input name="first_name" id="first_name" type="text" placeholder="e.g First Name like Cephas">
        </label>

        <label for="date_of_birth">
          <input name="date_of_birth" id="date_of_birth" type="date" placeholder="e.g Date of Birth like 2020-08-08">

          <span>Date of Birth</span>
        </label>

        <label for="height">Height
          <input name="height" id="height" type="number" placeholder="e.g Height like 1.80">
        
        </label>

      </div>
    </form>

  </body>

</html>