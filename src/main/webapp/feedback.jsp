
<%@page import="java.util.Collections"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="asd.demo.model.Feedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="asd.demo.controller.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Feedback</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Nunito:400,300,700'>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <%
        String emptyErr = request.getParameter("empty");
        // Create a collection of all available countries
        ArrayList<String> countries = new ArrayList<String>();

        // Map ISO countries to custom country object
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {

            Locale locale = new Locale("", countryCode);
            String name = locale.getDisplayCountry();

            countries.add(name);
        }

        // Sort countries
        Collections.sort(countries);

        ArrayList<String> enqueryTypes = new ArrayList<String>();
        enqueryTypes.add("Fare pricing enquery");
        enqueryTypes.add("Default fare enquiry");
        enqueryTypes.add("General feedback");
        enqueryTypes.add("Other");
        enqueryTypes.add("Complaint - Opal Card Order");
        enqueryTypes.add("Complaint - Opal Equipment");
        enqueryTypes.add("Complaint - Opal Fares");
        enqueryTypes.add("Complaint - Opal Website");
        enqueryTypes.add("Complaint - Other");
        enqueryTypes.add("Opal Travel App Feedback ");

    %>

    <body>

        <div class="row">
            <form action="${pageContext.request.contextPath}/FeedbackServlet" method="post">
                <p class="title">Feedback Details:  </p>&emsp;<span class="error"> <c:if test="${emptyErr!=null}"><c:out value="${emptyErr}"/></c:if></span>
                    <div class="form-group" id="opalCradNo">
                        <input type="text" class="form-input" name="opalCardNo" minlength="16" maxlength="16" placeholder="Opal Card No (16 digit)" required="true">
                    </div>
                    <div class="form-group" id="firstName">
                        <input type="text" class="form-input" name="firstName" placeholder="First Name">
                    </div>
                    <div class="form-group" id="lastName">
                        <input type="text" class="form-input" name="lastName" placeholder="Last Name">
                    </div>
                    <div class="form-group" id="address">
                        <input type="text" class="form-input" name="address" placeholder="Address">
                    </div>
                    <div class="form-group" id="street1">
                        <input type="text" class="form-input" name="street1" placeholder="Street 1">
                    </div>

                    <div class="form-group" id="street2">
                        <input type="text" class="form-input" name="street2" placeholder="Street 2">
                    </div>
                    <div class="form-group" id="city">
                        <input type="text" class="form-input" name="city" placeholder="City/Suburb">
                    </div>

                    <div class="form-group" id="pinCode">
                        <input type="text" class="form-input" name="pinCode" placeholder="Postcode">
                    </div>

                    <div class="form-group" id="state">
                        <input type="text" class="form-input" name="state" placeholder="State">
                    </div>
                        <div class="form-group" id="email">
                        <input type="text" class="form-input" name ="email" placeholder="Email">
                    </div>
                    <div class="form-group" id="country">
                        <select  id="country" name="country" class="form-input-select" style="width: 50%">
                        <%for (String c : countries) {%>
                        <option value="<%=c%>"><%=c%></option>
                        <%}%>

                    </select>
                </div>
                <div class="form-group" id="enqueryType">
                    <select  id="enqueryType" name="enqueryType" class="form-input-select" style="width: 50%">
                        <%for (String enq : enqueryTypes) {%>
                        <option value="<%=enq%>"><%=enq%></option>
                        <%}%>

                    </select>
                </div>
                <div class="form-group" id="enquery">
                    <textarea required="true" rows="5" minlength="2" class="form-textarea" name="enquery"></textarea>
                </div>
                <div class="form-group">
                    <input type="submit" value="Post" class="login-button" id="post" />                    
                </div>
            </form>         
        </div>        

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
        <script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>       
    </body>

</html>
