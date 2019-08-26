var userAnswer;
var arr = [];

function select() {
    var username = $("#username").val();
    $.ajax({
        type: "post",
        url: "selectPaper.action",
        data: {username: username},
        dataType: "JSON",
        success: function (data) {
            userAnswer = data;
            // 考号为:200831618152试卷号:XHG20080305
            $("#paperAndUsername").show();
            $(data).each(function (index, obj) {
                $("#Label23").text("考号为：" + obj.userName + "试卷号为：" + obj.testpaperId);
                return;
            })

        },
        error: function () {

        }

    });

}

function readPaper() {
    if (userAnswer != '' && userAnswer != null) {
        $("#answer").show().html("");
        $("#userPaper").show()
        $(userAnswer).each(function (index, obj) {

            $("#answer").append(
                "<tr><td style='width: 100%'><span id='GridView3_ctl04_Label16'style='color:Black;'>" +
                (index + 1) + "</span><span style='color:Black;'>" + "、" + obj.questionContent + " </span></td></tr>" +
                "<tr><td style='width: 100%'><span style='color:Red;'>标答:</span> <span style='color:Black;'>" +
                obj.correctAnswer + " </span></td></tr>" +
                " <tr><td style='width: 100%'><spanstyle='display:inline-block;color:Red;width:72px;'>考生解答:</span> <span  style='color:Black;'>" +
                obj.userAnswer + "</span></td></tr>" +
                "<tr><td style='width: 100%; height: 38px;'><span style='color:Red;'>得分:</span> <input type='text'  name='' class='readEnd' onblur='readOne(this)' questionId='" + obj.questionId + "' style='width:34px;'/> </td></tr>"
            );
        });
        $("#answer").append("<tr style='background-color: white'><td><button onclick='commit()'>完成</button></td></tr>")
    }
}

function readOne(obj) {
    var questionId = $(obj).attr("questionId");
    var username = $("#username").val();
   var readEnd1 = readEnd(username,questionId,obj.value);
    // arr.push("{'username'：" + username + ",'questionId':" + questionId + ',"score":' + obj.value + '}')
    arr.push(readEnd1);
    return;
}
function commit() {
 var json = JSON.stringify(arr);
    $.post("readEnd.action",{json:json},function (data) {
       if (data==1){
           alert("阅卷完成!");
           window.location.href="/admin/toReadPaper.action";
       }
    },'JSON');
}
function readEnd(username,questionId,score) {
    var obj=new Object();
    obj.username=username;
    obj.questionId=questionId;
    obj.score=score;
    return obj;
}