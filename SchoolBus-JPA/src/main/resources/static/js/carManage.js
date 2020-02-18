$(document).ready(function(){
    var grades = ['一年级','二年级','三年级','四年级','五年级','六年级',
        '初一','初二','初三','高一','高二','高三',];

    console.log('carManage.js')
    $("#btn_back").click(function(){
        alert('btn_back');
        $(".mb").hide();
        console.log($(".mb"))
        $(".editor").hide();
        console.log($(".editor"))
    });

    $('.close').click(function(){
        $(".mb").hide();
        $(".view").hide();
        $(".creat").hide();
        $(".editor").hide();
    });

    lay('#version').html('-v'+ laydate.v);
    //lay('#version').html('-v'+ layer.v);
    //时间选择器
    laydate.render({
        elem: '#rideTime'
    });

    laydate.render({
        elem: '#applyTime'
    });

    laydate.render({
        elem: '#endTime'
    });

});

function hiddenDiv() {
    $(".mb").hide();
    $(".view").hide();
    $(".creat").hide();
    $(".editor").hide();
}

function showAdd() {
    $(".mb").show();
    $(".creat").show();
}

function del(id) {
    layer.confirm('您确定要删除该统计表么', {
        btn: ['确认', '取消'] //可以无限个按钮
    }, function(index, layero){
        $.ajax({
            //请求方式
            type: "GET",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url: '/car/stastic/delete?id='+id,
            //数据，json字符串
            // data : JSON.stringify(data),
            //请求成功
            success: function (result) {
                layer.msg('删除成功!')
                window.location.reload();
            }
        });
    }, function(index){

    });
}

function save() {
    var id = $("#edit_id").val();
    var name = $("#edit_name").val();
    var rideTime = $("#edit_rideTime").val();
    var applyTime = $("#edit_applyTime").val();
    var endTime = $("#edit_endTime").val();
    //var rideGrade = $("#edit_rideGrade").val();
    var car = new Object();
    car.id = id;
    car.statisticName = name;
    car.rideTime = rideTime;
    car.applyTime = applyTime;
    car.endTime = endTime;
    car.rideGrade = '一年级';

    $.ajax({
        //请求方式
        type: "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        async: false,
        //请求地址
        url: '/car/stastic/update',
        //数据，json字符串
        data : JSON.stringify(car),
        //请求成功
        success: function (result) {
            layer.msg('更新成功!')

            $(".mb").hide();
            $(".editor").hide();

            window.location.reload();
        }
    });
}

function detail(id) {
   postData(id,1);
}

function edit(id) {
    postData(id,2);
}

// 加载数据，弹出显示
function postData(id,type) {
    console.log('postdata')
    var url = "/car/stastic/detail/"+id;
    $.ajax({
        //请求方式
        type : "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url : url,
        //数据，json字符串
        // data : JSON.stringify(data),
        //请求成功
        success : function(result) {
            console.log(result)
            // type == 2 编辑
            // 弹出页面
            var grade = result.data.grade;
            var viewHtml = '<div class="mboxhead">\n' +
                '            <span class="boxtitle">学生统计表</span>\n' +
                '            <div class="close"><i class="fa fa-close"></i></div>\n' +
                '        </div>\n' +
                '<form th:action="@{/car/stastic/update}">' +
                '        <table>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '                        <i class="fa fa-circle" style="color:red;transform: scale(0.5);"></i>' +
                '                        <span>学生统计表名称</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td><input type="hidden" id="edit_id" name="id" value="'+result.data.id+'" /><input style="width: 360px;" type="text" id="edit_name" name="name" value="'+result.data.statisticName+'" /></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +                '                        ' +
                '<i class="fa fa-circle" style="color:red;transform: scale(0.5);"></i>' +
                '                        <span>乘坐时间</span>\n' +
                '                    </div>\n' +
                '                </td>\n' + // value="'+result.data.rideTime+'"
                '                <td><input class="demo-input" type="text" name="rideTime" id="edit_rideTime" value="'+result.data.rideTime+'"></input></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '<i class="fa fa-circle" style="color:red;transform: scale(0.5);"></i>' +
                '                        <span>家长申请时间</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td> <input type="text" name="applyTime" id="edit_applyTime" value="'+result.data.applyTime+'"></input> ———— ' +
                '<input type="text" name="endTime" id="edit_endTime" value="'+result.data.endTime+'"></input></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '<i class="fa fa-circle" style="color:red;transform: scale(0.5);"></i>' +
                '                        <span>适用人群</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td></td>\n' +
                '            </tr>\n' +
                '        </table>';

            if(type == 2){
                viewHtml += '<div class="btn-bottom">\n' +
                    '    <div class="btn submit" id="btn_save" onclick="save();">保存</div>\n' +
                    '    <div class="btn cancel" id="btn_back" onclick="hiddenDiv();">取消</div>\n' +
                    '    </div>';
            }else{
                viewHtml += '<div class="btn-bottom">\n' +
                    '    <div class="btn submit" id="btn_back" onclick="hiddenDiv();">返回</div>' +
                    '</div>';

                // $("#dv_view").append(viewHtml);
                // $(".mb").show();
                // $(".view").show();
            }
            $("#dv_editor").empty();
            $("#dv_editor").append(viewHtml);

            //时间选择器
            laydate.render({
                elem: '#edit_rideTime'
            });
            laydate.render({
                elem: '#edit_applyTime'
            });

            laydate.render({
                elem: '#edit_endTime'
            });

            $(".mb").show();
            $(".editor").show();
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

