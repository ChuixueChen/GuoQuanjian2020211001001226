<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button {
            margin-right: 4px;
        }
    </style>
    <script>
        window.onload = function () {
            var FristVal = document.getElementById('FristVal')
            var Enteraname = document.getElementById('Enteraname')
            var SecondVal = document.getElementById('SecondVal')
            var Length = document.getElementById('Length')
            var Result = document.getElementById('Result')
            var reset = document.getElementById('reset')
            FristVal.onblur = function () {
                var rex = /^[0-9]+$/;//正则表达式
                var flag = rex.test(FristVal.value);//通过表达式进行匹配
                if (!flag) {
                    alert('FristValue is not a number.')
                    FristVal.value = ""
                }
            }
            SecondVal.onblur = function () {
                var rex = /^[0-9]+$/;//正则表达式
                var flag = rex.test(SecondVal.value);//通过表达式进行匹配
                if (!flag) {
                    alert('SecondValue is not a number.')
                    SecondVal.value = ""
                }
            }
            Enteraname.onblur = function () {
                var rex = /^[0-9]+$/;//正则表达式
                var flag = rex.test(Enteraname.value);//通过表达式进行匹配
                if (flag) {
                    alert('Name is not valid.')
                    Enteraname.value = ""
                }
            }
            reset.onclick = function () {
                document.getElementById("myForm").reset()
            }
        }
    </script>
</head>
<body>
<form id="myForm" method="post" action="<%=request.getContextPath()%>/calServlet">
    <table>
        <tr>
            <td><span>Frist Val:</span></td>
            <td><input id="FirstVal" name="firstVal" type="text" value="${empty cookie.cFirstValue?"":cookie.cFirstValue.value}"></td>
            <td><span>Enter a name:</span></td>
            <td><input id="Enteraname" name="name" type="text" value="${empty cookie.cName?"":cookie.cName.value}">
            </td>
        </tr>
        <tr>
            <td><span>Second Val:</span></td>
            <td><input id="SecondVal" name="secondVal" type="text" value="${empty cookie.cSecondValue?"":cookie.cSecondValue.value}"></td>
            <td><span>Length:</span></td>
            <td><input id="Length" type="text" value="${empty cookie.cLength?"":cookie.cLength.value}"></td>
        </tr>
        <tr>
            <td><span>Result :</span></td>
            <td><input id="Result" type="text" value="${empty cookie.cResult?"":cookie.cResult.value}"></td>
        </tr>
    </table>
    <button name="action" type="hidden" value="add">Add</button>
    <button name="action" type="hidden" value="subtract">Subtract</button>
    <button name="action" type="hidden" value="multiply">Multiply</button>
    <button name="action" type="hidden" value="divide">Divide</button>
    <button name="action" type="hidden" value="computeLength">Compute Length</button>
    <button id="reset">Reset</button>

</form>
</body>
</html>
