
var arr = [];

function selectBypaperId() {
    var paperId = $("#paperId").val();
    $.ajax({
        type: "post",
        url: "selectByPaperId.action",
        data: {paperId: paperId},
        dataType: 'JSON',
        success: function (data) {
            $("#center").show();
            for (j = 0; j < arr.length; j++) {
                $("#t" + arr[j]).remove();
            }
            var i = 1;
            $(data).each(function (index, obj) {
                $("#GridView1").show();
                $("#GridView1").append(
                    "<tr style='background-color:#E3EAEB;'id='t" + i + "'><td align='center'><input id='' type='checkbox'/></td>" +
                    "<td align='center'><span>" + i + "</span></td>" +
                    "<td align='center'>" + obj.userName + "</td>" +
                    "<td align='center'>" + paperId + "</td>" +
                    "<td align='center'>" + obj.score + "</td>" +
                    "<td align='center'><input type='button' value='详情' onclick='detail("+obj.userName+")'></td>" +
                    "</tr>"
                );
                arr.push(i);
                i++;
            });

        },
        error: function () {
        }

    });
}
function detail(username) {
    $.ajax({
        type: "post",
        url: "userDetail.action",
        data: {username: username},
        dataType: "json",
        success: function (data) {
            $("#Label2").show().text("考生"+data.username+"详情如下:");
            $("#apende").remove();
            $("#userDetail").show().append(
                " <tr id='apende' style='color:Black;background-color:#DEDFDE;'>"+
                " <td align='center'>"+data.username+"</td>"+
                " <td align='center'>"+data.name+"</td>"+
                " <td align='center'>"+data.password+"</td>"+
                " <td align='center'>"+data.address+"</td>"+
                " <td align='center'>"+data.tel+"</td>"+
                " <td align='center'>"+data.education+"</td>"+
                " <td align='center'>"+data.school+"</td>"+
                " <td align='center'>"+data.speciality+"</td>"+
                " <td align='center'>"+data.gender+"</td></tr>"
            );

        },
        error: function () {
            alert("aaaaa")
            ;
        }


    });


}
function chan() {
    $("#Label2").hide()
    $("#GridView1").hide();
    $("#userDetail").hide()
    $("#apende").remove();
}