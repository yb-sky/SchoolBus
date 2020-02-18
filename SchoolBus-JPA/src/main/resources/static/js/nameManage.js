$(document).ready(function(){
    console.log("namemanage")
    // init();
    divShow();

});

function init() {
    var param = new Object();
    param.page = 1;

    $.ajax({
        //请求方式
        type: "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        async: false,
        //请求地址
        url: '/car/stu/page?page=1&gradeId=1&classId=1',
        //数据，json字符串
        data : JSON.stringify(param),
        //请求成功
        success: function (result) {
            layer.msg('删除成功!')
            //window.location.reload();
        }
    });
}

function divShow(){
    $(".edit").click(function(){
        $(".mb").show();
        $(".editor").show();
    });
    $(".title").click(function(){
        $(".mb").show();
        $(".creat").show();
    });
    $(".show").click(function(){
        $(".mb").show();
        $(".view").show();
    });
    $('.close').click(function(){
        $(".mb").hide();
        $(".view").hide();
        $(".creat").hide();
        $(".editor").hide();
    });
}