<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.GuoQuanjian.model.User" %>
<%@include file="header.jsp"%>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    .star {
        color: #fb136f;
    }

    .top {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 200px;
    }

    .register_container {
        position: relative;
        width: 80%;
        height: 60%;
        border-bottom: 5px solid #ff6700;
    }

    .register_img {
        width: 96px;
        height: 96px;
        margin-top: 32px;
    }

    .register_text {
        position: absolute;
        display: block;
        left: 90px;
        top: 55px;
        font-family: STFangsong;
        font-size: 48px;
        color: #ff6700;
    }

    .middle {
        width: 100%;
        height: 300px;
    }

    .form_element {
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
        width: 90%;
        margin-left: 5%;
        height: 300px;

    }

    .middle_single {
        display: flex;
        justify-content: center;
        width: 100%;
    }


    .middle_single_left {
        display: flex;
        justify-content: flex-end;
        width: 40%;
    }

    input {
        height: 20px;
        margin: 0 10px 0 10px;
    }

    .middle_single_right {
        font-size: 14px;
        width: 57%;
        margin-left: 3%;
    }

    .submitbutton {
        width: 160px;
        height: 60px;
        color: #fff;
        background-color: #ff6700;
        border: 0;
        transform: translateX(-150px);
        font-size: 24px;
        border-radius: 10px;
    }
</style>
<h1>User Update</h1>
<%
    User u=(User)session.getAttribute("user");
%>
<form action="updateUser" method="post">
    <div class="middle">
        <div class="form_element">
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <div class="middle_single">
                <div class="middle_single_left">
                    <span class="star">*</span>
                    <span>Username：</span>
                    <input type="text" name="username" id="username" value="<%=u.getUsername()%>" placeholder="username">
                </div>
                <div class="middle_single_right" id="tipUsername">
                </div>
            </div>
            <div class="middle_single">
                <div class="middle_single_left">
                    <span class="star">*</span>
                    <span>Password：</span>
                    <input type="password" name="password" id="password" value="<%=u.getPassword()%>" placeholder="password">
                </div>
                <div class="middle_single_right" id="tipPassword">
                    <!-- The password consists of at least 8 characters. For your safety, you'd better use the
                    combination of English letters and numbers or symbols. -->
                </div>
            </div>
            <div class="middle_single">
                <div class="middle_single_left">
                    <span class="star">*</span>
                    <span>E-mail：</span>
                    <input type="text" name="Email" id="Email" value="<%=u.getEmail()%>" placeholder="Email">
                </div>
                <div class="middle_single_right" id="tipEmail">
                    <!-- Please fill in your correct email address, otherwise you cannot activate your account, which
                    will help you retrieve your password or use more functions. -->
                </div>
            </div>
            <div class="middle_single">
                <div class="middle_single_left">
                    <span class="star">*</span>
                    <span>Gender：</span>
                    <input type="radio" name="gender" id="male" value="male" <%="male".equals(u.getGender())?"checked":""%>><label for="male">male</label>
                    <input type="radio" name="gender" id="female" value="female"  <%="female".equals(u.getGender())?"checked":""%>><label for="female">female</label>
                </div>
                <div class="middle_single_right">
                    <!-- Please choose your gender -->
                </div>
            </div>
            <div class="middle_single">
                <div class="middle_single_left">
                    <span class="star">*</span>
                    <span>Birthdate：</span>
                    <input type="text" name="Birthdate" id="Birthdate" value="<%=u.getBirthDate()%>" placeholder="Date of Birth (yyyy-MM-dd)">
                </div>
                <div class="middle_single_right" id="tipBirthDate">
                    <!-- Please fill in your date of birth. The format must be "yyyy-MM-dd" -->
                </div>
            </div>
            <div class="middle_single">
                <div class="middle_single_left">
                    <input type="submit" value="Update" class="submitbutton">
                </div>
            </div>
        </div>
    </div>
</form>
<%@include file="footer.jsp"%>