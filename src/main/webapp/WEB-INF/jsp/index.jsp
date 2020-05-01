<%--
  Created by Eclipse.
  User: zhaoyuan
  Date: 2020/04/29
  Time: 10:10 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>fill in a form and submit</title>
    <link rel="shortcut icon"
          href="${pageContext.request.contextPath}/images/shortcut.ico">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/js/layui/layui-v2.5.6/layui/css/layui.css"
          rel="external nofollow">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jQuery/jquery-1.8.3.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/layui/layui-v2.5.6/layui/layui.js"></script>
    <style type="text/css">
        .main{
            height: 92vh;
            width: 87vw;
            margin: 2em;
            /*border-style: solid;
            border-width: 1px;
            border-color: #0C0C0C;*/
        }
    </style>
</head>
<body>
    <div class="main">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">name</label>
                <div class="layui-input-block">
                    <input type="text" name="name" autocomplete="off" placeholder="请输入姓名" class="layui-input" lay-verify="required" lay-reqtext="姓名是必填项，岂能为空？">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">IdCard</label>
                <div class="layui-input-block">
                    <input type="text" name="idCard" lay-verify="identity" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">HouseholdRegister</label>
                <div class="layui-input-inline">
                    <select name="householdRegister0" lay-filter="selectfilter" lay-verify="required" lay-reqtext="市为必选项，岂能为空？">
                        <option value="">请选择市</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="householdRegister" lay-verify="required" lay-reqtext="区县为必选项，岂能为空？">
                        <option value="">请选择区县</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">IsLeaveGansu</label>
                <div class="layui-input-block">
                    <input type="radio" lay-verify="radioV" name="isLeaveGansu" value="0" title="no">
                    <input type="radio" lay-verify="radioV" name="isLeaveGansu" value="1" title="yes">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">isFever</label>
                <div class="layui-input-block">
                    <input type="radio" lay-verify="radioV" name="isFever" value="0" title="no">
                    <input type="radio" lay-verify="radioV" name="isFever" value="1" title="yes">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">PhoneNumber</label>
                    <div class="layui-input-inline">
                        <input type="tel" name="phoneNumber" lay-verify="required|phone" autocomplete="off" placeholder="请输入手机号" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">numberVerificationCode</label>
                <div class="layui-input-block">
                    <input type="text" name="numberVerificationCode" lay-verify="number" autocomplete="off" placeholder="请输入验证码" class="layui-input">
                    <button type="button" class="layui-btn layui-btn-xs layui-btn-normal" style="margin-top: 1em">获取验证码</button>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block" style="margin-top: 2em">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">submit</button>
                    <button type="reset" class="layui-btn layui-btn-primary">reset</button>
                </div>
            </div>
        </form>
    </div>
<script type="text/javascript">
    layui.use(['form'], function(){
        var form = layui.form
            ,layer = layui.layer

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })

            var loadIndex = layer.load(0, {shade: [0.1,'#fff']});

            $.ajax({
                url: '/statistics/insert',
                type: 'post',
                data: data.field,
                dataType: 'json',//预期的服务器响应的数据类型
                success: function (result) {
                    layer.close(loadIndex);
                    if (200 == result.status) {
                        //window.parent.location.reload();//刷新父页面
                        //清空表单
                        $(".layui-form")[0].reset();
                        layui.form.render();

                        var idCard = result.data.idCard;

                        //去生成的二维码页面
                        window.location.assign("/statistics/goCodePage/"+idCard);
                    } else {
                        layer.msg(result.msg);
                    }
                },
                error: function (data) {
                    layer.close(loadIndex);
                    layer.msg("未知错误");
                }
            })
            return false;
        });

        //表单赋值
        layui.$('#LAY-component-form-setval').on('click', function(){
            form.val('example', {
                "username": "贤心" // "name": "value"
                ,"password": "123456"
                ,"interest": 1
                ,"like[write]": true //复选框选中状态
                ,"close": true //开关状态
                ,"sex": "女"
                ,"desc": "我爱 layui"
            });
        });

        //自定义验证规则
        form.verify({
            radioV : function() {
                var isLeaveGansuVal = $("input:radio[name='isLeaveGansu']:checked").val();
                var isFeverVal = $("input:radio[name='isFever']:checked").val();
                if(null == isLeaveGansuVal || null == isFeverVal){
                    return 'isLeaveGansuVal和isFeverVal为必选项';
                }
            }
        });

        /**
         * 加载户籍一级select下拉框
         */
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/area/getAreaList/0",
            dataType: "json",
            success: function (result) {
                var data = result.data;
                var status = result.status;

                if(200 == status){
                    var $select0 = $("select[name='householdRegister0']");
                    $.each(data, function(index, item) {
                        $select0.append(new Option(item.name,item.id));
                    });
                }
                //刷新select下拉框
                layui.form.render("select");
            },
            error: function () {
                $("select[name='householdRegister0']").html(new Option("服务器错误，暂无数据",0));
            }
        });

        //监听select选择事件
        form.on('select(selectfilter)', function(data){
            var value = data.value;

            $.ajax({
                url:"${pageContext.request.contextPath}/area/getAreaList/"+value,
                data:{parentId:value},
                dataType:"json",
                success:function(result){
                    var status = result.status;
                    var dataTj = result.data;

                    if(200 == status){
                        var $select = $("select[name='householdRegister']");
                        $select.empty();
                        $select.append(new Option("请选择区县",""));
                        $.each(dataTj, function(index, item) {
                            $select.append(new Option(item.name,item.code));
                        });
                    }
                    layui.form.render("select");
                },
                error : function(){
                    $("select[name='householdRegister']").html(new Option("服务器错误，暂无数据",""));
                }
            })
        });

    });

    /**
     * 校验手机号
     */
    $("input[name='phoneNumber']").blur(function(){
        var phoneNumber = $(this).val();
        var pattern = /^1[34578]\d{9}$/;
        var isPnumber = pattern.test(phoneNumber);
        if(!isPnumber){
            $(this).val("").focus();
            layer.msg('尼玛，手机号错误', {icon: 2});
        }
    });

    /**
     * 获取验证码
     */
    $("button[type='button']").click(function (){
        $("input[name='numberVerificationCode']").val("").focus();
        var phoneNumber = $("input[name='phoneNumber']").val();
        if("" == phoneNumber){
            layer.msg('尼玛，请先输入手机号', {icon: 2});
            return false;
        }
        var name = $("input[name='name']").val();
        $.ajax({
            url : '/verification/gene',
            type : 'post',
            data : {
                name:name,
                phoneNumber:phoneNumber
            },
            dataType : 'json',//预期的服务器响应的数据类型
            success : function(result) {
                var data = result.data;
                var status = result.status;
                if(200 == status){
                    var verificationCode = data.verificationCode;
                    console.log("code is:"+verificationCode);
                    alert("你的验证码为："+verificationCode);
                }else{
                    layer.msg("未知错误");
                }
            },
            error : function(data) {
                layer.msg("未知错误");
            }
        })
    });

</script>
</body>
</html>