<DOCTYPE html>
<html>
  <head>
    <title><%= title %></title>
    <link rel='stylesheet' href='../stylesheets/style.css' />
  </head>
  <body>
  	<!--form method="post" action="submit">
  		<input type="text" name="Name"/>
			<select name="gender">
				<option value="m" selected="selected">Male</option>
				<option value="w">Female</option>
				<option value="u">Other</option>
			</select>
  		<input type="submit" value="Submit"/>
  	</form-->

  	<form method="post" action="submit">
  <input name="subject" type="hidden" value="Class" />
  <fieldset><legend>Academic information</legend>
    <label for="degree">Degree</label>
    <select name="degree" id="degree">
      <option value="BA">Bachelor of Art</option>
      <option value="BS">Bachelor of Science</option>
      <option value="MBA" selected="selected">Master of
        Business Administration</option>
    </select>
    <br />
    <label for="studentid">Student ID</label>
    <input type="password" name="studentid" />
  </fieldset>
  <fieldset><legend>Personal Details</legend>
    <label for="fname">First Name</label>
    <input type="text" name="fname" id="fname" />
    <br />
    <label for="lname">Last Name</label>
    <input type="text" name="lname" id="lname" />
       <br />
     Gender: 
     <input name="gender" type="radio" id="gm" value="m" />
     <label for="gm">Male</label>
     <input name="gender" type="radio" id="gf" value="f" />
     <label for="gf">Female</label>
   <br />
    <label for="email">Email</label>
    <input type="text" name="email" id="email" />
 </fieldset>
   <p>
<textarea name="terms" cols="30" rows="4" readonly="readonly">TERMS AND CONDITIONS...</textarea>
</p> <p>
    <input type="submit" name="submit" value="Send Form" />
    <input type="reset" value="Clear Form" />
  </p>
</form>
  </body>
</html>