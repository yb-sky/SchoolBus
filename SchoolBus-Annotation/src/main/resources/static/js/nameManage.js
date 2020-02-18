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

function del(id) {
    layer.confirm('您确定要删除该学生么？', {
        btn: ['确认', '取消'] //可以无限个按钮
    }, function(index, layero){
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url: '/car/stu/delete/'+id,
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

// 加载数据，弹出显示
function edit(id) {
    console.log('postdata')
    var url = "/car/stu/detail/"+id;
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
            var gradeId = result.data.carApplicant.gradeId;
            var classId = result.data.carApplicant.classId;
            var gradeMap = result.data.gradeMap;
            var classMap = result.data.classMap;

            var viewHtml = '<table>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '                        <span class="name">年级</span><input type="hidden" id="edit_id" name="edit_id" value="'+result.data.carApplicant.id+'" />\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td><div>\n' +
                '                            <select id="edit_gradeId" name="edit_gradeId">\n' ;
            var gradeOption = '';
                                for(var key in gradeMap) {
                                    console.log(key, gradeMap[key]);
                                    gradeOption +='<option value="'+key+'"';
                                    if(gradeId == key){
                                        gradeOption += 'selected="selected"'; //默认选中
                                    }
                                    gradeOption += '>'+gradeMap[key]+'</option>';
                                }

                viewHtml+=' <option value="">请选择</option>\n' + gradeOption +
                '                                </select>\n' +
                '                        </div></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '                        <span class="name">班级</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td><div>\n' +
                '                            <select id="edit_classId" name="edit_classId">\n';
                                            var classOption = '';
                                            for(var key in classMap) {
                                                classOption +='<option value="'+key+'"';
                                                if(classId == key){
                                                    classOption += 'selected="selected"'; //默认选中
                                                }
                                                classOption += '>'+classMap[key]+'</option>';
                                            }

                viewHtml+=' <option value="">请选择</option>\n' + classOption +
                '                            </select>\n' +
                '                        </div></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '                        <span class="name">学生</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td><input type="text" name="edit_studentName" id="edit_studentName" value="'+result.data.carApplicant.studentName+'" /></td>\n' +
                '            </tr>\n' +
                '            <tr>\n' +
                '                <td>\n' +
                '                    <div>\n' +
                '                        <span class="name">乘坐地点</span>\n' +
                '                    </div>\n' +
                '                </td>\n' +
                '                <td>\n' +
                '                    <textarea id="edit_ridePlace" name="edit_ridePlace" >'+result.data.carApplicant.ridePlace+'</textarea></td>\n' +
                '            </tr>\n' +
                '        </table>\n' ;

            viewHtml += '<div class="btn-bottom">\n' +
                '    <div class="btn submit" id="btn_save" onclick="save();">保存</div>\n' +
                '    <div class="btn cancel" id="btn_back" onclick="hiddenDiv();">取消</div>\n' +
                '    </div>';

            $("#dv_editor").empty();
            $("#dv_editor").append(viewHtml);

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


function save() {
    /*var ok = false;
    layer.confirm('您确定要删除该统计表么', {
        btn: ['确认', '取消'] //可以无限个按钮
    }, function(index, layero){
        ok = true;
    }, function(index){

    });

    if(!ok){
        return;
    }*/

    var id = $("#edit_id").val();
    var name = $("#edit_studentName").val();
    var gradeOption = $("#edit_gradeId option:selected");
    var gradeId = gradeOption.val();
    var gradeName = gradeOption.text();

    var classOption = $("#edit_classId option:selected");
    var classId = classOption.val();
    var className = classOption.text();
    var ridePlace = $("#edit_ridePlace").val();

    var car = new Object();
    car.id = id;
    car.studentName = name;
    car.gradeId = gradeId;
    car.gradeName = gradeName;
    car.classId = classId;
    car.className = className;
    car.ridePlace = ridePlace;

    $.ajax({
        //请求方式
        type: "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        async: false,
        //请求地址
        url: '/car/stu/update',
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

function hiddenDiv() {
    $(".mb").hide();
    $(".editor").hide();
}
