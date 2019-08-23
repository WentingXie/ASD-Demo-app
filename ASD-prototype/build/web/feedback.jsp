<%-- 
    Document   : feedback
    Created on : 2019-8-18, 18:25:53
    Author     : suyixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Opal Card Feedback Form</title>
	<script src="feedbackformvalidation.js"></script>
	<script>
	required.add('Name','NOT_EMPTY','Name');
	required.add('Email','EMAIL','Email');
	required.add('Subject','NOT_EMPTY','Subject');
	required.add('Message','NOT_EMPTY','Message');
	required.add('AntiSpam','NOT_EMPTY','Anti-Spam Question');
	
	function checkMessageCount() {
		var maxlen = 1000;
		var len = document.getElementById('Message').value.length;
		document.getElementById('charsleft').innerHTML = 'You have ' + (maxlen - len) + ' characters remaining';
	}

	</script>
	<link rel="stylesheet" type="text/css" href="feedbackform.css">
	</head>
	<body>
<div class="feedback"><div class="feedback-default">
<form accept-charset="utf-8" name="feedbackform" method="post" action="feedbackformprocess.php" onsubmit="return validate.check(this)">
<table border="0">
<tr>
 <td colspan="2">
  <h2>Opal Card feedback form</h2>
  <p class="feedback_comments">An asterisk (<span class="required_star"> * </span>) indicates a mandatory field.</p><br />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="Name">Name<span class="required_star"> * </span></label>
 </td>
 <td valign="top">
  <input class="feedback_text" type="text" name="Name" id="Name" maxlength="100" />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="Email">Email<span class="required_star"> * </span></label>
 </td>
 <td valign="top">
  <input class="feedback_textbig" type="text" name="Email" id="Email" maxlength="100" />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="OpalCardNumber">OpalCardNumber</label>
 </td>
 <td valign="top">
  <input class="feedback_text" type="text" name="OpalCardNumber" id="OpalCardNumber" maxlength="16" />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="Phone">Phone</label>
 </td>
 <td valign="top">
  <input class="feedback_textbig" type="text" name="Phone" id="Phone" maxlength="10" />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="Subject">Subject<span class="required_star"> * </span></label>
 </td>
 <td valign="top">
  <input class="feedback_text" type="text" name="Subject" value="General Feedback" id="Subject" maxlength="50" />
 </td>
</tr>
<tr>
 <td valign="top">
  <label for="Message">Message<span class="required_star"> * </span></label>
 </td>
 <td valign="top">
  <textarea class="feedback_textarea" name="Message" id="Message" maxlength="1000" onKeyUp="checkMessageCount()" /></textarea>
  <br />
  <div id="charsleft" class="feedback_comments">You have 1000 characters remaining</div>
 </td>
</tr>
<tr>
 <td colspan="2" style="text-align:center" >
  <div class="antispammessage">
  To help prevent automated spam, please answer this question
  <br /><br />
	  <div class="antispamquestion">
	   <span class="required_star"> * </span>
	   Using only numbers, what is 8 plus 2? &nbsp; 
	   <input type="text" name="AntiSpam" id="AntiSpam" maxlength="100" style="width:30px">
	  </div>
  </div>
 </td>
</tr>
<tr>
 <td colspan="2" align="center">
  <br /><br />
  <input type="text" id="url" name="url" />
  <input type="submit" value="Submit Feedback" id="form_submit_button" class="feedback_button" />
  <br /><br />
  <div style="font-size:0.9em"><a href="" target="_blank"></a> </div>
  <br /><br />
 </td>
</tr>
</table>
</form>
</div></div>
</body>
</html>
