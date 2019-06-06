$(function () {
    $("#student").click(function () {
        $("#for_student").css("display", "");
        $("#for_non_student").css("display", "none");

        $.get("city/getCityList", {}, function (data) {
            var lis = '<option value="0">请选择所在省市</option>';
            for (var i = 0; i < data.length; i++) {
                var li = '<option value="'+ data[i].cityName +'" id="'+ data[i].cid +'">'+ data[i].cityName +'</option>';
                lis += li;
            }
            $("#city").html(lis);
        });

    });



    $("#non_student").click(function () {
        $("#for_student").css("display", "none");
        $("#for_non_student").css("display", "");

    });
});

function selectUniversity(cName){
    $.get("university/getUniversityByCityName", {cName: cName}, function (data) {
        var lis = '<option value="0">请选择学校</option>';
        for (var i = 0; i < data.length; i++) {
            var li = '<option value="'+ data[i].universityName +'">'+ data[i].universityName +'</option>';
            lis += li;
        }
        $("#school").html(lis);
    })
}