<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>ServletJson</title>  
<!-- 注意引入jquery -->  
<script src="jquery-3.2.1.min.js"></script>  
</head>  
<body>  
    <button onclick="ajaxSubmit()">查询</button>  
    <table border="1" id="data">  
    </table>  
</body>  
</html>  
<script>  
    function ajaxSubmit() {  
        $.ajax({  
            type : "post",  
            url : "jsonRequest",  
            dataType : "text",  
            success : function(data) {  
                data = eval(data);  
                //构造前先清空源节点  
                document.getElementById("data").innerHTML = "";  
                //设置一个文件碎片  
                var frag = document.createDocumentFragment();  
                //这是表头  
                var tr = document.createElement("tr");  
                tr.innerHTML = "<td>id</td><td>username</td><td>number</td>";  
                frag.appendChild(tr);  
                //利用循环构造表格的每一行，把其放在文件碎片上面  
                for (var i = 0; i < data.length; i++) {  
                    tr = document.createElement("tr");  
                    tr.innerHTML = "<td>" + data[i].id + "</td>" + "<td>"  
                            + data[i].username + "</td>" + "<td>"  
                            + data[i].number + "</td>"; 
                    frag.appendChild(tr);  
                }  
                //此时文件碎片已经是一张表了，直接放网页就可以了  
                document.getElementById("data").appendChild(frag);  
            },  
            error : function() {  
                alert("出错了");  
            }  
  
        });  
    }  
</script>  