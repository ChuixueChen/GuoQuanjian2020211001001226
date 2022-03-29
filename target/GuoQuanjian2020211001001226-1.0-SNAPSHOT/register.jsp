<%--
  Created by IntelliJ IDEA.
  User: Guo Quanjian
  StudentID: 2020211001001226
  Date: 2022/3/3
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
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
    <script>
        window.onload = function () {
            document.getElementById("username").onblur = checkUsername
            document.getElementById("password").onblur = checkPassword
            document.getElementById("Email").onblur = checkEmail
            document.getElementById("Birthdate").onblur = checkBirthdate
            var tipUsername = document.getElementById("tipUsername")
            var tipPassword = document.getElementById("tipPassword")
            var tipEmail = document.getElementById("tipEmail")
            var tipBirthDate = document.getElementById("tipBirthDate")
            document.getElementById("userForm").onsubmit = function () {
                if ((checkUsername() && checkPassword() && checkEmail() && checkBirthdate()) == false) {
                    alert("请输入正确的表单信息!")
                    return
                }
            }
            function checkUsername() {
                var username = document.getElementById("username").value
                if (username != "") {
                    tipUsername.innerHTML = `<p style="color: yellowGreen;">success</p>`;
                    return true
                } else {
                    tipUsername.innerHTML = `<p style="color: red;">Please input a username!</p>`
                    return false
                }
            }
            function checkPassword() {
                var password = document.getElementById("password").value
                if (password == "") {
                    tipPassword.innerHTML = `<p style="color: red;">Please input a password</p>`
                    return false
                } else if (password.length < 8) {
                    tipPassword.innerHTML = `<p style="color: red;">The password consists of at least 8 characters.</p>`
                    return false
                } else {
                    tipPassword.innerHTML = `<p style="color: yellowGreen;">success</p>`
                    return true
                }
            }
            function checkEmail() {
                var email = document.getElementById("Email").value;
                var reg_email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
                var flag = reg_email.test(email);
                if (flag) {
                    tipEmail.innerHTML = `<p style="color: yellowGreen;">success</p>`
                } else {
                    tipEmail.innerHTML = `<p style="color: red;">Please enter a legal email address</p>`
                }
                return flag
            }
            function checkBirthdate() {
                var Birthdate = document.getElementById("Birthdate").value;
                var reg_birthdate = Birthdate.match(/^(\d{1,4})(-)(\d{1,2})(-)(\d{1,2})$/);
                if (reg_birthdate == null) {
                    tipBirthDate.innerHTML = `<p style="color: red;">The data entered is illegal！</p>`
                    Birthdate = ""
                    return false
                } else if (reg_birthdate[3] > 12 || reg_birthdate[5] > 31) {
                    tipBirthDate.innerHTML = `<p style="color: red;">The data entered is illegal！</p>`
                    Birthdate = ""
                    return false
                } else {
                    tipBirthDate.innerHTML = `<p style="color: yellowGreen;">success</p>`
                }

                return true
            }
        }
    </script>
</head>

<body>
<%@include file="header.jsp"%>
<div class="page">
    <div class="top">
        <div class="register_container">
            <p class="register_text">New User Registration</p>
        </div>
    </div>
    <form action="register" method="post" id="userForm">
        <div class="middle">
            <div class="form_element">
                <div class="middle_single">
                    <div class="middle_single_left">
                        <span class="star">*</span>
                        <span>Username：</span>
                        <input type="text" name="username" id="username" placeholder="username">
                    </div>
                    <div class="middle_single_right" id="tipUsername">
                    </div>
                </div>
                <div class="middle_single">
                    <div class="middle_single_left">
                        <span class="star">*</span>
                        <span>Password：</span>
                        <input type="password" name="password" id="password" placeholder="password">
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
                        <input type="text" name="Email" id="Email" placeholder="Email">
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
                        <input type="radio" name="gender" id="male" value="male" checked><label for="male">male</label>
                        <input type="radio" name="gender" id="female" value="female"><label for="female">female</label>
                    </div>
                    <div class="middle_single_right">
                        <!-- Please choose your gender -->
                    </div>
                </div>
                <div class="middle_single">
                    <div class="middle_single_left">
                        <span class="star">*</span>
                        <span>Birthdate：</span>
                        <input type="text" name="Birthdate" id="Birthdate" placeholder="Date of Birth (yyyy-MM-dd)">
                    </div>
                    <div class="middle_single_right" id="tipBirthDate">
                        <!-- Please fill in your date of birth. The format must be "yyyy-MM-dd" -->
                    </div>
                </div>
                <div class="middle_single">
                    <div class="middle_single_left">
                        <input type="submit" value="Register" class="submitbutton">
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>

</html>
