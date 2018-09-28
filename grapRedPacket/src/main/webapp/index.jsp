<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <script src="js/jquery.js"></script>
</head>

<body>
<h2>模拟抢红包</h2>


<button id="grab">开始抢红包</button>
<script>
   $(function () {
      $('#grab').bind('click',function () {
          for(var i =0 ;i < 12000;i++){
              $.ajax({
                  "type":"GET",
                  "url":"/userRedPacket/grabRedPacket.do?redPacketId=1&userId="+i,
                  "dataType":"json",
                  "timeout":100000000,
                  success:function(result){

                  }
              })
          }

      })
   });

</script>
</body>
</html>
